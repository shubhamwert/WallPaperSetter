package com.example.shubh.wallpaperchangerfinal;

import android.app.WallpaperManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//TODO Add listner to recycler View
//Todo set wallpaper mehtod
//Todo visual polish
//TODO storing images from phone
public class MainActivity extends AppCompatActivity {
    private ArrayList<ImageStoring> ImageList = new ArrayList<>();
    ImageSwitcher imageSwitcher;
    WallImageAdapter wallImageAdapter;
    FloatingActionButton mFabButton;
    ViewPager viewPager;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.view_pager);
        MyPager adapter=new MyPager(this);
        viewPager.setAdapter(adapter);
        recyclerView=findViewById(R.id.mrecycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        wallImageAdapter =new WallImageAdapter(this,ImageList);
        recyclerView.setAdapter(wallImageAdapter);
        recyclerView.setHasFixedSize(true);
        startPreparingData();
        mFabButton=findViewById(R.id.mFabButton);

        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setResource(viewPager.getCurrentItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    private void startPreparingData() {
        ImageList.add(new ImageStoring("asadsdas",R.drawable.abbstarct));
        ImageList.add(new ImageStoring("asadsdas",R.drawable.abstaract));
        ImageList.add(new ImageStoring("asadsdas",R.drawable.abstratc));
        ImageList.add(new ImageStoring("asadsdas",R.drawable.abbstarct));

    wallImageAdapter.notifyDataSetChanged();
    }




}
