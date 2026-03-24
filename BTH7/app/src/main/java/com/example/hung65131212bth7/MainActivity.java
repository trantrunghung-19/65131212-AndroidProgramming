package com.example.hung65131212bth7;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTenTinhThanhVN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


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

        lvTenTinhThanh.setOnItemClickListener(Bolangnghevaxl);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    AdapterView.OnItemClickListener Bolangnghevaxl=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            String strTenTinhChon =dsTenTinhThanhVN.get(i);
            Toast.makeText(MainActivity.this,strTenTinhChon,Toast.LENGTH_LONG).show();
        }
    };


}