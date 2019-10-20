package com.example.coffee;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class splashactivity extends AppCompatActivity {
    private ImageView logo;
    private static  int splashtimeout=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);


//displays a video file
//       VideoView mVideoView2 = (VideoView)findViewById(R.id.video);
//      String uriPath2 = "android.resource://"+getPackageName()+"/"+R.raw.movie;
//       Uri uri2 = Uri.parse(uriPath2);
//     mVideoView2.setVideoURI(uri2);
//     mVideoView2.requestFocus();
//       mVideoView2.start();
//       mVideoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//          @Override
//          public void onCompletion(MediaPlayer mp) {
//              return;
//           }
//      });


        logo=(ImageView)findViewById(R.id.coffee);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(splashactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },splashtimeout);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        logo.startAnimation(myanim);
    }
}

