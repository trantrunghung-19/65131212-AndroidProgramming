package com.example.bth4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKetqua;
    Button nutcong,nuttru,nutnhan,nutchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void TimDieuKhien(){
        editTextSo1=(EditText) findViewById(R.id.edtSo1);
        editTextSo2=(EditText) findViewById(R.id.edtSo2);
        editTextKetqua=(EditText) findViewById(R.id.edtKetqua);
        nutcong =(Button) findViewById(R.id.btnCong);
        nuttru =(Button) findViewById(R.id.btnTru);
        nutnhan =(Button) findViewById(R.id.btnNhan);
        nutchia =(Button) findViewById(R.id.btnChia);
    }
    public void Cong(View v){

        String Sothu1=editTextSo1.getText().toString();
        String Sothu2=editTextSo2.getText().toString();
        float soA=Float.parseFloat(Sothu1);
        float soB=Float.parseFloat(Sothu2);
        float Tong=soA+soB;

        String chuoiKetqua= String.valueOf(Tong);
        editTextKetqua.setText(chuoiKetqua);
    }
    public void Tru(View v){

        String Sothu1=editTextSo1.getText().toString();
        String Sothu2=editTextSo2.getText().toString();
        float soA=Float.parseFloat(Sothu1);
        float soB=Float.parseFloat(Sothu2);
        float Hieu=soA-soB;

        String chuoiKetqua= String.valueOf(Hieu);
        editTextKetqua.setText(chuoiKetqua);
    }
    public void Nhan(View v){

        String Sothu1=editTextSo1.getText().toString();
        String Sothu2=editTextSo2.getText().toString();
        float soA=Float.parseFloat(Sothu1);
        float soB=Float.parseFloat(Sothu2);
        float Tich=soA*soB;

        String chuoiKetqua= String.valueOf(Tich);
        editTextKetqua.setText(chuoiKetqua);
    }
    public void Chia(View v){

        String Sothu1=editTextSo1.getText().toString();
        String Sothu2=editTextSo2.getText().toString();
        float soA=Float.parseFloat(Sothu1);
        float soB=Float.parseFloat(Sothu2);
        float Thuong=soA/soB;

        String chuoiKetqua= String.valueOf(Thuong);
        editTextKetqua.setText(chuoiKetqua);
    }
}