package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class diwaliAct extends AppCompatActivity {

    EditText etdiwali;
    Button btndiwali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diwali);

      etdiwali = findViewById(R.id.edDivali);
      btndiwali = findViewById(R.id.bdnDivali);

      btndiwali.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String data = etdiwali.getText().toString();
              Intent intent = new Intent(diwaliAct.this,wishing_diwali.class);
              intent.putExtra("diva",data);
              startActivity(intent);
          }
      });
    }
}