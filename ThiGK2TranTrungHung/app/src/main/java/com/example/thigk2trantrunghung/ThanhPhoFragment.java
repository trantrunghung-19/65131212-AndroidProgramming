package com.example.thigk2trantrunghung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThanhPhoFragment extends Fragment {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recylerViewDatas;
    RecyclerView recyclerViewLandscape;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thanh_pho, container, false);

        recylerViewDatas = getDataForRecyclerView();
        recyclerViewLandscape = view.findViewById(R.id.recyclerLand);

        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(getContext(), 2);
        recyclerViewLandscape.setLayoutManager(layoutGrid);

        landScapeAdapter = new LandScapeAdapter(getContext(), recylerViewDatas);
        recyclerViewLandscape.setAdapter(landScapeAdapter);

        return view;
    }

    ArrayList<LandScape> getDataForRecyclerView() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<>();
        dsDuLieu.add(new LandScape("Hà Nội", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("TP. Hồ Chí Minh", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Đà Nẵng", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Nha Trang", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Cần Thơ", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Huế", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Hải Phòng", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Đà Lạt", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Vũng Tàu", "ic_launcher_background"));
        dsDuLieu.add(new LandScape("Trần Trung Hùng", "ic_launcher_background"));
        return dsDuLieu;
    }
}