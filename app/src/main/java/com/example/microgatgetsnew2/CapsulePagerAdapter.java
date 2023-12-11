package com.example.microgatgetsnew2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CapsulePagerAdapter extends RecyclerView.Adapter<CapsulePagerAdapter.PagerVH> {
    private String[] arrayName = {"Bluetooth Nano +", "Bluetooth Nano Pro +"};
    private String[] arrayCost = {"3500₽", "4000₽"};
    private String[] arrayDisc = {"Капсульные микронаушники Bluetooth Nano + , главная фишка данного комплекта - компактный размер...",
        "Капсульные микронаушники Bluetooth Nano Pro + , главная фишка данного комплекта - компактный размер..."};
    private int[] imageId = {R.drawable.bluetooth_nano_plus_buy_main, R.drawable.bluetooth_nano_pro_plus_buy_main};
    private int[] sliderId = {R.drawable.slider_twodots_1, R.drawable.slider_twodots_2};

    public CapsulePagerAdapter() {}

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

    public class PagerVH extends RecyclerView.ViewHolder {
        public PagerVH(View itemView) {
            super(itemView);
        }
    }
}


