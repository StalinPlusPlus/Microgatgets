package com.example.microgatgetsnew2;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerItemAdapter extends RecyclerView.Adapter<ViewPagerItemAdapter.PagerVH>{

    private int[] mImages;

    public ViewPagerItemAdapter(int[] images) {
        mImages = images;
    }

    @NonNull
    @Override
    public PagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pager_item, parent, false);
        return new PagerVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerVH holder, int position) {
        View itemView = holder.itemView;
        ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setImageResource(mImages[position]);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

    public class PagerVH extends RecyclerView.ViewHolder {
        public PagerVH(View itemView) {
            super(itemView);
        }
    }
}
