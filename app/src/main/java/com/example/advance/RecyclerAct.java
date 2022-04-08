package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.advance.adapter.TemanAdapter;
import com.example.advance.database.DBController;
import com.example.advance.database.Teman;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
    DBController controller = new DBController(this);
    String id,nm,tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerviewact);
        fab = findViewById(R.id.addfloatbutton);

        BacaData();

        adapter = new TemanAdapter(temanArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerAct.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecyclerAct.this,TemanBaru.class);
                startActivity(i);
            }
        });
    }

    public void BacaData() {
        ArrayList<HashMap<String,String>> daftarTeman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();


        /*memindah dari hasil query kedalam Teman*/
        for(int i = 0;i<daftarTeman.size();i++){
            Teman teman = new Teman();

            teman.setId(daftarTeman.get(i).get("id").toString());
            teman.setNama(daftarTeman.get(i).get("nama").toString());
            teman.setTelpon(daftarTeman.get(i).get("telpon").toString());
            /*pindahkan dari Teman kedalam Arraylist teman di adapter*/
            temanArrayList.add(teman);
        }
    }
}