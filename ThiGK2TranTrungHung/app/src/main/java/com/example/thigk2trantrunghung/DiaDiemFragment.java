package com.example.thigk2trantrunghung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiaDiemFragment extends Fragment {
    private RecyclerView rvDiaDiem;
    private DiaDiemAdapter adapter;
    private ArrayList<DiaDiem> dsDiaDiem;

    public DiaDiemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dia_diem, container, false);
        
        rvDiaDiem = view.findViewById(R.id.rvDiaDiem);
        dsDiaDiem = new ArrayList<>();
        
        // Dữ liệu mẫu các địa điểm du lịch Nha Trang
        dsDiaDiem.add(new DiaDiem("VinWonders Nha Trang", "Đảo Hòn Tre, Vĩnh Nguyên, Nha Trang", "ic_launcher_background"));
        dsDiaDiem.add(new DiaDiem("Tháp Bà Ponagar", "2 Tháng 4, Vĩnh Phước, Nha Trang", "ic_launcher_background"));
        dsDiaDiem.add(new DiaDiem("Chùa Long Sơn", "20 Đường 23/10, Phương Sơn, Nha Trang", "ic_launcher_background"));
        dsDiaDiem.add(new DiaDiem("Viện Hải dương học", "01 Cầu Đá, Vĩnh Nguyên, Nha Trang", "ic_launcher_background"));
        dsDiaDiem.add(new DiaDiem("Đảo Hòn Mun", "Vịnh Nha Trang, Nha Trang", "ic_launcher_background"));
        dsDiaDiem.add(new DiaDiem("Bãi Dài", "Cam Hải Đông, Cam Lâm, Khánh Hòa", "ic_launcher_background"));
        
        adapter = new DiaDiemAdapter(getContext(), dsDiaDiem);
        rvDiaDiem.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDiaDiem.setAdapter(adapter);
        
        return view;
    }
}