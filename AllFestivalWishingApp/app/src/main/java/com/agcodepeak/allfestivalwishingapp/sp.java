package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class sp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);

                }
                catch (Exception e){
                    e.printStackTrace();

                }
                finally {
                    Intent intent = new Intent(sp.this,MainActivity.class);
                    startActivity(intent);

                }

                finish();
            }

        };
        thread.start();



    }
}