package com.example.microgatgetsnew2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class SalesPagerAdapter extends RecyclerView.Adapter<SalesPagerAdapter.PagerVH> {

    private String[] mText = {"Microgatgets - бред микронаушников\n№ 1 в мире.\nНезаметно, безопасно, легально.\nСоюственное производство и гарантия" +
            "\nнизких цен.", "Microgatgets - бред микронаушников\n№ 1 в мире.\nНезаметно, безопасно, легально.\nСоюственное производство и гарантия" +
            "\nнизких цен.", "Арендуй 2 микронаушника по цене \nодногодля себя и для друга.\n\nАкция доступна во всех наших\n" +
            "городах, где есть возможность аренды\nмикронаушника"};
    private String[] mTextButton = {"Выбрать микронаушник", "Выбрать микронаушник", "Узнать больше"};
    private String[] mTitle = {"Купить\nмикронаушники", "Аренда микронаушников", "Спецпредложение"};
    private String[] mTextCity = {"В 33 городах.", "В 33 городах", "Выгодный выбор"};
    private String[] mTextChoice = {"Выбрать свой >", "Выбрать свой >", "2 по цене 1!"};
    private String[] mCost = {"От 999 руб", "От 250 руб", "2 по цене 1!"};
    private final int[] mBackground = {R.drawable.background_student, R.drawable.background_girl_rent,
        R.drawable.background_sales};
    private final int[] mSlider = {R.drawable.slider_threedot_yellow_1, R.drawable.slider_threedot_yellow_2,
        R.drawable.slider_threedot_yellow_3};

    public SalesPagerAdapter() {}

    @NonNull
    @Override
    public PagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sales_strip, parent, false);
        return new PagerVH(itemView);
    }

    public int getItemCount() {
        return mText.length;
    }

    public void onBindViewHolder(@NonNull SalesPagerAdapter.PagerVH holder, int position) {
        View itemView = holder.itemView;
        TextView text = itemView.findViewById(R.id.textView);
        TextView title = itemView.findViewById(R.id.textViewTitle);
        TextView city = itemView.findViewById(R.id.textViewCity);
        TextView choice = itemView.findViewById(R.id.textViewChoice);
        TextView cost = itemView.findViewById(R.id.textViewCost);
        AppCompatButton button = itemView.findViewById(R.id.appCompatButtonSales);
        ConstraintLayout constraintLayout = itemView.findViewById(R.id.constraintLayoutSales);
        ImageView slider = itemView.findViewById(R.id.imageViewSlider);

        text.setText(mText[position]);
        title.setText(mTitle[position]);
        city.setText(mTextCity[position]);
        choice.setText(mTextChoice[position]);
        cost.setText(mCost[position]);
        button.setText(mTextButton[position]);
        constraintLayout.setBackgroundResource(mBackground[position]);
        slider.setImageResource(mSlider[position]);
    }

    public class PagerVH extends RecyclerView.ViewHolder {
        public PagerVH(View itemView) {
            super(itemView);
        }
    }

}
