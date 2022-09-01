package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sleep7;

public class sleep6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep6);
        ImageButton Next_sleep4=findViewById(R.id.Next_sleep6);
        Next_sleep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleep7=new Intent(getApplicationContext(), com.example.azkarelmoslem.sleep7.class);
                startActivity(sleep7);
                finish();
            }
        });
    }
}
