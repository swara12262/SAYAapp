package com.shubham.saya_10.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shubham.saya_10.R;

public class SplashScreen extends AppCompatActivity {

    private static int SplashInterval=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("user_data", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","N/A");
                if(username.contains("N/A"))
                {
                    Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    if(sharedPreferences.getString("type","N/A").contains("User"))
                    {
                        Intent intent=new Intent(getApplicationContext(),UserHomePage.class);
                        startActivity(intent);
                        finish();
                    }
                    else if(sharedPreferences.getString("type","N/A").contains("Admin"))
                    {
                        Intent intent=new Intent(getApplicationContext(),AdminDetails.class);
                        startActivity(intent);
                        finish();
                    }


                }

            }
            private void finish()
            {

            }
        },SplashInterval);
    };
}
