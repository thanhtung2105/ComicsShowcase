package com.example.comicsshowcase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity{
    public static String user_login = "" ;
    public static String pass_login = "" ;
    ComicDB_CRUD comicDB_crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.btn_login);
        Button register = findViewById(R.id.btn_register);
        comicDB_crud = ComicDB_CRUD.getInstance(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ComicRegister.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username_login = findViewById(R.id.username_login);
                EditText password_login = findViewById(R.id.password_login);

                user_login = username_login.getText().toString();
                pass_login = password_login.getText().toString();

                boolean check = comicDB_crud.checkLogin(user_login,pass_login);
                if (check)
                {
                    Intent intent = new Intent(MainActivity.this, Activity_library.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Wrong username or password?!", Toast.LENGTH_SHORT).show();
            }
        }
        ));
    }
}