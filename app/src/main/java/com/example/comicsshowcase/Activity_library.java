package com.example.comicsshowcase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ListFragment()).addToBackStack(null).commit();
    }
}
