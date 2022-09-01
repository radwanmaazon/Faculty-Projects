package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sabah10;


public class sabah9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabah9);

        ImageButton Next9=findViewById(R.id.Next9);
        Next9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sabah10=new Intent(getApplicationContext(), com.example.azkarelmoslem.sabah10.class);
                startActivity(sabah10);
                finish();
            }
        });
    }
}
