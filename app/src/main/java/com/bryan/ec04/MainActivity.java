package com.bryan.ec04;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bryan.ec04.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //private Button btnGetStarted;
    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);
        setContentView(binding.getRoot());
        boolean isSessionActivaded = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED, false);
        if(isSessionActivaded){
            Intent intent = new Intent(this, PrincipalActivity.class);
            startActivity(intent);
            finish();
        }

        binding.btnGetStarted.setOnClickListener(v ->{
            //Toast.makeText(this,"Comenzar",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } );
        binding.fltMain.setOnClickListener(view -> {
            String[] mensajes = {
                    "Very delicious Plates",
                    "Tipical Plates From Perú",
                    "The best choice",

            };
            int mensajeAleatorio = (int) (Math.random() * mensajes.length);
            String mensajeElegido = mensajes[mensajeAleatorio];
            Snackbar.make(binding.getRoot(), mensajeElegido,Snackbar.LENGTH_SHORT).show();
        });

    }
}