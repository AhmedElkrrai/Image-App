package com.example.imageapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    private List<String> imagesUrlList = new ArrayList<>();
    private Context mContext;

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        Glide.with(mContext).load(imagesUrlList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagesUrlList.size();
    }

    public void setList(List<String> imagesList) {
        this.imagesUrlList = imagesList;
        notifyDataSetChanged();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}