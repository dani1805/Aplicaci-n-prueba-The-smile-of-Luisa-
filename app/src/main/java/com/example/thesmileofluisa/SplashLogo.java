package com.example.thesmileofluisa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashLogo extends AppCompatActivity {

    private ImageView logo;
    private TextView tvTitle;
    private TextView tvInformation;

    private static int SPLASH_SCREEN = 5000;
    private Animation topAnimation, buttomAnimation;
    // Animaciones

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_logo);

        logo = findViewById(R.id.logo);
        tvTitle = findViewById(R.id.tvTitle);
        tvInformation = findViewById(R.id.tvInformation);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        buttomAnimation = AnimationUtils.loadAnimation(this, R.anim.button_animation);

        logo.setAnimation(buttomAnimation);
        tvTitle.setAnimation(topAnimation);
        tvInformation.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(SplashLogo.this, MinorActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }

}
