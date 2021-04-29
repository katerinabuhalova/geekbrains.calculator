package com.example.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.buttonBack).setOnClickListener(view -> goBackActivity());
        findViewById(R.id.buttonPurple).setOnClickListener(view -> setThemePurple());
        findViewById(R.id.buttonRed).setOnClickListener(view -> setThemeRed());
    }

    private void goBackActivity() {
        finish();
    }

    private void setTheme() {
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        String themeId = sharedPref.getString("theme", "red");
        switch (themeId) {
            case "purple":
                this.setTheme(R.style.Theme_Calculator);
                break;
            case "red":
                this.setTheme(R.style.Theme_Calculator1);
                break;
        }
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