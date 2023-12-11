package com.example.microgatgetsnew2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.microgatgetsnew2.databinding.FragmentCatalogBinding;

public class CatalogFragment extends Fragment {

    private FragmentCatalogBinding catalogBinding;

//    public CatalogFragment() {
//        super(R.layout.fragment_catalog);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catalogBinding = FragmentCatalogBinding.inflate(inflater, container, false);

        catalogBinding.appCompatButtonMoreProfessional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Professional");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        catalogBinding.appCompatButtonMoreMagnetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Magnetic");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        catalogBinding.appCompatButtonMoreBluetoothPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Bluetooth Pro");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        catalogBinding.appCompatButtonMoreBluetoothNano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Bluetooth Nano");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        catalogBinding.appCompatButtonMoreBluetoothNanoCapsule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Bluetooth Nano +");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        catalogBinding.appCompatButtonMoreBluetoothNanoPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Bluetooth Nano Pro");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        catalogBinding.appCompatButtonMoreBluetoothNanoProCapsule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("name", "Bluetooth Nano Pro +");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, ItemFragment.class, args);
                ft.commit();
            }
        });

        return catalogBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
