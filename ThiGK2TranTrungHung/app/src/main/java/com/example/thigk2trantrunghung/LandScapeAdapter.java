package com.example.thigk2trantrunghung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vItem = inflater.inflate(R.layout.item, parent, false);
        return new ItemLandHolder(vItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        LandScape landScapeHienThi = lstData.get(position);
        holder.tvCaption.setText(landScapeHienThi.getLandCation());
        
        String tenFileAnh = landScapeHienThi.getLandImageFileName();
        int imageID = context.getResources().getIdentifier(tenFileAnh, "mipmap", context.getPackageName());
        if (imageID == 0) {
            imageID = context.getResources().getIdentifier(tenFileAnh, "drawable", context.getPackageName());
        }
        
        if (imageID != 0) {
            holder.ivLandscape.setImageResource(imageID);
        } else {
            holder.ivLandscape.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder {
        TextView tvCaption;
        ImageView ivLandscape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCation);
            ivLandscape = itemView.findViewById(R.id.imageViewLand);
            
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(context, "Bạn vừa click vào: " + lstData.get(position).getLandCation(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}