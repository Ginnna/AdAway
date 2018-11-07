package org.adaway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import org.adaway.ui.MainActivity;
import org.adaway.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;


public class Help2Example3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2_example3);
        TextView textView = this.findViewById(R.id.textView3);
        //System.out.println(readRaw());

        String string2 = "<p>";
        //string2 += "123";
        string2 +=readRaw();
        string2 += "</p>";
        textView.setText(Html.fromHtml(string2));
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
    public String readRaw(){
        //文件名需以字母开头
        InputStream input=getResources().openRawResource(R.raw.abc);

        String result="";
        try{
            int length= input.available();
            byte[] buffer = new byte[length];
            input.read(buffer);
            result = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        //makeFilePath(filePath, fileName);

        String strFilePath = filePath+fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }
}
