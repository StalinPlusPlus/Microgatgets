package com.example.microgatgetsnew2;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class StripSalesFragment extends Fragment {
    static final String TEXT = "text";
    static final String TEXT_BUTTON = "textButton";
    static final String TITLE = "title";
    static final String TEXT_CITY = "textCity";
    static final String TEXT_CHOICE = "textChoice";
    static final String COST = "cost";
    static final String BACKGROUND = "background";
    static final String SLIDER = "slider";

    public StripSalesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_strip, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String text = arguments.getString(TEXT);
            String textButton = arguments.getString(TEXT_BUTTON);
            String title = arguments.getString(TITLE);
            String textCity = arguments.getString(TEXT_CITY);
            String textChoice = arguments.getString(TEXT_CHOICE);
            String cost = arguments.getString(COST);
            int slider = arguments.getInt(SLIDER);
            int background = arguments.getInt(BACKGROUND);

            displayValues(view, text, textButton, title, textCity, textChoice, cost, slider, background);
        }

        return view;
    }

    private void displayValues(View v, String _text, String _textButton, String _title, String _textCity, String _textChoice,
                               String _cost, int _slider, int _background) {
        TextView textViewText = v.findViewById(R.id.textView);
        TextView textViewTextButton = v.findViewById(R.id.appCompatButtonSales);
        TextView textViewTitle = v.findViewById(R.id.textViewTitle);
        TextView textViewTextCity = v.findViewById(R.id.textViewCity);
        TextView textViewChoice = v.findViewById(R.id.textViewChoice);
        TextView textViewCost = v.findViewById(R.id.textViewCost);
        ImageView imageViewSlider = v.findViewById(R.id.imageViewSlider);
        ConstraintLayout cs = v.findViewById(R.id.constraintLayoutSales);

        textViewText.setText(_text);
        textViewTextButton.setText(_textButton);
        textViewTitle.setText(_title);
        textViewTextCity.setText(_textCity);
        textViewChoice.setText(_textChoice);
        textViewCost.setText(_cost);
        imageViewSlider.setImageResource(_slider);
        cs.setBackgroundResource(_background);
    }
}
