package com.example.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.buttonBack).setOnClickListener(view -> goBackActivity());
        findViewById(R.id.buttonPurple).setOnClickListener(view -> setThemePurple());
        findViewById(R.id.buttonRed).setOnClickListener(view -> setThemeRed());
    }

    private void goBackActivity() {
        finish();
        Intent runSettings = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(runSettings);
    }

    private void setThemePurple() {
        SharedPreferences sharedPref = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("theme", "purple");
        editor.commit();
        recreate();
    }

    private void setThemeRed() {
        SharedPreferences sharedPref = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("theme", "red");
        editor.commit();
        recreate();
    }
}