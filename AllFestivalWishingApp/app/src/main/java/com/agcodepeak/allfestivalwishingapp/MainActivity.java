package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.agcodepeak.allfestivalwishingapp.Adapters.adapter_class;
import com.agcodepeak.allfestivalwishingapp.classes.RecyclerItemClickListener;
import com.agcodepeak.allfestivalwishingapp.models.model_class;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycleer);

        ArrayList<model_class> list = new ArrayList<>();

        list.add(new model_class(R.drawable.gandhiji,"GANDHI JAYANTI WISHES"));
        list.add(new model_class(R.drawable.dusserha,"DUSSEHRA WISHES"));
        list.add(new model_class(R.drawable.teachers,"TEACHER'S DAY WISHES"));
        list.add(new model_class(R.drawable.dhanterass,"DHANTERAS WISHES"));
        list.add(new model_class(R.drawable.devali,"HAPPY DIWALI WISHES"));




        adapter_class adapter = new adapter_class(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,gandhiAct.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent indent = new Intent(MainActivity.this,dussheraAct.class);
                        startActivity(indent);
                        break;

                    case 2:
                        Intent inaent = new Intent(MainActivity.this,teachersAct.class);
                        startActivity(inaent);
                        break;

                    case 3:
                        Intent inbent = new Intent(MainActivity.this,dhanterasAct.class);
                        startActivity(inbent);
                        break;

                    case 4:
                        Intent invent = new Intent(MainActivity.this,diwaliAct.class);
                        startActivity(invent);
                        break;


                    default:


                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}