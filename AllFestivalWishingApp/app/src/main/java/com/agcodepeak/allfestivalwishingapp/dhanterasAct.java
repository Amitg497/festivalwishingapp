package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dhanterasAct extends AppCompatActivity {

    EditText dhtext;
    Button dhbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhanteras);

        dhtext = findViewById(R.id.dhText);
        dhbutton = findViewById(R.id.dhButton);

        dhbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = dhtext.getText().toString();
                Intent intent = new Intent(dhanterasAct.this,wishing_dhanteras.class);
                intent.putExtra("dhan",data);
                startActivity(intent);
            }
        });
    }
}