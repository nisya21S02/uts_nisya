package com.example.uts_nisya;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Deklarasi Variable Pendukung
    private TextView hasil;
    private EditText masukan;
    private Button eksekusi;

    // Deklarasi dan Inisialisasi SharedPreferences
    private SharedPreferences preferences;

    // Digunakan untuk konfigurasi SharedPreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        masukan = findViewById(R.id.input);
        hasil = findViewById(R.id.output);
        eksekusi = findViewById(R.id.save);

        // Membuat file baru untuk SharedPreferences
        preferences = getSharedPreferences("Belajar_SharedPreferences", Context.MODE_PRIVATE);

        // Set OnClickListener pada tombol eksekusi
        eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData(); // Memanggil method getData
                Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        // Mendapatkan input dari user
        String getKonten = masukan.getText().toString();

        // Digunakan untuk pengaturan konfigurasi SharedPreferences
        editor = preferences.edit();

        // Memasukkan data ke editor SharedPreferences dengan key (data_saya)
        editor.putString("data_saya", getKonten);

        // Menjalankan operasi penyimpanan
        editor.apply();

        // Menampilkan output yang disimpan
        hasil.setText("Output Data: " + preferences.getString("data_saya", null));
    }
}
