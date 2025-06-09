package com.example.newsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Simulate a delay (not recommended for production apps)
        //try {
        //Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //e.printStackTrace();
        //}

        // Install the splash screen
        //SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable edge-to-edge
        // enableEdgeToEdge();
    }
}

   // private void enableEdgeToEdge() {
        // Make the app's content go edge-to-edge
        //ViewCompat.setOnApplyWindowInsetsListener(
                //findViewById(android.R.id.content),
                //(view, insets) -> {
                    //Insets systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    //view.setPadding(
                            //systemInsets.left,
                            //systemInsets.top,
                            //systemInsets.right,
                            //systemInsets.bottom
                    //);
                   // return insets;
               // }
       // );
   // }
//}

