package com.example.appmonan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lvDSMonAn=(ListView) findViewById(R.id.lvDSMonAn);
        ArrayList<MonAn> dsMonAn= new ArrayList<MonAn>();

        dsMonAn.add(new MonAn("Com suon tam",20000,"mo ta o day",R.drawable.comsuontam));
        dsMonAn.add(new MonAn("Com com ga",30000,"mo ta o day",R.drawable.comga));
        dsMonAn.add(new MonAn("Com tam dac biet",40000,"mo ta o day",R.drawable.comtamdacbiet));
        dsMonAn.add(new MonAn("suon bi cha",25000,"mo ta o day",R.drawable.suonbicha));

        MonAnAdapter adapter= new MonAnAdapter(this,dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                MonAn monAnChon= dsMonAn.get(i);
                Toast.makeText(MainActivity.this,monAnChon.getTenMonAn(),Toast.LENGTH_LONG).show();
            }
        });
    }
}