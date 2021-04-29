package com.example.calculator;

import android.app.Activity;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class ThemeHelper {
    public static void setTheme(Activity activity) {
        SharedPreferences sharedPref = activity.getSharedPreferences("Settings", MODE_PRIVATE);
        String themeId = sharedPref.getString("theme", "red");
        switch (themeId) {
            case "purple":
                activity.setTheme(R.style.Theme_Calculator);
                break;
            case "red":
                activity.setTheme(R.style.Theme_Calculator1);
                break;
        }
    }
}
