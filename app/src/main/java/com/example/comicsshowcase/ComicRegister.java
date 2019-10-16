package com.example.comicsshowcase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ComicRegister extends AppCompatActivity {
    String user_register = "";
    String pass_register = "";
    String repass_register = "";
    ComicDB_CRUD comicDB_crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = findViewById(R.id.btn_register);
        comicDB_crud = ComicDB_CRUD.getInstance(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
//                startActivity(intent);
                EditText username_register = findViewById(R.id.username_register);
                EditText password_register = findViewById(R.id.password_register);
                EditText re_password_register = findViewById(R.id.re_password_register);

                user_register = username_register.getText().toString();
                pass_register = password_register.getText().toString();
                repass_register = re_password_register.getText().toString();

                if (repass_register.equals(pass_register)) {
                    ComicDB_User comicDB_user = new ComicDB_User(user_register, repass_register);
                    comicDB_crud.addUser(comicDB_user);
                    Toast.makeText(ComicRegister.this, "Register successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ComicRegister.this, "Password not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
