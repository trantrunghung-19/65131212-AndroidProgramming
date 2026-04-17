package NgocVu.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Cau1Fragment extends Fragment {

    EditText edtChieuCao, edtCanNang;
    Button btnTinhBMI;
    TextView tvKetQua;

    public Cau1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);

        edtChieuCao = view.findViewById(R.id.edtChieuCao);
        edtCanNang = view.findViewById(R.id.edtCanNang);
        btnTinhBMI = view.findViewById(R.id.btnTinhBMI);
        tvKetQua = view.findViewById(R.id.tvKetQua);

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhBMI();
            }
        });

        return view;
    }

    private void tinhBMI() {
        String chieuCaoStr = edtChieuCao.getText().toString();
        String canNangStr = edtCanNang.getText().toString();

        if (chieuCaoStr.isEmpty() || canNangStr.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        float chieuCao = Float.parseFloat(chieuCaoStr);
        float canNang = Float.parseFloat(canNangStr);

        if (chieuCao <= 0) {
            Toast.makeText(getActivity(), "Chiều cao phải lớn hơn 0", Toast.LENGTH_SHORT).show();
            return;
        }

        float bmi = canNang / (chieuCao * chieuCao);
        String thongBao = "";

        if (bmi < 18.5) {
            thongBao = "Gầy";
        } else if (bmi < 24.9) {
            thongBao = "Bình thường";
        } else if (bmi < 29.9) {
            thongBao = "Tiền béo phì";
        } else {
            thongBao = "Béo phì";
        }

        tvKetQua.setText(String.format("BMI: %.2f\nTrạng thái: %s", bmi, thongBao));
    }
}