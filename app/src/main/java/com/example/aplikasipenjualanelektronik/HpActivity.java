package com.example.aplikasipenjualanelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HpActivity extends AppCompatActivity {

    private ListView listViewHp;
    private ArrayAdapter<String> adapter;
    private String[] hpNames = {"POCO X6 Pro 5G", "POCO M6 Pro", "POCO F5"};
    private String[] hpPrices = {"Rp 4.999.000", "Rp 2.999.000", "Rp 4.999.000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);

        listViewHp = findViewById(R.id.listViewHp);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hpNames);
        listViewHp.setAdapter(adapter);

        listViewHp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = hpNames[position];
                String price = hpPrices[position];
                String spesifikasi = getSpesifikasiHP(position);

                // Membuat pesan yang akan dikirim ke WhatsApp
                String message = "Nama Barang: " + name + "\n" +
                        "Harga: " + price + "\n" +
                        "Spesifikasi: " + spesifikasi;

                // Membuat intent untuk membuka WhatsApp dengan pesan yang sudah disiapkan
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");

                try {
                    startActivity(sendIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(HpActivity.this, "WhatsApp tidak terinstall.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Metode ini mengembalikan string spesifikasi untuk HP tertentu berdasarkan posisi
    private String getSpesifikasiHP(int position) {
        String spesifikasi = "";
        switch (position) {
            case 0:
                spesifikasi = "OS Version: 14\n" +
                        "Ukuran Layar: 6.67 inch\n" +
                        "Screen Resolution: 2712 × 1220 Pixel\n" +
                        "Detail Prosesor: Dimensity 8300 Ultra\n" +
                        "RAM: 12 GB\n" +
                        "Memori Internal: 512 GB\n" +
                        "Resolusi Kamera Belakang: 64 MP\n" +
                        "Resolusi Kamera Utama Lainnya: 8, 2 MP\n" +
                        "Resolusi Kamera Depan: 16 MP\n" +
                        "USB: Type-C\n" +
                        "Kapasitas Baterai: 5000 mAh";
                break;
            case 1:
                spesifikasi = "OS Version: Android 13\n" +
                        "Ukuran Layar: 6.67 inch\n" +
                        "Screen Resolution: 2400 x 1080 Pixel\n" +
                        "Detail Prosesor: Helio G99-Ultra\n" +
                        "RAM: 8 GB\n" +
                        "Memori Internal: 256 GB\n" +
                        "Resolusi Kamera Belakang: 64 MP\n" +
                        "Resolusi Kamera Utama Lainnya: 8, 2 MP\n" +
                        "Resolusi Kamera Depan: 16 MP\n" +
                        "USB: Type-C\n" +
                        "Kapasitas Baterai: 5000 mAh";
                break;
            case 2:
                spesifikasi = "OS Version: Android 13\n" +
                        "Ukuran Layar: 6.67 inch\n" +
                        "Screen Resolution: 2400 x 1080 Pixel\n" +
                        "Detail Prosesor: Snapdragon 7+ Gen2\n" +
                        "RAM: 8 GB\n" +
                        "Memori Internal: 256 GB\n" +
                        "Resolusi Kamera Belakang: 64 MP\n" +
                        "Resolusi Kamera Utama Lainnya: 8, 2 MP\n" +
                        "Resolusi Kamera Depan: 16 MP\n" +
                        "USB: Type-C, USB OTG\n" +
                        "Kapasitas Baterai: 5000 mAh";
                break;
        }
        return spesifikasi;
    }
}


