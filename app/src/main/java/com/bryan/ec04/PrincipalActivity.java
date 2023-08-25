package com.bryan.ec04;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bryan.ec04.databinding.ActivityPrincipalBinding;
import com.bryan.ec04.fragments.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;
    public static String EMAIL = "EMAIL";

    public String email;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);
        setContentView(binding.getRoot());
        setSession();
        addHomeFragment();




    }

    private void addHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction().add(binding.fcwMain.getId(), new HomeFragment()).commit();
    }

    private void setSession() {
        Intent getIntent = getIntent();
        email = getIntent.getStringExtra(EMAIL);
        binding.textEmail.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.food_menu, menu);
        return true;
    }

    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Logout")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    logoutAndNavigateToLogin();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    // No hacer nada, el usuario canceló el logout
                })
                .show();
    }

    private void logoutAndNavigateToLogin() {
        sharedPreferences.edit().clear().apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){


        if (item.getItemId() == R.id.favorite) {

            Intent intent = new Intent(this, FavoritoDetailActivity.class);
            startActivity(intent);
            return true;

        } else if (item.getItemId() == R.id.settings) {

            Snackbar.make(binding.getRoot(),"Settings", Snackbar.LENGTH_SHORT).show();
            return true;

        }else if (item.getItemId() == R.id.logout) {

            showLogoutConfirmationDialog();
            return true;
        }
        else {
            return false;
        }

    }
}