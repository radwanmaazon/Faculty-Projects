package com.example.myapplication.app.src.main.java.com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.azkarelmoslem.sabah26;

public class sabah25 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabah25);
        ImageButton Next25=findViewById(R.id.Next25);
        Next25.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sabah26=new Intent(getApplicationContext(), com.example.azkarelmoslem.sabah26.class);
                startActivity(sabah26);
                finish();
            }
        });
    }
}
