package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int[] numberButtonIds = new int[]{R.id.buttonZero, R.id.buttonOne, R.id.buttonTwo, R.id.buttonThree,
            R.id.buttonFour, R.id.buttonFive, R.id.buttonSix, R.id.buttonSeven, R.id.buttonEight, R.id.buttonNine};

    private TextView output;
    private Button buttonC;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiplication;
    private Button buttonDivide;
    private Button buttonEqually;

    private Processor processor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processor = new Processor();

        buttonC = findViewById(R.id.buttonC);
        output = findViewById(R.id.output);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqually = findViewById(R.id.buttonEqually);

        setNumberButtonListeners();

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationClick(MathOperation.CLEAR);
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick(MathOperation.PLUS);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick(MathOperation.MINUS);
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick(MathOperation.MULTIPLICATION);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick(MathOperation.DIVIDE);
            }
        });

        buttonEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationClick(MathOperation.EQUALLY);
            }
        });
    }

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            int index = i;
            findViewById(numberButtonIds[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numberClick(index);
                }
            });
        }
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