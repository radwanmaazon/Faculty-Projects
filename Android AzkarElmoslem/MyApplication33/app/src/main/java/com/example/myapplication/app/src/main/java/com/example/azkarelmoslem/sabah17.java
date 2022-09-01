package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sabah18;

public class sabah17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabah17);
        ImageButton Next17=findViewById(R.id.Next17);
        Next17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sabah18=new Intent(getApplicationContext(), com.example.azkarelmoslem.sabah18.class);
                startActivity(sabah18);
                finish();
            }
        });
    }
}
