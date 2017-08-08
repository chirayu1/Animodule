package com.apps.saad.animodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.chrisbanes.photoview.PhotoView;


public class ColorMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_menu);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.elephant_outline);




    }

}
