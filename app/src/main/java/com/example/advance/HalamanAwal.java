package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.advance.database.Teman;

public class HalamanAwal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanawal);

        TextView act5, exe1, logindata, recyclerview;

        act5 = findViewById(R.id.act5);
        recyclerview = findViewById(R.id.recyclerview);

        act5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });

        recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RecyclerAct.class);
                startActivity(i);
            }
        });
    }
}