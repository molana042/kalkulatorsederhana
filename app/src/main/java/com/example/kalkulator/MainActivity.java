package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mendapatkan referensi ke tombol "Hitung" dan "Tentang" pada layout
        Button hitungButton = findViewById(R.id.tombol1);
        Button tentangButton = findViewById(R.id.tombol2);

        // Menambahkan listener onClick pada tombol "Hitung"
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk pindah ke activity kalkulatorpage
                Intent intent = new Intent(MainActivity.this, kalkulatorpage.class);

                // Memulai activity baru
                startActivity(intent);
            }
        });

        // Menambahkan listener onClick pada tombol "Tentang"
        tentangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk pindah ke activity tentang
                Intent intent = new Intent(MainActivity.this, tentang.class);

                // Memulai activity baru
                startActivity(intent);
            }
        });
    }
}
