package org.adaway;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.adaway.util.Log;

public class Help2Activity extends AppCompatActivity {

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }

        /*
        SDCard sdCard = new SDCard();
        sdCard.f();

        //输入要写的内容
        String string1="fuck you";
        sdCard.writeFileSdcardFile("a.txt",string1);

        String string2 = "";
        string2 += sdCard.readFileSdcardFile("a.txt");
        System.out.println(string2);
        */
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
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

    public void sendMessage4(View view) {
        Intent intent = new Intent(this, SDWriteActivity.class);

        startActivity(intent);
    }

    public void sendMessage5(View view) {
        Intent intent = new Intent(this, SDReadActivity.class);

        startActivity(intent);
    }


}
