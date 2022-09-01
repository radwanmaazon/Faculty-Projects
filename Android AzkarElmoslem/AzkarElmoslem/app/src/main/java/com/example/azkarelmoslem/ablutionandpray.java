package com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ablutionandpray extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ablutionandpray);
        Button Bt_before_ab=findViewById(R.id.Bt_before_eating);
        Button Bt_after_pr=findViewById(R.id.Bt_after_eating);
        Button Bt_enter_mosq=findViewById(R.id.Bt_enter_mosq);
        Button Bt_leave_mosq=findViewById(R.id.Bt_leave_mosq);
        Bt_before_ab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent before_ab=new Intent(getApplicationContext(),beforeabulation.class);
                startActivity(before_ab);
            }
        });
        Bt_after_pr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent afterabulation1=new Intent(getApplicationContext(),afterabulation1.class);
                startActivity(afterabulation1);
            }
        });
        Bt_enter_mosq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent enter_mosq=new Intent(getApplicationContext(),Enter_mosq.class);
                startActivity(enter_mosq);
            }
        });
        Bt_leave_mosq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent leave_mosq=new Intent(getApplicationContext(), leave_mosq.class);
                startActivity(leave_mosq);
            }
        });
    }
}