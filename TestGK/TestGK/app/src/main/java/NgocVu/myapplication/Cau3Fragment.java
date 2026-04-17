package NgocVu.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Cau3Fragment extends Fragment {

    RecyclerView rvBaiThuoc;

    class BaiThuoc {
        String ten;
        String moTa;
        int hinhAnh;

        public BaiThuoc(String ten, String moTa, int hinhAnh) {
            this.ten = ten;
            this.moTa = moTa;
            this.hinhAnh = hinhAnh;
        }
    }

    public Cau3Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cau3, container, false);

        rvBaiThuoc = view.findViewById(R.id.rvBaiThuoc);
        rvBaiThuoc.setLayoutManager(new LinearLayoutManager(getContext()));

        List<BaiThuoc> dsBaiThuoc = new ArrayList<>();

        dsBaiThuoc.add(new BaiThuoc("Bài thuốc trị ho", "Thời gian uống: sau khi ăn", R.mipmap.hung));
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc giải cảm", "Thời gian uống: sau khi ăn", R.drawable.giaicam));
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc bổ não", "Thời gian uống: sau khi ăn", R.drawable.bonao));
        dsBaiThuoc.add(new BaiThuoc("Bài thuốc đau bụng", "Thời gian uống: sau khi ăn", R.drawable.daubung));

        rvBaiThuoc.setAdapter(new MyAdapter(dsBaiThuoc));

        return view;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        List<BaiThuoc> data;

        public MyAdapter(List<BaiThuoc> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bai_thuoc, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            BaiThuoc item = data.get(position);
            holder.tvTen.setText(item.ten);
            holder.tvMoTa.setText(item.moTa);
            holder.imgHinh.setImageResource(item.hinhAnh);
            
            holder.itemView.setOnClickListener(v -> 
                Toast.makeText(getContext(), "Bạn chọn: " + item.ten, Toast.LENGTH_SHORT).show()
            );
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvTen, tvMoTa;
            ImageView imgHinh;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTen = itemView.findViewById(R.id.tvTenThuoc);
                tvMoTa = itemView.findViewById(R.id.tvMoTa);
                imgHinh = itemView.findViewById(R.id.imgThuoc);
            }
        }
    }
}