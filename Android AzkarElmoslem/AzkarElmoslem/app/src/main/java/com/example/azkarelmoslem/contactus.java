package com.example.azkarelmoslem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
    }
    public void Facebook_Url(View view){
        Intent Facebook =new Intent(Intent.ACTION_VIEW);
        Facebook.setData(Uri.parse("https://www.facebook.com/REDWAN2050/"));
        if (Facebook.resolveActivity(getPackageManager()) !=null){
            startActivity(Facebook);
        }
    }
    public void Linkedin_Url(View view){
        Intent Linkedin =new Intent(Intent.ACTION_VIEW);
        Linkedin.setData(Uri.parse("https://www.linkedin.com/in/radwan-maazon-2a2928211/"));
        if (Linkedin.resolveActivity(getPackageManager()) !=null){
            startActivity(Linkedin);
        }
    }
}