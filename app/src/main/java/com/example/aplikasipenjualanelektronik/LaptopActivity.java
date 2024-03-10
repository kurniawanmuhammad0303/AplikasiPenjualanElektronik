package com.example.aplikasipenjualanelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LaptopActivity extends AppCompatActivity {

    private ListView listViewLaptop;
    private ArrayAdapter<String> adapter;
    private String[] laptopNames = {"Acer Aspire 5 A514", "Lenovo Yoga 9i", "Advan Workplus"};
    private String[] laptopPrices = {"Rp 8.999.000", "Rp 29.999.000", "Rp 6.999.000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);

        listViewLaptop = findViewById(R.id.listViewLaptop);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, laptopNames);
        listViewLaptop.setAdapter(adapter);

        listViewLaptop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = laptopNames[position];
                String price = laptopPrices[position];
                String spesifikasi = getSpesifikasiLaptop(position);

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
                    Toast.makeText(LaptopActivity.this, "WhatsApp tidak terinstall.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    // Metode ini mengembalikan string spesifikasi untuk laptop tertentu berdasarkan posisi
    private String getSpesifikasiLaptop(int position) {
        String spesifikasi = "";
        switch (position) {
            case 0:
                spesifikasi = "Sistem Operasi: Windows 11 Home\n" +
                        "Prosesor: Intel Core i5-1335U, 10-Core up to 4.6 GHz\n" +
                        "RAM: 8GB\n" +
                        "Storage: 512 GB SSD\n" +
                        "Layar Monitor: IPS LED, 14 Inci FHD+ 1920 x 1080 piksel\n" +
                        "Port Konektivitas: HDMI, USB Type C, Thunderbolt 4, Headphone Jack\n" +
                        "Konektivitas Nirkabel: WiFi, Bluetooth 5.2\n" +
                        "Webcam: FHD 1080p at 60 fps with Temporal Noise Reduction\n" +
                        "Audio: Stereo Speaker with Acer TrueHarmony\n" +
                        "Keyboard: Backlit Keyboard\n" +
                        "Baterai: 50 Wh Li-ion\n" +
                        "Dimensi: 31.8 x 22.5 x 1.78 cm, berat: 2 kg.";
                break;
            case 1:
                spesifikasi = "Sistem Operasi: Windows 11 Home\n" +
                        "Prosesor: Intel Core i7-1195G7, Quad Core up to 5.0 GHz\n" +
                        "RAM: 16GB\n" +
                        "Storage: 1 TB SSD\n" +
                        "Layar Monitor: OLED, 14 Inci UHD+ 3840 x 2160 piksel\n" +
                        "Port Konektivitas: USB Type C, Thunderbolt 4, DisplayPort, Headphone Jack\n" +
                        "Konektivitas Nirkabel: WiFi, Bluetooth 5.1\n" +
                        "Webcam: FHD 1080p at 60 fps with Temporal Noise Reduction\n" +
                        "Audio: Camera 720p with Microphone Array\n" +
                        "Keyboard: Backlit Keyboard\n" +
                        "Baterai: 60 Wh Li-ion\n" +
                        "Dimensi: 31.9 x 21.6 x 1.53 cm, berat: 1.44 kg.";
                break;
            case 2:
                spesifikasi = "Sistem Operasi: Windows 11 Home\n" +
                        "Prosesor: AMD Ryzen 5 6600H, 6-Core up to 4.5 GHz\n" +
                        "RAM: 16GB\n" +
                        "Storage: 512 GB SSD\n" +
                        "Layar Monitor: IPS LCD, 14 Inci FHD+ 1920 x 1200 piksel\n" +
                        "Port Konektivitas: USB Type C, Micro SD, HDMI, Headphone Jack\n" +
                        "Konektivitas Nirkabel: WiFi, Bluetooth\n" +
                        "Webcam: Webcam 720p\n" +
                        "Audio: Stereo Speaker\n" +
                        "Keyboard: Backlit Keyboard\n" +
                        "Baterai: 58 Wh Li-ion\n" +
                        "Dimensi: 31.3 x 22.2 x 1.78 cm, berat: 1.3 kg.";
                break;
        }
        return spesifikasi;
    }
}

