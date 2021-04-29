package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int[] numberButtonIds = new int[]{R.id.buttonZero, R.id.buttonOne, R.id.buttonTwo, R.id.buttonThree,
            R.id.buttonFour, R.id.buttonFive, R.id.buttonSix, R.id.buttonSeven, R.id.buttonEight, R.id.buttonNine};

    private TextView output;
    private Processor processor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processor = new Processor();
        output = findViewById(R.id.output);

        setNumberButtonListeners();

        findViewById(R.id.buttonC).setOnClickListener(v -> operationClick(MathOperation.CLEAR));
        findViewById(R.id.buttonPlus).setOnClickListener(view -> operationClick(MathOperation.PLUS));
        findViewById(R.id.buttonMinus).setOnClickListener(view -> operationClick(MathOperation.MINUS));
        findViewById(R.id.buttonMultiplication).setOnClickListener(view -> operationClick(MathOperation.MULTIPLICATION));
        findViewById(R.id.buttonDivide).setOnClickListener(view -> operationClick(MathOperation.DIVIDE));
        findViewById(R.id.buttonEqually).setOnClickListener(view -> operationClick(MathOperation.EQUALLY));
        findViewById(R.id.buttonSetting).setOnClickListener(view -> openSettings());

    }

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            int index = i;
            findViewById(numberButtonIds[i]).setOnClickListener(view -> numberClick(index));
        }
    }

    private void openSettings() {
        finish();
        Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(runSettings);
    }

    private void numberClick(int number) {
        if (processor.getHasOperation()) {
            output.setText("");
        }
        processor.processNumber();
        output.append(String.valueOf(number));
    }

    private void operationClick(MathOperation operation) {
        if (operation == MathOperation.CLEAR) {
            output.setText("");
            return;
        }
        if (processor.getInputNumber1() == 0) {
            processor.setInputNumber1(Integer.parseInt(String.valueOf(output.getText())));
        } else {
            processor.setInputNumber2(Integer.parseInt(String.valueOf(output.getText())));
        }
        processor.processOperation(operation);
        if (operation == MathOperation.EQUALLY) {
            output.setText(String.valueOf(processor.getResult()));
        } else {
            String symbol = MathOperationToString(operation);
            output.setText(symbol);
        }
    }

    private String MathOperationToString(MathOperation operation) {
        String operationSymbol = "";
        switch (operation) {
            case PLUS:
                operationSymbol = "+";
                break;
            case MINUS:
                operationSymbol = "-";
                break;
            case MULTIPLICATION:
                operationSymbol = "*";
                break;
            case DIVIDE:
                operationSymbol = "/";
                break;
            case EQUALLY:
                operationSymbol = "=";
        }
        return operationSymbol;
    }
}