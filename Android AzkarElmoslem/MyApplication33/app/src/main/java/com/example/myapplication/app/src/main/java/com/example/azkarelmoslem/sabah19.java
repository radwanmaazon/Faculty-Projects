package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sabah20;

public class sabah19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabah19);
        ImageButton Next19=findViewById(R.id.Next19);
        Next19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sabah20=new Intent(getApplicationContext(), com.example.azkarelmoslem.sabah20.class);
                startActivity(sabah20);
                finish();
            }
        });
    }
}
