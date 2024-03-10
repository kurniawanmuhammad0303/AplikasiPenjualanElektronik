package com.example.aplikasipenjualanelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtNamaBarang = findViewById(R.id.txtNamaBarang);
        TextView txtSpesifikasi = findViewById(R.id.txtSpesifikasi);
        TextView txtHargaBarang = findViewById(R.id.txtHargaBarang);

        Intent intent = getIntent();
        if (intent != null) {
            String namaBarang = intent.getStringExtra("nama_barang");
            String hargaBarang = intent.getStringExtra("harga_barang");
            String spesifikasi = intent.getStringExtra("spesifikasi");

            txtNamaBarang.setText(namaBarang);
            txtHargaBarang.setText(hargaBarang);
            txtSpesifikasi.setText(spesifikasi);
        }
    }
}

