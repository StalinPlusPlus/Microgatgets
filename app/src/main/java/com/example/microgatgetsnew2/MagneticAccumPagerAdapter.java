package com.example.microgatgetsnew2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MagneticAccumPagerAdapter extends RecyclerView.Adapter<MagneticAccumPagerAdapter.PagerVH> {
    private String[] arrayName = {"Professional", "Bluetooth Pro", "Bluetooth Nano", "Bluetooth Nano Pro"};
    private String[] arrayDisc = {"Микронаушники Professional, комплект на аккумуляторе подсоединяется к телефону с помощью...",
        "Магнитные микронаушники Bluetooth Pro, главная фишка данного комплекта - функция «перезвона...",
        "Магнитные микронаушники Bluetooth Nano, главная фишка данного комплекта - компактный размер...",
        "Беспроводные магнитные микронаушники Bluetooth Nano Pro с компактным размером гарнитуры..."};
    private String[] arrayCost = {"2400₽", "3500₽", "3800₽", "4300₽"};
    private final int[] imageId = {R.drawable.professional_buy_main, R.drawable.bluetooth_pro_buy_main, R.drawable.bluetooth_nano_buy_main,
        R.drawable.bluetooth_nano_pro_buy_main};
    private final int[] sliderId = {R.drawable.slider_fourdot_1, R.drawable.slider_fourdot_2, R.drawable.slider_fourdot_3, R.drawable.slider_fourdot_4};

    public MagneticAccumPagerAdapter() {

    }

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

