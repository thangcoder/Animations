package com.cheng.animations;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

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

        hourTurn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "onAnimationStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "onAnimationEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(MainActivity.this, "onAnimationRepeat", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onStart() {
        overridePendingTransition(R.anim.rotate_in,0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,AnimatedActivity.class);
                startActivity(intent);
            }
        },7000);
        super.onStart();
    }
}
