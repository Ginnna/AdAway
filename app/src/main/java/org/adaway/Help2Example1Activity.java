package org.adaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Help2Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2_example1);
        TextView textView = this.findViewById(R.id.textView);
        String string = "<h2>1.Income by advertisements</h2>\n" +
                "<p>There is an oft-stated misconception that if a user never clicks on ads, then blocking them won't hurt a site or application financially. This is wrong, developers also earn money by just displaying ads. It is up to you whether you block ads or not. Personally I would not use applications that display ads because I find them very annoying, so without an ad blocker I would not install these applications.</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h2>2.How does AdAway work?</h2>\n" +
                "<p>AdAway uses the <a href=\"http://en.wikipedia.org/wiki/Hosts_file\">hosts file</a> to block hostnames, that serve advertisements. The hosts file is a file found in <code>/system/etc/hosts</code> that maps hostnames to IP addresses. It is a traditional way to define hostname to IP address pairs without relying on the Domain Name System (DNS). All unwanted hostnames are redirected to <code>127.0.0.1</code> which means they will point to your own device.</p>\n" +
                "\n" +
                "<h2>3.Why is the daily update check preference grayed out?</h2>\n" +
                "<p>Automatic checking for new updates is only available when AdAway is installed on the internal phone memory. This is due to restrictions on the Android platform.</p>\n" +
                "\n" +
                "<h2>4.Why do I have to restart Android for changes to take effect?</h2>\n" +
                "<p>Java on Android maintains its own internal DNS cache. The operating system will reflect the new hosts file immediately (verify that with ping on the command line) but you'll need to restart Android to rebuild the DNS cache of Java.</p>\n" +
                "\n" +
                "<h2>5.How to use the webserver in AdAway?</h2>\n" +
                "<p><strong>AdAway will also work without using the webserver!</strong>\n" +
                "<br/><br/>You can enable a local webserver in preferences of AdAway to answer requests to the local IP address <code>127.0.0.1</code>. This means requests from applications to ad servers which are redirected to <code>127.0.0.1</code> are answered by AdAway's webserver.\n" +
                "<br/>Some applications refuse to work, when ad servers are not reachable. With this method they will be reachable again, replying with a blank page and no ad images.</p>\n" +
                "\n" +
                "<h2>6.How can I block/unblock specific hostnames?</h2>\n" +
                "<p>Add the hostnames you want to block to the Blacklist (=Black) under <cite>Your Lists</cite>. Additionally, hostnames you want to exclude from blocking can be added to the <cite>Whitelist</cite> (=White) and hostnames you want to redirect to a specific IP address belong to the <cite>Redirection List</cite> (=Redirection).</p>\n" +
                "\n" +
                "<h2>7.Where can I find more hosts sources?</h2>\n" +
                "<p>See <a href=\"https://github.com/AdAway/AdAway/wiki/HostsSources\">List of additional hosts sources for AdAway</a>.</p>"+
                "\n" +
                "<h2>8.Help translating/report bugs</h2>\n" +
                "<p>Please go to <a href=\"https://adaway.org\">https://adaway.org</a>.</p>";
        textView.setText(Html.fromHtml(string));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
