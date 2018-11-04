package org.adaway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2);
    }

    public void sendMessage1(View view) {
        Intent intent = new Intent(this, Help2Example1Activity.class);

        startActivity(intent);
    }

    public void sendMessage2(View view) {
        Intent intent = new Intent(this, Help2Example2Activity.class);

        startActivity(intent);
    }

    public void sendMessage3(View view) {
        Intent intent = new Intent(this, Help2Example3Activity.class);

        startActivity(intent);
    }
}
