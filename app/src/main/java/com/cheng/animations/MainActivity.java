package com.cheng.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgSun;
    private ImageView imgHour;
    private ImageView imgMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgSun = (ImageView) findViewById(R.id.imgSun);
        imgHour = (ImageView) findViewById(R.id.imgHour);
        imgMinute = (ImageView) findViewById(R.id.imgMinute);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);
        imgSun.setAnimation(animation);

        Animation clockTurn = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        imgHour.setAnimation(clockTurn);

        Animation hourTurn = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
        imgMinute.setAnimation(hourTurn);
    }
}
