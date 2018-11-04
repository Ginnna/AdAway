package org.adaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Help2Example3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2_example3);
        TextView textView = this.findViewById(R.id.textView3);
        textView.setText(Html.fromHtml("<h2>1.HTC Devices</h2>\n" +
                "<p>AdAway does not work when you are using a device with so called S-ON. This 'feature' exists on many HTC devices and prevents AdAway from writing the hosts file.</p>\n" +
                "\n" +
                "<h2>2.S-ON/S-OFF?</h2>\n" +
                "<p>S-OFF means that the NAND portion of the device is unlocked and can be written to. The default setting for HTC devices is S-ON, which means that neither can you access certain areas of the system nor can you guarantee a permanent root. Furthermore, signature check for firmware images is also ensured by the S-ON flag.</p>\n" +
                "\n" +
                "<h2>3.Do I have S-ON or S-OFF?</h2>\n" +
                "<p>Boot into the Boot Menu on your device by holding down <cite>volume down</cite> button while pressing power and the text on top will show the flag status as either S-OFF or S-ON. A full root generally means S-OFF.\n" +
                "<br/><br/>More information can be found on <a href=\"http://www.addictivetips.com/mobile/what-is-s-off-how-to-gain-it-on-htc-android-phones-with-unrevoked-forever/\">www.addictivetips.com</a>. Additional S-OFF methods since Unrevokable (in link) might interest you, namely: Revolutionary, Revone, Firewater, RumRunner, Moonshine, SunShine...</p>\n" +
                "\n" +
                "<h2>4.Workaround</h2>\n" +
                "<p>Prerequisite: You have to install a working Android SDK with ADB shell on your PC.\n" +
                "</p>\n" +
                "<ol>\n" +
                "<li>Boot into the Boot Menu on your device by holding down <cite>volume down</cite> button while pressing power.</li>\n" +
                "<li>Use <cite>volume down</cite> to select recovery.</li>\n" +
                "<li>In clockwork recovery volume down to \"partitions menu\" and hit the track pad to select</li>\n" +
                "<li>Select <cite>mount /system</cite>, <cite>mount /sdcard</cite> and <cite>mount /data</cite>.</li>\n" +
                "<li>Plug in your usb cord and open a command line on your pc.</li>\n" +
                "<li>Enter adb shell and type <code>ln -s /data/hosts /system/etc/hosts</code> (This creates a symbolic link, which allows AdAway to edit the hosts file stored in <code>/data</code> while allowing the OS to use the file as if it were stored in <code>/system</code>.)</li>\n" +
                "<li>Reboot your device and set <cite>Target hosts file</cite> to <cite>/data/hosts</cite> in AdAway's preferences.</li>\n" +
                "<li>AdAway should work now.</li>\n" +
                "</ol>"));
    }
}
