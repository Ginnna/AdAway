package org.adaway;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SDCard {

    public void f()  {
        try {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录
                System.out.println(sdCardDir.toString());


                File saveFile = new File(sdCardDir, "a.txt");
                if(!saveFile.exists())
                    saveFile.createNewFile();


                FileOutputStream outStream = new FileOutputStream(saveFile);
                outStream.write("test\r\n".getBytes());
                outStream.close();
            }
            else
                System.out.println("no SD card!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void writeFileSdcardFile(String fileName,String write_str) {
        try{
            File sdCardDir = Environment.getExternalStorageDirectory();
            File saveFile = new File(sdCardDir, fileName);
            FileOutputStream fout = new FileOutputStream(saveFile,true);
            byte [] bytes = write_str.getBytes();

            fout.write(bytes);
            fout.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String readFileSdcardFile(String fileName) {
        String res="";
        try{
            File sdCardDir = Environment.getExternalStorageDirectory();
            File saveFile = new File(sdCardDir, fileName);
            FileInputStream fin = new FileInputStream(saveFile);

            int length = fin.available();

            byte [] buffer = new byte[length];
            fin.read(buffer);

            res = new String(buffer);

            fin.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
