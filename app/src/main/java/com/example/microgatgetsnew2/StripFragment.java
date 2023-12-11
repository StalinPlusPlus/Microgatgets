package com.example.microgatgetsnew2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class StripFragment extends Fragment {
    static final String NAMES = "names";
    static final String DISC = "disc";
    final static String TOP_IMAGE = "top_image";
    static final String PRICE = "price";
    static final String SLIDER = "slider";
    DialogFragment dialogFragment;

    String nameBuy;

    public StripFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_strip, container, false);

        return view;
    }
}
