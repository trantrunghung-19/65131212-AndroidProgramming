package com.example.thigk2trantrunghung;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recylerViewDatas;
    RecyclerView recyclerViewLandscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recylerViewDatas = getDataForRecyclerView();
        recyclerViewLandscape=findViewById(R.id.recyclerLand);
        //RecyclerView.LayoutManager layoutLinear= new LinearLayoutManager(this);
        //recyclerViewLandscape.setLayoutManager(layoutLinear);
        //RecyclerView.LayoutManager layoutLinearHorizonal= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerViewLandscape.setLayoutManager(layoutLinearHorizonal);
        RecyclerView.LayoutManager layoutGrid= new GridLayoutManager(this,2);
        recyclerViewLandscape.setLayoutManager(layoutGrid);
        landScapeAdapter= new LandScapeAdapter(this, recylerViewDatas);
        recyclerViewLandscape.setAdapter(landScapeAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu= new ArrayList<LandScape>();
        LandScape landScape1= new LandScape("","");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("",""));
        dsDuLieu.add(new LandScape("",""));
        dsDuLieu.add(new LandScape("",""));
        return dsDuLieu;
    }
}