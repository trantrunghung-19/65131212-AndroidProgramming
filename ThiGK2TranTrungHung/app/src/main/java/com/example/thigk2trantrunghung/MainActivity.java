package com.example.thigk2trantrunghung;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Hiển thị fragment mặc định khi vào app
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int id = item.getItemId();

                if (id == R.id.nav_welcome) {
                    selectedFragment = new HomeFragment();
                } else if (id == R.id.nav_cau1) {
                    selectedFragment = new TinhToanFragment();
                } else if (id == R.id.nav_cau2) {
                    selectedFragment = new ThanhPhoFragment();
                } else if (id == R.id.nav_cau3) {
                    selectedFragment = new DiaDiemFragment();
                } else if (id == R.id.nav_cau4) {
                    selectedFragment = new ToiFragment();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSpace, fragment)
                .commit();
    }
}