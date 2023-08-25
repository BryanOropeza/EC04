package com.bryan.ec04;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;

import com.bryan.ec04.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private SharedPreferences sharedPreferences;

    public static String SESSION_PREFERENCE = "SESSION_PREFERENCE";
    public static String SESSION_ACTIVATED = "SESSION_ACTIVATED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE,MODE_PRIVATE);
        binding.button.setOnClickListener(view -> {
            //Toast.makeText(this,"Login press",Toast.LENGTH_SHORT).show();
            sharedPreferences.edit().putBoolean(SESSION_ACTIVATED, true).apply();
            Intent intent = new Intent(this, PrincipalActivity.class);
            intent.putExtra(PrincipalActivity.EMAIL,binding.tilEmail.getEditText().getText().toString());
            startActivity(intent);
            finish();
        });
        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                boolean isOk = isCredentialValidate(charSequence.toString(), binding.tilPassword.getEditText().getText().toString());
                binding.button.setEnabled(isOk);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                boolean isOk = isCredentialValidate(binding.tilEmail.getEditText().getText().toString(), charSequence.toString());
                binding.button.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private boolean isCredentialValidate(String email, String password){

        boolean isEmailOk = (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) || email.equals("ejemplo@idat.com.pe");
        boolean isPasswordOk = (password.length() >= 8) || password.equals("peru1234");

        return isEmailOk && isPasswordOk;
    }
}