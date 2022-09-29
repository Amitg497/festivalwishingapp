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

public class wishing_dhanteras extends AppCompatActivity {

    String dedhan;
    TextView etdhan;
    ImageView picdhan;
    Button senddhan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishing_dhanteras);

        etdhan = findViewById(R.id.etDhan);
        picdhan = findViewById(R.id.picDhan);
        senddhan = findViewById(R.id.sendDhan);

        Intent intent = getIntent();

        dedhan = intent.getStringExtra("dhan");

        etdhan.setText(dedhan+ " की ओर से धनतेरस की बहुत बहुत सुभकामनाये ");

        senddhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)picdhan.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

                Uri uri = Uri.parse(bitmapPath);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello man");
                intent.putExtra(Intent.EXTRA_TEXT,dedhan+ " की ओर से धनतेरस की बहुत बहुत सुभकामनाये "+"\n play store link: https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(intent,"share"));
            }
        });
    }
}