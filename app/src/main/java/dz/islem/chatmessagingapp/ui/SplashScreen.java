package dz.islem.chatmessagingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import dz.islem.chatmessagingapp.R;

public class SplashScreen extends AppCompatActivity {

    private Handler mHandler;
    private long splashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, 3000);
    }

    private void startApp(){
        Intent mIntent = new Intent(getApplicationContext(),App.class);
        startActivity(mIntent);
        finish();
    }
}
