package com.example.baitapon;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChiTietMonAnActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon_an);

        String tenMon = getIntent().getStringExtra("ten_mon");
        TextView tv = findViewById(R.id.tvTenMonChiTiet);
        if (tenMon != null) {
            tv.setText(tenMon);
        }
    }

    public void quayLai(View v) {
        finish();
    }
}