package com.example.newsapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the splash screen theme
        setTheme(R.style.Theme_App_SplashScreen);

        // Delay for 3 seconds, then move to SignupActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // 3000 ms = 3 seconds
    }
}
