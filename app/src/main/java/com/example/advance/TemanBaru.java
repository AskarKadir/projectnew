package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.advance.database.DBController;
import com.example.advance.database.Teman;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class TemanBaru extends AppCompatActivity {

    private TextInputLayout TInama,TInomor;
    private Button Bsimpan;
    String nm,tlp;
    DBController controller = new DBController(TemanBaru.this);
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        TInama = findViewById(R.id.TINamaL);
        TInomor =  findViewById(R.id.TINomorL);
        Bsimpan =  findViewById(R.id.BSimpan);

        Bsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TInama.getEditText().getText().toString().isEmpty() || TInomor.getEditText().getText().toString().isEmpty()){
                    Toast.makeText(TemanBaru.this, "Nama dan Nomor Wajib di isi...", Toast.LENGTH_SHORT).show();
                }else{
                    nm = TInama.getEditText().getText().toString();
                    tlp = TInomor.getEditText().getText().toString();
                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);

                    controller.insertData(qvalues);
                    callHome();

                    Toast.makeText(TemanBaru.this, "Data telah disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void callHome(){
        Intent i = new Intent(TemanBaru.this,RecyclerAct.class);
        startActivity(i);
        finish();
    }



}