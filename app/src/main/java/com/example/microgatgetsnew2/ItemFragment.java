package com.example.microgatgetsnew2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.microgatgetsnew2.databinding.ItemFragmentBinding;

public class ItemFragment extends Fragment {

    ItemFragmentBinding itemFragmentBinding;
    private int[] imagesProfessional = {R.drawable.professional_slider_item_1, R.drawable.professional_slider_item_2, R.drawable.professional_slider_item_3,
            R.drawable.professional_slider_item_4};
    private int[] imagesMagnetic = {R.drawable.magnetic_slider_item_1, R.drawable.magnetic_slider_item_2, R.drawable.magnetic_slider_item_3,
            R.drawable.magnetic_slider_item_4};
    private int[] imagesBluetoothPro = {R.drawable.bluetooth_pro_slider_item_1, R.drawable.bluetooth_pro_slider_item_2, R.drawable.bluetooth_pro_slider_item_3,
        R.drawable.bluetooth_pro_slider_item_3};
    private int[] imagesBluetoothNano = {R.drawable.bluetooth_nano_slider_item_1, R.drawable.bluetooth_nano_slider_item_2};
    private int[] imagesBluetoothNanoPlus = {R.drawable.bluetooth_nano_plus_slider_item_1, R.drawable.bluetooth_nano_plus_slider_item_2,
        R.drawable.bluetooth_nano_plus_slider_item_3, R.drawable.bluetooth_nano_plus_slider_item_4, R.drawable.bluetooth_nano_plus_slider_item_5};
    private int[] imagesBluetoothNanoPro = {R.drawable.bluetooth_nano_pro_slider_item_1, R.drawable.bluetooth_nano_pro_slider_item_2,
        R.drawable.bluetooth_nano_pro_slider_item_3};
    private int[] imagesBluetoothnanoProPlus = {R.drawable.bluetooth_nano_pro_plus_slider_item_1, R.drawable.bluetooth_nano_pro_plus_slider_item_2,
        R.drawable.bluetooth_nano_pro_plus_slider_item_3, R.drawable.bluetooth_nano_pro_plus_slider_item_4, R.drawable.bluetooth_nano_pro_plus_slider_item_5};
    String name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        name = getArguments().getString("name");
        Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
        itemFragmentBinding = ItemFragmentBinding.inflate(inflater, container, false);

        if (name.equals("Professional")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesProfessional));
            itemFragmentBinding.textViewName.setText("Professional");
            itemFragmentBinding.textViewDisc.setText(R.string.professional_item_disc);
        } else if (name.equals("Magnetic")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesMagnetic));
            itemFragmentBinding.textViewName.setText("Magnetic");
            itemFragmentBinding.textViewDisc.setText(R.string.magnetic_item_disc);
        } else if (name.equals("Bluetooth Pro")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesBluetoothPro));
            itemFragmentBinding.textViewName.setText("Bluetooth Pro");
            itemFragmentBinding.textViewDisc.setText(R.string.professional_item_disc);
        } else if (name.equals("Bluetooth Nano")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesBluetoothNano));
            itemFragmentBinding.textViewName.setText("Bluetooth Nano");
        } else if (name.equals("Bluetooth Nano +")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesBluetoothNanoPlus));
            itemFragmentBinding.textViewName.setText("Bluetooth Nano +");
        } else if (name.equals("Bluetooth Nano Pro")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesBluetoothNanoPro));
            itemFragmentBinding.textViewName.setText("Bluetooth Nano Pro");
        } else if (name.equals("Bluetooth Nano Pro +")) {
            itemFragmentBinding.viewPagerImage.setAdapter(new ViewPagerItemAdapter(imagesBluetoothnanoProPlus));
            itemFragmentBinding.textViewName.setText("Bluetooth Nano Pro +");
        }

        itemFragmentBinding.radioGroupColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId() == itemFragmentBinding.radioButtonWhite.getId()) {
                    itemFragmentBinding.radioButtonWhite.setBackground(getResources().getDrawable(R.drawable.custom_border_layout_yellow));
                    itemFragmentBinding.radioButtonBlack.setBackground(getResources().getDrawable(R.drawable.custom_border_layout));
                } else if (radioGroup.getCheckedRadioButtonId() == itemFragmentBinding.radioButtonBlack.getId()) {
                    itemFragmentBinding.radioButtonBlack.setBackground(getResources().getDrawable(R.drawable.custom_border_layout_yellow));
                    itemFragmentBinding.radioButtonWhite.setBackground(getResources().getDrawable(R.drawable.custom_border_layout));
                }
            }
        });

        itemFragmentBinding.imageButtonMinusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(itemFragmentBinding.textViewCount.getText().toString());
                if (count != 1)
                    count -= 1;
                itemFragmentBinding.textViewCount.setText(String.format("%s", count));
            }
        });

        itemFragmentBinding.imageButtonPlusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(itemFragmentBinding.textViewCount.getText().toString()) + 1;
                itemFragmentBinding.textViewCount.setText(String.format("%s", count));
            }
        });

        return itemFragmentBinding.getRoot();
    }
}
