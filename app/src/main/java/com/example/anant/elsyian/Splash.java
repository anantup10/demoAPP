package com.example.anant.elsyian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
ProgressBar pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pm = (ProgressBar) findViewById(R.id.pm);

        Timer t = new Timer();
        boolean checkConnection = new LoadBackgroundData().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 5000);
        } else {
            Toast.makeText(this, "Internet Not connected", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(Splash.this, MainActivity.class);
            finish();
            startActivity(i);
        }

    }
}