package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class teachersAct extends AppCompatActivity {

    EditText tdtext;
    Button tdbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        tdtext = findViewById(R.id.tdText);
        tdbutton = findViewById(R.id.tdButton);

        tdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = tdtext.getText().toString();
                Intent intent = new Intent(teachersAct.this, wishing_teachers.class);
                intent.putExtra("tame",data);
                startActivity(intent);
            }
        });
    }
}