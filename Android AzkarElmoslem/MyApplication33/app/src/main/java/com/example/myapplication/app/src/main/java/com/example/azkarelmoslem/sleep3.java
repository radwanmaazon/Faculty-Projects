package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sleep4;

public class sleep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep3);
        ImageButton Next_sleep3=findViewById(R.id.Next_sleep3);
        Next_sleep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleep4=new Intent(getApplicationContext(), com.example.azkarelmoslem.sleep4.class);
                startActivity(sleep4);
                finish();
            }
        });
    }
}
