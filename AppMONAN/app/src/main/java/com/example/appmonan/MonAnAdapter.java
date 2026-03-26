package com.example.appmonan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MonAnAdapter(Context _context,ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater= LayoutInflater.from(_context);

    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewHienHanh = view ;
        if (viewHienHanh==null)
            viewHienHanh= layoutInflater.inflate(R.layout.item_monan,null);
        MonAn monAnHienTai=dsMonAn.get(i);
        TextView textView_TenMon=(TextView) viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia=(TextView) viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_Mota=(TextView) viewHienHanh.findViewById(R.id.tvMota);
        ImageView imageView_Anh=(ImageView) viewHienHanh.findViewById(R.id.imAnhDaiDien);

        textView_TenMon.setText(monAnHienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textView_Mota.setText(monAnHienTai.getMoTa());
        imageView_Anh.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return viewHienHanh;
    }
}
