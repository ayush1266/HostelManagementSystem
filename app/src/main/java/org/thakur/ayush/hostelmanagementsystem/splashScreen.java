package org.thakur.ayush.hostelmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final Intent startAct = new Intent(splashScreen.this, MainActivity.class);
        final Runnable r = new Runnable() {
            public void run() {

               startActivity(startAct);
            }
        };
        Handler handler  =new Handler();
        handler.postDelayed(r, 3000);
    }

}