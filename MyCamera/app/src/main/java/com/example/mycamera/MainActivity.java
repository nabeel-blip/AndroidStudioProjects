package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnCamera;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnCamera = (Button) findViewById(R.id.button);
         imageView  = (ImageView) findViewById(R.id.ImageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

            }
        });




    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
     super.onActivityResult(requestCode,resultCode,data);
     Bitmap bitmap = (Bitmap)data.getExtras().get("data");
     imageView.setImageBitmap(bitmap);

    }











































}