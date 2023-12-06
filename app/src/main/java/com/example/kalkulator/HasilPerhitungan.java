package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HasilPerhitungan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_perhitungan);

        // Mengambil intent yang memicu aktivitas ini
        Intent intent = getIntent();

        // Mendapatkan referensi ke TextView pada layout dengan ID tampilHitung
        TextView tampilHitung = findViewById(R.id.tampilHitung);

        // Memeriksa apakah intent memiliki ekstra dengan kunci "pesanError"
        if (intent.hasExtra("pesanError")) {
            // Jika ada, set teks pada TextView dengan nilai dari ekstra tersebut
            tampilHitung.setText(intent.getStringExtra("pesanError"));
        } else {
            // Jika tidak ada pesan error, ambil nilai hasil dari ekstra dengan kunci "hasil"
            double hasil = intent.getDoubleExtra("hasil", 0);

            // Memastikan bahwa nilai hasil tidak kosong
            String hasilText = String.valueOf(hasil);
            if (hasilText.isEmpty()) {
                // Jika hasil kosong, set teks pada TextView dengan pesan default
                hasilText = getString(R.string.pesanHasil);
            }

            // Set teks pada TextView dengan nilai hasil atau pesan default
            tampilHitung.setText(hasilText);
        }
    }

}
