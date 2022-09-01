package com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class eating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating);
        Button Bt_before_eating=findViewById(R.id.Bt_before_eating);
        Button Bt_after_eating=findViewById(R.id.Bt_after_eating);

        Bt_before_eating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent before_eating=new Intent(getApplicationContext(),before_eating.class);
                startActivity(before_eating);
            }
        });
        Bt_after_eating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent after_eating=new Intent(getApplicationContext(),after_eating.class);
                startActivity(after_eating);
            }
        });
    }
}