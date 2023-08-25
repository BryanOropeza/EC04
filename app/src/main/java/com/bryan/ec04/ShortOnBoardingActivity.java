package com.bryan.ec04;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import com.bryan.ec04.databinding.ActivityShortOnBoardingBinding;

public class ShortOnBoardingActivity extends AppCompatActivity {


    private ActivityShortOnBoardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShortOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new CountDownTimer(3000,1000) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish(){
                Intent intent = new Intent(ShortOnBoardingActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        }.start();
    }
}