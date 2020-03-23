package com.example.katakatimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=4000;
    Animation topanim,bottomanim,leftanim;
    ImageView blackxx,whitexx,logoo;
    TextView loadingg,ssdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topanim= AnimationUtils.loadAnimation(this,R.anim.topanim);
        bottomanim=AnimationUtils.loadAnimation(this,R.anim.bottomanim);
        leftanim=AnimationUtils.loadAnimation(this,R.anim.leftanim);
        blackxx=findViewById(R.id.blackx);
        whitexx=findViewById(R.id.whitex);
        logoo=findViewById(R.id.imageView6);
        loadingg=findViewById(R.id.loading);
        ssdd=findViewById(R.id.textView);
        blackxx.setAnimation(topanim);
        whitexx.setAnimation(bottomanim);
        logoo.setAnimation(topanim);
        ssdd.setAnimation(topanim);
        loadingg.setAnimation(leftanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,secondactivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);

    }


    }

