package com.example.newsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Simulate a delay (not recommended for production apps)
        Thread.sleep(3000)
        // Install the splash screen
        installSplashScreen()
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
}

