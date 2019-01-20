package com.example.shubh.wallpaperchangerfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MyPager extends PagerAdapter {
    private Context mContext;
    private int[] mImages=new int[]{R.drawable.abstaract,R.drawable.abstratc};

    public MyPager(Context context){
        mContext=context;
    }
    @Override
    public int getCount() {
        return mImages.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView=new ImageView(mContext);
        imageView.setImageResource(mImages[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        container.addView(imageView,0,200);

        return imageView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}