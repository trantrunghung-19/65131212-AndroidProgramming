package com.example.thigk2trantrunghung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class TinhToanFragment extends Fragment {

    EditText edtChieuDai, edtChieuRong;
    Button btnChuVi, btnDienTich;
    TextView tvKetQua;

    public TinhToanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tinh_toan, container, false);

        edtChieuDai = view.findViewById(R.id.edtChieuDai);
        edtChieuRong = view.findViewById(R.id.edtChieuRong);
        btnChuVi = view.findViewById(R.id.btnChuVi);
        btnDienTich = view.findViewById(R.id.btnDienTich);
        tvKetQua = view.findViewById(R.id.tvKetQua);

        btnChuVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan(true);
            }
        });

        btnDienTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan(false);
            }
        });

        return view;
    }

    private void tinhToan(boolean isChuVi) {
        String chieuDaiStr = edtChieuDai.getText().toString();
        String chieuRongStr = edtChieuRong.getText().toString();

        if (chieuDaiStr.isEmpty() || chieuRongStr.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float chieuDai = Float.parseFloat(chieuDaiStr);
            float chieuRong = Float.parseFloat(chieuRongStr);

            if (chieuDai <= 0 || chieuRong <= 0) {
                Toast.makeText(getActivity(), "Chiều dài và chiều rộng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                return;
            }

            if (isChuVi) {
                float chuVi = (chieuDai + chieuRong) * 2;
                tvKetQua.setText(String.format("Chu vi: %.2f", chuVi));
            } else {
                float dienTich = chieuDai * chieuRong;
                tvKetQua.setText(String.format("Diện tích: %.2f", dienTich));
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}