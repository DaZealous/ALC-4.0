package com.example.alcchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnProfile, btnAbout;
    String ALC_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfile = findViewById(R.id.btn_profile);
        btnAbout = findViewById(R.id.btn_about);

        ALC_URL = "https://andela.com/alc/";

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("url", ALC_URL);
                switchActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                switchActivity(intent);
            }
        });
    }

    private void switchActivity(Intent intent) {
        startActivity(intent);
    }
}
