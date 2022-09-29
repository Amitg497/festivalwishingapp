package com.agcodepeak.allfestivalwishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class wishing_teachers extends AppCompatActivity {

    String teel;
    TextView txteach;
    ImageView picteaach;
    Button sendteach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishing_teachers);

        txteach = findViewById(R.id.txTeach);
        picteaach = findViewById(R.id.picTeach);
        sendteach = findViewById(R.id.sendTeach);

        Intent intent = getIntent();

        teel = intent.getStringExtra("tame");

        txteach.setText(teel+ " की ओर से Teacher's Day की बहुत बहुत सुभकामनाये ");

        sendteach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)picteaach.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

                Uri uri = Uri.parse(bitmapPath);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello man");
                intent.putExtra(Intent.EXTRA_TEXT,teel+" की ओर से Teacher's Day की बहुत बहुत सुभकामनाये "+"\n play store link: https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(intent,"share"));
            }
        });

    }
}