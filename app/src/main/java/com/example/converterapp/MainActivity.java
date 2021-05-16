package com.example.converterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.converterapp.InfixToPostfix.infixToPostfix;
import static com.example.converterapp.PostfixToInfix.postfixToInfix;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private static final String[] paths = {"Infix to Postfix", "Postfix to Infix"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void convert(View view) {
        TextView resultTextView = (TextView) findViewById(
                R.id.result_text_view);
        TextView inputTextView = (TextView) findViewById(
                R.id.input_text_view);
        String item = spinner.getSelectedItem().toString();
        if (item == "Infix to Postfix") {
            resultTextView.setText("Result: \n"+infixToPostfix(inputTextView.getText().toString()));
        } else {
            resultTextView.setText("Result: \n"+postfixToInfix(inputTextView.getText().toString()));
        }
    }
};




