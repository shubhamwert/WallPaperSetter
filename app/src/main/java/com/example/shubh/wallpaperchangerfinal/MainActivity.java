package com.example.shubh.wallpaperchangerfinal;

import android.app.WallpaperManager;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
//TODO Add listner to recycler View
//Todo visual polish
//TODO storing images from phone

public class MainActivity extends AppCompatActivity {
    private ArrayList<ImageStoring> ImageList = new ArrayList<>();

    WallImageAdapter wallImageAdapter;
    FloatingActionButton mFabButton;
    ViewPager viewPager;
    MyDataSet myDataSet;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataSet=new MyDataSet();
        setViewPager();
        setRecyler();
        setFab();



    }

    private void setFab() {
        mFabButton=findViewById(R.id.mFabButton);

        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager myWallpaperManager = WallpaperManager
                        .getInstance(MainActivity.this);


                try {

                    myWallpaperManager.setResource(ImageList.get(viewPager.getCurrentItem()).getmId());

                    Toast.makeText(MainActivity.this,
                            "Wallpaper successfully changed", Toast.LENGTH_SHORT)
                            .show();

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                }
            }
        });}

    private void setRecyler() {
        recyclerView=findViewById(R.id.mrecycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        wallImageAdapter =new WallImageAdapter(this,ImageList);
        recyclerView.setAdapter(wallImageAdapter);
        recyclerView.setHasFixedSize(true);
        startPreparingData();
    }

    private void setViewPager() {
        viewPager = findViewById(R.id.view_pager);
        MyPager adapter=new MyPager(this);
        viewPager.setAdapter(adapter);
    }

    private void startPreparingData() {

ImageList.addAll(0,MyDataSet.getmData());
        wallImageAdapter.notifyDataSetChanged();
    }




}
