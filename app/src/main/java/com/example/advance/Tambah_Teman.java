package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Tambah_Teman extends AppCompatActivity {

    /*act8*/
    String nm,tlp;
    int success;
    private EditText editNama,editTelpon;
    private Button simpanBtn;
    private static String url_insert = "http://10.0.2.2/umyTI/tambahteman.php";
    private static final String TAG = Tambah_Teman.class.getSimpleName();
    private static final String TAG_SUCCESS = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);

        editNama = findViewById(R.id.edNamaact8);
        editTelpon = findViewById(R.id.edTelponact8);
        simpanBtn = findViewById(R.id.btnSimpanact8);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpanData();
            }
        });

    }

    public void SimpanData(){
        if(editNama.getText().toString().isEmpty() || editTelpon.getText().toString().isEmpty()){
            Toast.makeText(this, "Isi Semua Data", Toast.LENGTH_SHORT).show();
        }else {
            nm = editNama.getText().toString();
            tlp = editTelpon.getText().toString();

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

            StringRequest strReq = new StringRequest(Request.Method.POST, url_insert, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Response : " + response);
                    try {
                        JSONObject jObj = new JSONObject(response);
                        success = jObj.getInt(TAG_SUCCESS);
                        if (success == 1) {
                            Toast.makeText(Tambah_Teman.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Tambah_Teman.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG,"Error : "+error.getMessage());
                    Toast.makeText(Tambah_Teman.this, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<>();
                    params.put("nama",nm);
                    params.put("telpon",tlp);
                    return params;
                }
            };requestQueue.add(strReq);
        }
    }
}