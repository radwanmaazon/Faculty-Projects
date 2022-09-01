package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sleep3;

public class sleep2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep2);
        ImageButton Next_sleep2=findViewById(R.id.Next_sleep2);
        Next_sleep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleep3=new Intent(getApplicationContext(), com.example.azkarelmoslem.sleep3.class);
                startActivity(sleep3);
                finish();
            }
        });
    }
}
