package com.example.thesmileofluisa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thesmileofluisa.adapter.AdapterVp;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MinorActivity extends AppCompatActivity {

    private ViewPager2 vpImg;
    private FloatingActionButton faAccess;
    private TextView tvOutfit;
    private Handler sliderHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minor);

        vpImg = findViewById(R.id.vpPhotos);
        faAccess = findViewById(R.id.faLogin);
        tvOutfit = findViewById(R.id.tvOutfit);

        setupView();

        tvOutfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(MinorActivity.this);
                builder.setTitle("Colección Feria de Mayo 2022");
                builder.setMessage("Confección de trajes de gitana, peinetas, collares, gargantillas, flores, esparteñas");
                builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                androidx.appcompat.app.AlertDialog otherDialog = builder.create();
                otherDialog.show();
            }
        });

        faAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MinorActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setupView(){
        vpImg = findViewById(R.id.vpPhotos);

        List<SlideLogo> slideLogos = new ArrayList<>();
        slideLogos.add(new SlideLogo(R.drawable.flores_4));
        slideLogos.add(new SlideLogo(R.drawable.lisa));
        slideLogos.add(new SlideLogo(R.drawable.animal_print_2));
        slideLogos.add(new SlideLogo(R.drawable.especial));
        slideLogos.add(new SlideLogo(R.drawable.animal_print_4));
        slideLogos.add(new SlideLogo(R.drawable.especial));
        slideLogos.add(new SlideLogo(R.drawable.lunares_1));
        slideLogos.add(new SlideLogo(R.drawable.flores));
        slideLogos.add(new SlideLogo(R.drawable.especial_2));
        slideLogos.add(new SlideLogo(R.drawable.lisa_3));

        vpImg.setAdapter(new AdapterVp(slideLogos,vpImg));
        vpImg.setClipToPadding(false);
        vpImg.setClipChildren(false);
        vpImg.setOffscreenPageLimit(3);
        vpImg.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r + 0.15f);
            }
        });

        vpImg.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);
            }
        });

    }

    private  Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            vpImg.setCurrentItem(vpImg.getCurrentItem() + 1 );
        }
    };
}