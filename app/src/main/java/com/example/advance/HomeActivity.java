package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;
    /*membuat adapter*/
    private ListViewAdapter adapter;
    /*membuat array dengan nama array ListNama*/
    String[] listNama;

    public static ArrayList<ClassNama>classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Askar","Rahmat","Imam","Abdul Kadir","Asma","Intan","Rheana",
                "Rumisha"};

        list = findViewById(R.id.ListKontak);

        classNamaArrayList = new ArrayList<>();

        for(int i = 0; i<listNama.length;i++){
            ClassNama classNama = new ClassNama(listNama[i]);

            classNamaArrayList.add(classNama);

            adapter = new ListViewAdapter(this);

            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String nama =classNamaArrayList.get(position).getName();
                    bundle.putString("a",nama.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                    pm.setOnMenuItemClickListener(HomeActivity.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();
                }
            });
        }
    }
    /*OnClick Menu*/
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.mnedit:
                Toast.makeText(this, "Ini Untuk Edit Kontak", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}