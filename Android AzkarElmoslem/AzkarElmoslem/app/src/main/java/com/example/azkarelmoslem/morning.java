package com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class morning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        Button Bt_morn_night=findViewById(R.id.Bt_before_eating);
        Button Bt_walkup=findViewById(R.id.Bt_after_eating);
        Button Bt_noom3=findViewById(R.id.Bt_enter_mosq);
        Button Bt_movinginnight=findViewById(R.id.Bt_leave_mosq);
        Bt_noom3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent noom1=new Intent(getApplicationContext(),noom.class);
                startActivity(noom1);
            }
        });
        Bt_morn_night.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent morn_night=new Intent(getApplicationContext(),morn_night.class);
                startActivity(morn_night);
            }
        });
        Bt_walkup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Bt_walkup=new Intent(getApplicationContext(),Bt_walkup1.class);
                startActivity(Bt_walkup);
            }
        });
        Bt_movinginnight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Bt_movinginnight=new Intent(getApplicationContext(), movinginnight1.class);
                startActivity(Bt_movinginnight);
            }
        });

    }
}