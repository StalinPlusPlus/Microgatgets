package com.example.microgatgetsnew2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.microgatgetsnew2.databinding.ActivityMainBinding;
import com.example.microgatgetsnew2.databinding.FragmentMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    ImageButton imageButtonMenu;
    ConstraintLayout constraintLayoutMenu;
    TextView textViewCatalog;

    @Override
    public void onBackPressed() {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mainBinding.getRoot());

        imageButtonMenu = mainBinding.imageButtonMenu;
        textViewCatalog = mainBinding.textViewAtalog;

        imageButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MY", "МЕНЮ");
                if (mainBinding.constraintLayoutMenu.getVisibility() == View.GONE) {
                    mainBinding.constraintLayoutMenu.setVisibility(View.VISIBLE);
                } else {
                    mainBinding.constraintLayoutMenu.setVisibility(View.GONE);
                }
            }
        });
        textViewCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MY", "КАТАЛОГ");
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, CatalogFragment.class, null);
                ft.commit();
                mainBinding.constraintLayoutMenu.setVisibility(View.GONE);
            }
        });
        mainBinding.textViewMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setReorderingAllowed(true);
                ft.replace(R.id.fragment_container_view_main, MainFragment.class, null);
                ft.commit();
                mainBinding.constraintLayoutMenu.setVisibility(View.GONE);
            }
        });
    }
}