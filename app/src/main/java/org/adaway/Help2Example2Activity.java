package org.adaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Help2Example2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2_example2);
        TextView textView = this.findViewById(R.id.textView2);
        textView.setText(Html.fromHtml("<h2>1.Not enough space on partition</h2>\n" +
                "<p>Try changing the target hosts file in preferences to <code>/data/data/hosts</code> (or <code>/data/hosts</code>) and apply AdAway again.</p>\n" +
                "\n" +
                "<h2>2.Does not work on Android 4.4+</h2>\n" +
                "<p>Try changing the target hosts file in preferences from <code>/data/data/hosts</code> to <code>/data/hosts</code> or <code>/system/etc/hosts</code> and apply AdAway again.</p>\n" +
                "\n" +
                "<h2>3.It does not block ads in application XYZ!</h2>\n" +
                "<p>Some hostnames may be missing in the provided hosts files from the <cite>Hosts Sources</cite> or the application has bundled the images to provide ads without accessing the internet.<br/><br/>\n" +
                "You can log DNS requests (Menu-&gt;Log DNS Requests) from AdAway to find out which additional hostnames have to be blocked.\n" +
                "<br/><br/>Add the suspicious hostnames to your own Blacklist by long pressing the entries in the Log and report these hostnames when you have verified them in the Forum <a href=\"http://forum.hosts-file.net/viewforum.php?f=9\">Hosts Inbox</a> of <a href=\"http://hosts-file.net\">hosts-file.net</a>.</p>\n" +
                "\n" +
                "<h2>4.Cached Advertisements</h2>\n" +
                "<p>Sometimes applications cache advertisements after download. This leads to remaining advertisements in some applications. You can try to delete the cache for these applications in Android's Application list to circumvent this problem.</p>\n" +
                "\n" +
                "<h2>5.Application XYZ is not working anymore!</h2>\n" +
                "<p>Some applications need to communicate with a hostname that is blocked by AdAway or refuses to work when the hostnames which should serve ads are not reachable. See <a href=\"https://github.com/AdAway/AdAway/wiki/ProblematicApps\">https://github.com/AdAway/AdAway/wiki/ProblematicApps</a> to get a list of known applications that have problems. Otherwise, find out which hostnames are needed and add them to your <cite>Whitelist</cite> under <cite>Your Lists</cite> and report them to the <a href=\"https://github.com/AdAway/AdAway/issues\">bug tracker of AdAway</a>.</p>\n" +
                "\n" +
                "<h2>6.The back button in web browsers is not working</h2>\n" +
                "<p>You can enable AdAway's local webserver in preferences as a workaround.</p>"));
    }
}
