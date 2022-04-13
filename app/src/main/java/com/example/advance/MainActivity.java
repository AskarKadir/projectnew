package com.example.advance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*deklarasi variabel*/
        EditText Lemail,Lpassword;
        TextInputLayout LP,LE;
        LE = findViewById(R.id.EmailLayout);
        LP = findViewById(R.id.PassLayout);
        Button BLogin,Regis;
        /*Find view by id*/
        BLogin = findViewById(R.id.Login);
        Regis = findViewById(R.id.Register);
        Lemail = findViewById(R.id.LEmail);
        Lpassword = findViewById(R.id.LPassword);
        /*Ketika button Login ditekan, akan lanjut kepada Halaman Berikutnya
        * dengan menggunakan
        * Email : aka
        * Pass  : aka1
        * */
        BLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Konversi email dan password user*/
                String Email,Password;
                Email = Lemail.getText().toString();
                Password = Lpassword.getText().toString();
                if(Email.equals("") && Password.equals("")){
                    Intent i = new Intent(MainActivity.this,HalamanAwal.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                }else if(Email.equals("aka") && !Password.equals("aka1")){
                    LE.setHelperText(" ");
                    LP.setHelperText("Password Salah");
                }else if(!Email.equals("aka") && Password.equals("aka1")){
                    LE.setHelperText("Email Salah");
                    LP.setHelperText(" ");
                }else if(Email.isEmpty() && Password.isEmpty()){
                    LE.setHelperText("Email Anda Kosong");
                    LP.setHelperText("Password Anda Kosong");
                }else{
                    LE.setHelperText("Email Salah");
                    LP.setHelperText("Password Salah");
                }
            }
        });
        /*Akan Hadir*/
        /*Halaman Pendaftaran*/
        Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fitur akan Hadir", Toast.LENGTH_SHORT).show();
            }
        });
    }
}