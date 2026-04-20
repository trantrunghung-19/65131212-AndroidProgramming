package com.example.thigk2trantrunghung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiaDiemAdapter extends RecyclerView.Adapter<DiaDiemAdapter.DiaDiemViewHolder> {
    private Context context;
    private ArrayList<DiaDiem> dsDiaDiem;

    public DiaDiemAdapter(Context context, ArrayList<DiaDiem> dsDiaDiem) {
        this.context = context;
        this.dsDiaDiem = dsDiaDiem;
    }

    @NonNull
    @Override
    public DiaDiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dia_diem, parent, false);
        return new DiaDiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaDiemViewHolder holder, int position) {
        DiaDiem diaDiem = dsDiaDiem.get(position);
        holder.tvTen.setText(diaDiem.getTen());
        holder.tvDiaChi.setText(diaDiem.getDiaChi());
        
        int imageID = context.getResources().getIdentifier(diaDiem.getAnh(), "mipmap", context.getPackageName());
        if (imageID == 0) {
            imageID = context.getResources().getIdentifier(diaDiem.getAnh(), "drawable", context.getPackageName());
        }
        
        if (imageID != 0) {
            holder.ivAnh.setImageResource(imageID);
        } else {
            holder.ivAnh.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return dsDiaDiem.size();
    }

    static class DiaDiemViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAnh;
        TextView tvTen, tvDiaChi;

        public DiaDiemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnh = itemView.findViewById(R.id.ivDiaDiem);
            tvTen = itemView.findViewById(R.id.tvTenDiaDiem);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
        }
    }
}