package com.example.microgatgetsnew2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainFragment extends Fragment {

    ViewPager2 viewPagerMagneticAccum, viewPagerCapsule, viewPagerVip, viewPagerSales;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPagerMagneticAccum = view.findViewById(R.id.viewPagerMagneticAccum);
        viewPagerCapsule = view.findViewById(R.id.viewPagerCapsule);
        viewPagerVip = view.findViewById(R.id.viewPagerVIP);
        viewPagerSales = view.findViewById(R.id.viewPagerSales);

        MagneticAccumPagerAdapter magneticAccumPagerAdapter = new MagneticAccumPagerAdapter();
        CapsulePagerAdapter capsulePagerAdapter = new CapsulePagerAdapter();
        VIPPagerAdapter vipPagerAdapter = new VIPPagerAdapter();
        SalesPagerAdapter salesPagerAdapter = new SalesPagerAdapter();

        viewPagerMagneticAccum.setAdapter(magneticAccumPagerAdapter);
        viewPagerCapsule.setAdapter(capsulePagerAdapter);
        viewPagerVip.setAdapter(vipPagerAdapter);
        viewPagerSales.setAdapter(salesPagerAdapter);
    }
}
