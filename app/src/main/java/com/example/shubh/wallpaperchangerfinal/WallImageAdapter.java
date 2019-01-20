package com.example.shubh.wallpaperchangerfinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class WallImageAdapter extends RecyclerView.Adapter<WallImageAdapter.ViewHolder>  {
private Context mContext;
private ArrayList<ImageStoring> mData;
private int postion=0;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mtextView;
        ImageView mImageView;

        public ViewHolder(View v){
            super(v);
            mtextView =v.findViewById(R.id.m_text_view);
            mImageView=v.findViewById(R.id.m_img_view);

        }

        @Override
        public void onClick(View v) {
            postion=getAdapterPosition();
            Log .d(TAG, "Element " + getAdapterPosition() + " clicked.");
        }
    }

public WallImageAdapter(Context Context,ArrayList<ImageStoring> arrayList){

        mContext=Context;

        mData=arrayList;}




    @NonNull
    @Override
    public WallImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View mView=LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list,parent,false);
    mView.setPadding(11,11,11,11);
    mView.setElevation(0.4f);

    return new ViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(@NonNull WallImageAdapter.ViewHolder holder, int position) {
        ImageStoring imgs=mData.get(position);


        holder.mImageView.setImageResource(imgs.getmId());
        holder.mtextView.setText(imgs.getmName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
