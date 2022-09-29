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

public class wishing_dussera extends AppCompatActivity {

    String dera;
    TextView txduss;
    ImageView imageduss;
    Button senddush;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishing_dussera);

        txduss = findViewById(R.id.txDuss);
        imageduss = findViewById(R.id.imageDuss);
        senddush = findViewById(R.id.sendDuss);

        Intent intent = getIntent();

        dera = intent.getStringExtra("dush");

        txduss.setText(dera + " की ओर से दशहरा की बहुत बहुत सुभकामनाये ");

        senddush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)imageduss.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

                Uri uri = Uri.parse(bitmapPath);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello man");
                intent.putExtra(Intent.EXTRA_TEXT,dera + " की ओर से दशहरा की बहुत बहुत सुभकामनाये "+"\n play store link: https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(intent,"share"));
            }
        });


    }
}