package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sleep8;

public class sleep7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep7);
        ImageButton Next_sleep4=findViewById(R.id.Next_sleep7);
        Next_sleep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleep8=new Intent(getApplicationContext(), com.example.azkarelmoslem.sleep8.class);
                startActivity(sleep8);
                finish();
            }
        });
    }
}
