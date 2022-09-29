package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dussheraAct extends AppCompatActivity {

    EditText etduss;
    Button btnduss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dusshera);

        etduss = findViewById(R.id.etDuss);
        btnduss = findViewById(R.id.btnDuss);

        btnduss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etduss.getText().toString();
                Intent intent = new Intent(dussheraAct.this, wishing_dussera.class);
                intent.putExtra("dush",data);
                startActivity(intent);
            }
        });
    }
}