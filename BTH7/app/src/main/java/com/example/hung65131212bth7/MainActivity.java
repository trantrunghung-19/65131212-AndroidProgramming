package com.example.hung65131212bth7;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ArrayList<String> dsTenTinhThanhVN;
        dsTenTinhThanhVN= new ArrayList<String>();
        dsTenTinhThanhVN.add("Ha Noi");
        dsTenTinhThanhVN.add("Khanh Hoa");
        dsTenTinhThanhVN.add("Phu Yen");
        dsTenTinhThanhVN.add("Da Nang");
        dsTenTinhThanhVN.add("Hue");

        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsTenTinhThanhVN);
        ListView lvTenTinhThanh= findViewById(R.id.lvDanhSachTT);
        lvTenTinhThanh.setAdapter(adapterTinhThanh);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}