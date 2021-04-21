package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonZero;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonC;

    private TextView output;

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiplication;
    private Button buttonDivide;
    private Button buttonEqually;

    private boolean hasOperation;
    private int result;
    private int inputNumber1;
    private int inputNumber2;
    private MathOperation lastOperation = MathOperation.NONE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonZero = findViewById(R.id.buttonZero);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonC = findViewById(R.id.buttonC);


        output = findViewById(R.id.output);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqually = findViewById(R.id.buttonEqually);

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(0);
            }
        });


        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(1);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(2);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(3);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(4);
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(5);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(6);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(7);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(8);
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(9);
            }
        });

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

    private void numberClick(int number) {
        if (hasOperation) {
            output.setText("");
            hasOperation = false;
        }
        output.append(String.valueOf(number));
    }

    private void operationClick(MathOperation operation) {
        if (operation == MathOperation.CLEAR) {
            output.setText("");
            inputNumber1 = 0;
            inputNumber2 = 0;
            result = 0;
            lastOperation = MathOperation.NONE;
            return;
        }

        if (inputNumber1 == 0) {
            inputNumber1 = Integer.parseInt(String.valueOf(output.getText()));
        } else {
            inputNumber2 = Integer.parseInt(String.valueOf(output.getText()));
        }

        updateResult(inputNumber1, inputNumber2);

        if (operation == MathOperation.EQUALLY) {
            output.setText(String.valueOf(result));
            inputNumber1 = 0;
            inputNumber2 = 0;
            lastOperation = MathOperation.NONE;
        } else {
            lastOperation = operation;
            String symbol = MathOperationToString(operation);
            output.setText(symbol);
        }
        hasOperation = true;
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

    private void updateResult(int number1, int number2) {
        switch (lastOperation) {
            case PLUS:
                result = number1 + number2;
                break;
            case MINUS:
                result = number1 - number2;
                break;
            case MULTIPLICATION:
                result = number1 * number2;
                break;
            case DIVIDE:
                result = number1 / number2;
                break;
        }
    }
}