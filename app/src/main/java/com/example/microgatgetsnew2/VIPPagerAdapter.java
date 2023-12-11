package com.example.microgatgetsnew2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class VIPPagerAdapter extends RecyclerView.Adapter<VIPPagerAdapter.PagerVH> {
    private String[] arrayName = {"Box +", "Vip Box Pro +"};
    private String[] arrayCost = {"5500₽", "6500₽"};
    private String[] arrayDisc = {"Ультрасовременный комплект микронаушников, сочетающий в себе беспроводное соединение...",
            "Bluetooth-гарнитура без антенны со встроенным микрофоном."};
    private int[] imageId = {R.drawable.box_plus_buy_main, R.drawable.vip_box_pro_plus_buy_main};
    private int[] sliderId = {R.drawable.slider_twodots_1, R.drawable.slider_twodots_2};

    public VIPPagerAdapter() {}

    @NonNull
    @Override
    public PagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_strip, parent, false);
        return new PagerVH(itemView);
    }

    @Override
    public int getItemCount() {
        return arrayName.length;
    }

    @Override
    public void onBindViewHolder(@NonNull PagerVH holder, int position) {
        View itemView = holder.itemView;
        TextView name = itemView.findViewById(R.id.textViewStripName);
        TextView disc = itemView.findViewById(R.id.textViewStripDisc);
        TextView cost = itemView.findViewById(R.id.textViewStripCost);
        ImageView image = itemView.findViewById(R.id.imageViewStrip);
        ImageView slider = itemView.findViewById(R.id.imageViewStripSlider);

        name.setText(arrayName[position]);
        disc.setText(arrayDisc[position]);
        cost.setText(arrayCost[position]);
        image.setImageResource(imageId[position]);
        slider.setImageResource(sliderId[position]);
    }

    public static class PagerVH extends RecyclerView.ViewHolder {
        public PagerVH(View itemView) {
            super(itemView);
        }
    }
}
