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

public class wishing_diwali extends AppCompatActivity {

    String depa;
    TextView ttdiwa;
    ImageView ivdiwa;
    Button sendDiwa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishing_diwali);

        ttdiwa = findViewById(R.id.ttDiwa);
        ivdiwa = findViewById(R.id.ivDiwa);
        sendDiwa = findViewById(R.id.sendDiwa);

        Intent intent = getIntent();

        depa = intent.getStringExtra("diva");

        ttdiwa.setText(depa+ " की ओर से दिवाली की बहुत बहुत सुभकामनाये ");

        sendDiwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)ivdiwa.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

                Uri uri = Uri.parse(bitmapPath);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/png");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello man");
                intent.putExtra(Intent.EXTRA_TEXT,depa+ " की ओर से दिवाली की बहुत बहुत सुभकामनाये "+"\nplay store link: https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(intent,"share"));
            }
        });
    }
}