package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class kalkulatorpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulatorpage);
    }

    // Metode yang dijalankan saat tombol "Hitung" ditekan
    public void prosesHitung(View view) {
        // Mendapatkan referensi ke elemen EditText dan Spinner dari layout
        EditText angka1 = findViewById(R.id.angka1);
        EditText angka2 = findViewById(R.id.angka2);
        Spinner operator = findViewById(R.id.operator);

        // Mendapatkan tipe operator yang dipilih dari Spinner
        String tipeOperator = String.valueOf(operator.getSelectedItem());

        // Membuat objek Intent untuk berpindah ke aktivitas HasilPerhitungan
        Intent intent = new Intent(this, HasilPerhitungan.class);

        // Mengambil nilai dari EditText dan mengonversi ke tipe data double
        double nilai1 = Double.parseDouble(angka1.getText().toString());
        double nilai2 = Double.parseDouble(angka2.getText().toString());
        double hasil = 0;

        // Melakukan perhitungan berdasarkan operator yang dipilih
        if (tipeOperator.equals("Tambah")) {
            hasil = nilai1 + nilai2;
        } else if (tipeOperator.equals("Kurang")) {
            hasil = nilai1 - nilai2;
        } else if (tipeOperator.equals("Kali")) {
            hasil = nilai1 * nilai2;
        } else if (tipeOperator.equals("Bagi")) {
            // Menangani pembagian dengan nol
            if (nilai2 != 0) {
                hasil = nilai1 / nilai2;
            } else {
                // Jika pembagian dengan nol, kirim pesan error ke aktivitas HasilPerhitungan
                String pesanErrorNol = getString(R.string.pesanErrorNol);
                intent.putExtra("pesanError", pesanErrorNol);
            }
        } else if (tipeOperator.equals("Modulus")) {
            hasil = nilai1 % nilai2;
        }

        // Menyertakan hasil perhitungan ke Intent untuk ditampilkan di aktivitas HasilPerhitungan
        intent.putExtra("hasil", hasil);

        // Memulai aktivitas baru (HasilPerhitungan)
        startActivity(intent);
    }
}
