package com.example.aplikasipenjualanelektronik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLaptop = findViewById(R.id.btnLaptop);
        btnLaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LaptopActivity.class);
                startActivity(intent);
            }
        });

        Button btnHp = findViewById(R.id.btnHp);
        btnHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HpActivity.class);
                startActivity(intent);
            }
        });

        Button btnTablet = findViewById(R.id.btnTablet);
        btnTablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabletActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}