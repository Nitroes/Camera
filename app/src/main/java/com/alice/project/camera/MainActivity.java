package com.alice.project.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent photoIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.button);

        button.setOnClickListener(v->{
            startActivityForResult(photoIntent,123);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==123){
            Bitmap bitmap =(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
