package com.example.microgatgetsnew2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TakeCartDialogFragment extends DialogFragment {
    private enum NameItem {
        Magnetic,
    }
    String name;
    static TakeCartDialogFragment newInstance(String name) {
        TakeCartDialogFragment dialog = new TakeCartDialogFragment();

        Bundle args = new Bundle();
        args.putString("name", name);
        dialog.setArguments(args);

        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        setShowsDialog(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_cart, container, false);
        ImageView imageViewPicture = view.findViewById(R.id.imageViewPicture);
        TextView textViewName = view.findViewById(R.id.textViewNamePicture);
        textViewName.setText(name);
        switch (name) {
            case "Magnetic":
                imageViewPicture.setImageResource(R.drawable.magnetic_buy_main);
                break;
            case "Exam Lite":
                imageViewPicture.setImageResource(R.drawable.exam_lite_buy_main);
                break;
            case "Exam Standart":
                imageViewPicture.setImageResource(R.drawable.exam_standart_buy_main);
                break;
            case "Exam Pro":
                imageViewPicture.setImageResource(R.drawable.exam_pro_buy_main);
                break;
            case "Professional":
                imageViewPicture.setImageResource(R.drawable.professional_buy_main);
                break;
            case "Bluetooth Pro":
                imageViewPicture.setImageResource(R.drawable.bluetooth_pro_buy_main);
                break;
            case "Bluetooth Nano":
                imageViewPicture.setImageResource(R.drawable.bluetooth_nano_buy_main);
                break;
            case "Bluetooth Nano Pro":
                imageViewPicture.setImageResource(R.drawable.bluetooth_nano_pro_buy_main);
                break;
            case "Magnetic +":
                imageViewPicture.setImageResource(R.drawable.magnetic_plus_buy_main);
                break;
            case "Pro +":
                imageViewPicture.setImageResource(R.drawable.pro_plus_buy_main);
                break;
            case "Bluetooth Nano +":
                imageViewPicture.setImageResource(R.drawable.bluetooth_nano_plus_buy_main);
                break;
            case "Bluetooth Nano Pro +":
                imageViewPicture.setImageResource(R.drawable.bluetooth_nano_pro_plus_buy_main);
                break;
            case "Box +":
                imageViewPicture.setImageResource(R.drawable.box_plus_buy_main);
                break;
            case "Vip Box Pro +":
                imageViewPicture.setImageResource(R.drawable.vip_box_pro_plus_buy_main);
                break;
        }

        ImageButton imageButtonClose = view.findViewById(R.id.imageButtonClose);
        imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }
}
