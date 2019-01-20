package com.example.shubh.wallpaperchangerfinal;

import android.widget.ImageSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MyDataSet {
  static private ArrayList<ImageStoring> mData;

public MyDataSet(){
    mData=new ArrayList<>();
    mData.add(new ImageStoring("asadsdas",R.drawable.abbstarct));
    mData.add(new ImageStoring("asadsdas",R.drawable.abstaract));
    mData.add(new ImageStoring("asadsdas",R.drawable.abstratc));
    mData.add(new ImageStoring("asadsdas",R.drawable.abbstarct));
}

    public static ArrayList<ImageStoring> getmData() {
        return mData;
    }

    public int getId(int i){
    return mData.get(i).getmId();
    }
    public String getName(int i){

    return mData.get(i).getmName();
    }
    public int getCount(){
    return mData.size();
    }


}
