package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class wishing_gandhi extends AppCompatActivity {

    TextView wggandhi;
    String gdhi;
    ImageView imagegandhi;
    Button sendgandhi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishing_gandhi);

        wggandhi = findViewById(R.id.wgGandhi);
        imagegandhi = findViewById(R.id.imageGandhi);
        sendgandhi = findViewById(R.id.sendGandhi);

        Intent intent = getIntent();

        gdhi = intent.getStringExtra("bapu");

        wggandhi.setText(gdhi + " की ओर से गाँधी जयंती की बहुत बहुत शुभकामनये  ");


        sendgandhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)imagegandhi.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

                Uri uri = Uri.parse(bitmapPath);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello man");
                intent.putExtra(Intent.EXTRA_TEXT,gdhi+" की ओर से गाँधी जयंती की बहुत बहुत शुभकामनये"+"\n play store link: https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(intent,"share"));
            }
        });





    }
}