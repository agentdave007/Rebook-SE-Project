package com.example.rebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.rebook.login.LoginActivity;

public class splashActivity extends AppCompatActivity {
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       // Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashanimation);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        };
        mHandler= new Handler();
        mHandler.postDelayed(mRunnable,3000);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler!=null && mRunnable!=null)
            mHandler.removeCallbacks(mRunnable);
    }
}

