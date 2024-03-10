package com.example.aplikasipenjualanelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TabletActivity extends AppCompatActivity {

    private ListView listViewTablet;
    private ArrayAdapter<String> adapter;
    private String[] tabletNames = {"Samsung Galaxy Tab S9 Ultra", "Huawei MatePad 11.5", "Xiaomi Pad 6"};
    private String[] tabletPrices = {"Rp 16.999.000", "Rp 6.000.000", "Rp 4.999.000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);

        listViewTablet = findViewById(R.id.listViewTablet);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tabletNames);
        listViewTablet.setAdapter(adapter);

        listViewTablet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = tabletNames[position];
                String price = tabletPrices[position];
                String spesifikasi = getSpesifikasiTablet(position);

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
                    Toast.makeText(TabletActivity.this, "WhatsApp tidak terinstall.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Metode ini mengembalikan string spesifikasi untuk tablet tertentu berdasarkan posisi
    private String getSpesifikasiTablet(int position) {
        String spesifikasi = "";
        switch (position) {
            case 0:
                spesifikasi = "OS Version: Android 13\n" +
                        "Screen Size: 14.6 inch\n" +
                        "Screen Resolution: 1848 x 2960 Pixel\n" +
                        "Chipset: Qualcomm SM8550-AB Snapdragon 8 Gen 2\n" +
                        "RAM: 12 GB\n" +
                        "Internal: 256 GB\n" +
                        "Resolusi Kamera: 13 MP\n" +
                        "Secondary Camera: 12\n" +
                        "USB: USB Type-C 3.2\n" +
                        "NFC: Tidak\n" +
                        "Battery: 11200 mAh";
                break;
            case 1:
                spesifikasi = "OS Version: Harmony OS 3.1\n" +
                        "Screen Size: 11.5 inch\n" +
                        "Screen Resolution: 1440 x 2200 Pixel\n" +
                        "Chipset: Qualcomm SM7450-AB Snapdragon 7 Gen 1 (4 nm)\n" +
                        "RAM: 8 GB\n" +
                        "Internal: 128 GB\n" +
                        "Resolusi Kamera: 13 MP\n" +
                        "Secondary Camera: 8\n" +
                        "USB: USB Type-C\n" +
                        "NFC: Tidak\n" +
                        "Battery: 7700 mAh";
                break;
            case 2:
                spesifikasi = "OS Version: Android 13\n" +
                        "Screen Size: 11 inch\n" +
                        "Screen Resolution: 1800 x 2880 Pixel\n" +
                        "Chipset: Qualcomm SM8250-AC Snapdragon 870 5G (7 nm)\n" +
                        "RAM: 8 GB\n" +
                        "Internal: 256 GB\n" +
                        "Resolusi Kamera: 13 MP\n" +
                        "Secondary Camera: 8\n" +
                        "USB: USB Type-C 3.2\n" +
                        "NFC: Tidak\n" +
                        "Battery: 8840 mAh";
                break;
        }
        return spesifikasi;
    }
}


