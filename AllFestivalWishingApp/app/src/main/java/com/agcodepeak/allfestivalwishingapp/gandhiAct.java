package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class gandhiAct extends AppCompatActivity {

    EditText etgandhi;
    Button btngandhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gandhi);

        etgandhi = findViewById(R.id.etGandhi);
        btngandhi = findViewById(R.id.btnGandhi);

        btngandhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etgandhi.getText().toString();
                Intent intent = new Intent(gandhiAct.this, wishing_gandhi.class);
                intent.putExtra("bapu",data);
                startActivity(intent);
            }
        });
    }
}