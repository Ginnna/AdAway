package org.adaway.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import org.adaway.R;
import org.adaway.helper.PreferenceHelper;
import org.adaway.util.AppExecutors;
import org.adaway.util.ApplyUtils;
import org.adaway.util.Constants;
import org.adaway.util.Log;
import org.adaway.model.hostsinstall.HostsInstallError;
import org.adaway.model.hostsinstall.HostsInstallException;
import org.adaway.model.hostsinstall.HostsInstallModel;
import org.adaway.model.hostsinstall.HostsInstallStatus;

import static org.adaway.model.hostsinstall.HostsInstallStatus.INSTALLED;
import static org.adaway.model.hostsinstall.HostsInstallStatus.ORIGINAL;
import static org.adaway.model.hostsinstall.HostsInstallStatus.OUTDATED;
import static org.adaway.model.hostsinstall.HostsInstallStatus.WORK_IN_PROGRESS;

/**
 * This class is a {@link android.arch.lifecycle.ViewModel} for home fragment UI.
 *
 * @author Bruce BUJON (bruce.bujon(at)gmail(dot)com)
 */
public class HostsInstallViewModel extends AndroidViewModel {
    private final HostsInstallModel model;
    private final MutableLiveData<HostsInstallStatus> status;
    private final MutableLiveData<String> state;
    private final MutableLiveData<String> details;
    private final MutableLiveData<HostsInstallError> error;
    private boolean loaded;

    /**
     * Constructor.
     *
     * @param application The application context.
     */
    public HostsInstallViewModel(@NonNull Application application) {
        super(application);
        // Create model
        this.model = new HostsInstallModel(application);
        // Initialize live data
        this.status = new MutableLiveData<>();
        this.state = new MutableLiveData<>();
        this.details = new MutableLiveData<>();
        this.error = new MutableLiveData<>();
        // Bind model to live data
        this.model.addObserver((o, a) -> {
            this.state.postValue(this.model.getState());
            this.details.postValue(this.model.getDetailedState());
        });
        // Initialize model as not loaded
        this.loaded = false;
    }

    public MutableLiveData<HostsInstallStatus> getStatus() {
        return this.status;
    }

    public MutableLiveData<String> getState() {
        return this.state;
    }

    public MutableLiveData<String> getDetails() {
        return this.details;
    }

    public MutableLiveData<HostsInstallError> getError() {
        return this.error;
    }

    /**
     * Initialize the model with its current state.
     */
    public void load() {
        // Check if model is already loaded
        if (this.loaded) {
            return;
        }
        this.loaded = true;
        // Check if hosts file is installed
        AppExecutors.getInstance().diskIO().execute(() -> {
            if (ApplyUtils.isHostsFileCorrect(Constants.ANDROID_SYSTEM_ETC_HOSTS)) {
                this.status.postValue(INSTALLED);
                this.setStateAndDetails(R.string.status_enabled, R.string.status_enabled_subtitle);
            } else {
                this.status.postValue(ORIGINAL);
                this.setStateAndDetails(R.string.status_disabled, R.string.status_disabled_subtitle);
            }
        });
        // Check for update if needed
        if (PreferenceHelper.getUpdateCheck(this.getApplication())) {
            this.checkForUpdate();
        }
    }

    /**
     * Update the hosts file.
     */
    public void update() {
        AppExecutors.getInstance().diskIO().execute(() -> {
            HostsInstallStatus previousStatus = this.status.getValue();
            this.status.postValue(WORK_IN_PROGRESS);
            try {
                this.model.downloadHostsSources();
                this.model.applyHostsFile();
                this.status.postValue(INSTALLED);
            } catch (HostsInstallException exception) {
                Log.e(Constants.TAG, "Failed to update hosts file.", exception);
                this.status.postValue(previousStatus);
                this.error.postValue(exception.getInstallError());
            }
        });
    }

    /**
     * Check if there is update available in hosts source.
     */
    public void checkForUpdate() {
        AppExecutors.getInstance().networkIO().execute(() -> {
            // Update status
            this.status.postValue(WORK_IN_PROGRESS);
            try {
                // Check if update is available
                if (this.model.checkForUpdate()) {
                    this.status.postValue(OUTDATED);
                } else {
                    this.status.postValue(INSTALLED);
                }
            } catch (HostsInstallException exception) {
                Log.e(Constants.TAG, "Failed to check for update.", exception);
                this.status.postValue(INSTALLED);
                this.error.postValue(exception.getInstallError());
            }
        });
    }

    /**
     * Revert to the default hosts file.
     */
    public void revert() {
        AppExecutors.getInstance().mainThread().execute(() -> {
            this.status.postValue(WORK_IN_PROGRESS);
            try {
                this.model.revert();
                this.status.postValue(ORIGINAL);
            } catch (HostsInstallException exception) {
                Log.e(Constants.TAG, "Failed to revert hosts file.", exception);
                this.status.postValue(INSTALLED);
                this.error.postValue(exception.getInstallError());
            }
        });
    }

    private void setStateAndDetails(@StringRes int stateResId, @StringRes int detailsResId) {
        this.setStateAndDetails(stateResId, this.getApplication().getString(detailsResId));
    }

    private void setStateAndDetails(@StringRes int stateResId, String details) {
        this.state.postValue(this.getApplication().getString(stateResId));
        this.details.postValue(details);
    }
}
