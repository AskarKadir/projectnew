package com.example.advance.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    /*berguna untuk memilih db yang akan dipakai*/
    public DBController(Context context) {
        super(context, "ProdiTI",null,1);
    }

    @Override
    /*function untuk membuat tabel dalam databse*/
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teman (id integer primary key,nama text, telpon text)");
    }

    @Override
    /*function untuk mengecek tabel dalam database ProdiTI*/
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion) {
        db.execSQL("drop table if exists teman");

        /*memanggil function membuat tabel*/
        onCreate(db);
    }

    /*public void insertData(HashMap<kunci,nilai>)*/
    public void insertData(HashMap<String,String>queryValues){
        /*untuk memberikan akses write pada database*/
        SQLiteDatabase basisdata = this.getWritableDatabase();

        /*mengambil data dari input*/
        ContentValues nilai = new ContentValues();

        /*memberikan nilai pada parameter function OnCreate*/
        nilai.put("nama",queryValues.get("nama"));
        nilai.put("telpon",queryValues.get("telpon"));

        /*memasukkan data pada tabel yang diinginkan serta memasukkan nilai pada kolom database*/
        basisdata.insert("teman",null,nilai);

        basisdata.close();
    }

    public ArrayList<HashMap<String,String>> getAllTeman(){
        ArrayList<HashMap<String,String>> daftarTeman;
        daftarTeman = new ArrayList<HashMap<String,String>>();
        String selectQuery = "Select * from teman";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("nama",cursor.getString(1));
                map.put("telpon",cursor.getString(2));
                daftarTeman.add(map);
            }while (cursor.moveToNext());
        }
        db.close();
        return daftarTeman;
    }

    /*ACT 7*/
    public void UpdateData(HashMap<String,String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama",queryValues.get("nama"));
        nilai.put("telpon",queryValues.get("telpon"));
        db.update("teman",nilai, "id=?", new String[]{queryValues.get("id")});
        db.close();

    }

    public void DeleteData(HashMap<String,String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("teman", "id=?", new String[]{queryValues.get("id")});
        db.close();
    }



}
