package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.azkarelmoslem.noom2;


public class noom1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noom1);

        ImageButton Next26=findViewById(R.id.Next_noom1);
        Next26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noom2=new Intent(getApplicationContext(), com.example.azkarelmoslem.noom2.class);
                startActivity(noom2);
                finish();

            }
        });


    }
}
