package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSzamlalo;
    private Button buttonPlus;
    private Button buttonMinus;
    private int szamlalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonPlus.setOnClickListener(view -> {

            szamlalo++;
            textViewSzamlalo.setText(String.valueOf(szamlalo));
            colorCheck();
        });

        buttonMinus.setOnClickListener(view -> {

            szamlalo--;
            textViewSzamlalo.setText(String.valueOf(szamlalo));
            colorCheck();
        });

        textViewSzamlalo.setOnClickListener(view -> {
            szamlalo = 0;
            textViewSzamlalo.setText(String.valueOf(szamlalo));
            colorCheck();
        });
    }

    public void init() {
        textViewSzamlalo = findViewById(R.id.textViewSzamlalo);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        szamlalo = 0;
    }

    public void colorCheck() {
        if (szamlalo > 0) {
            textViewSzamlalo.setTextColor(Color.rgb(0, 128, 0));
        }
        else if (szamlalo < 0) {
            textViewSzamlalo.setTextColor(Color.rgb(255, 0, 0));
        }
        else if (szamlalo == 0) {
            textViewSzamlalo.setTextColor(Color.rgb(61,0, 92));
        }
    }
}