package com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class welcom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        // inflat
        ImageView welcom= findViewById(R.id.Img_welcome);
        Thread thread=new Thread(){
            public void run (){
                try {
                    sleep(4000);
                    Intent mainactivty=new Intent(getApplicationContext(),MainActivity.class);   //Move between pages
                    startActivity(mainactivty);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}











