package com.example.azkarelmoslem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView Img_morning   = findViewById(R.id.Image_Morning);
        Button Btn_morning      = findViewById(R.id.Bt_Morning);
        ImageView Img_ablution  = findViewById(R.id.ablution);
        Button Btn_ablution     = findViewById(R.id.Btn_ablution);
        ImageView Img_eating    = findViewById(R.id.Image_eating);
        Button Btn_eating       = findViewById(R.id.Bt_eating);

        Img_morning.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View v){
                Intent morning=new Intent(getApplicationContext(),morning.class);
                startActivity(morning);
            }
        });
        Btn_morning.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View v){
                Intent morning=new Intent(getApplicationContext(),morning.class);
                startActivity(morning);
            }
        });

        Img_ablution.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View v){
                Intent ablutionandpray=new Intent(getApplicationContext(),ablutionandpray.class);
                startActivity(ablutionandpray);
            }
        });
        Btn_ablution.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View v){
                Intent ablutionandpray=new Intent(getApplicationContext(),ablutionandpray.class);
                startActivity(ablutionandpray);
            }
        });

        Img_eating.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View v){
                Intent eating=new Intent(getApplicationContext(),eating.class);
                startActivity(eating);
            }
        });
        Btn_eating.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View v){
                Intent eating=new Intent(getApplicationContext(),eating.class);
                startActivity(eating);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true ;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if (id==R.id.menu_home){
            Intent intent=new Intent(getApplicationContext(),zekrimport.class);
            startActivity(intent);
        }
        if (id==R.id.menu_Aboutus){

        }
        if (id==R.id.menu_ContactUs){
            Intent intent=new Intent(getApplicationContext(),contactus.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}