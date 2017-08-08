package com.apps.saad.animodule;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        VideoView video;

        video = (VideoView)findViewById(R.id.videoView2);

        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.intro2;
        Uri uri = Uri.parse(uriPath);
        video.setVideoURI(uri);
        video.requestFocus();
        video.setZOrderOnTop(true);
        video.start();

        int SPLASH_DISPLAY_LENGTH = 10500;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        /*Intent intent = new Intent(Splash.this, MainActivity.class);
        startActivity(intent);
        finish();*/
    }
}