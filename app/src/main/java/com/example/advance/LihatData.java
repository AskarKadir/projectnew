package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {

    TextView tvnama,tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvnama);
        tvnomor = findViewById(R.id.tvnomor);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        switch (nama){
            case "Askar":
                tvnama.setText("Askar");
                tvnomor.setText("1");
                break;
            case "Rahmat":
                tvnama.setText("Rahmat");
                tvnomor.setText("2");
                break;
            case "Imam":
                tvnama.setText("Imam");
                tvnomor.setText("3");
                break;
            case "Abdul Kadir":
                tvnama.setText("Abdul Kadir");
                tvnomor.setText("3");
                break;
            case "Asma":
                tvnama.setText("Asma");
                tvnomor.setText("4");
                break;
            case "Intan":
                tvnama.setText("Intan");
                tvnomor.setText("5");
                break;
            case "Rheana":
                tvnama.setText("Rheana");
                tvnomor.setText("6");
                break;
            case "Rumisha":
                tvnama.setText("Rumisha");
                tvnomor.setText("7");
                break;
        }
    }
}