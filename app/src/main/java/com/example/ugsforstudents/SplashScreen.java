package com.example.ugsforstudents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;

import static com.example.ugsforstudents.MainActivity.webView;
import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent it=new Intent(SplashScreen.this,MainActivity.class);
                    ActivityOptions options =
                            ActivityOptions.makeCustomAnimation(getApplicationContext(), R.transition.animation, R.transition.fadeout);
                    startActivity(it, options.toBundle());
                    startActivity(it);
                    SplashScreen.this.finish();
                }
            }
        });
        thread.start();
    }
}