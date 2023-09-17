package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSzamlalo;
    private Button buttonPlus;
    private Button buttonMinus;
    private int szamlalo;
    private RelativeLayout layout;

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

        textViewSzamlalo.setOnLongClickListener(view -> {
            szamlalo = 0;
            textViewSzamlalo.setText(String.valueOf(szamlalo));
            colorCheck();
            return true;
        });

        layout.getDisplay().getOrientation();
    }

    public void init() {
        textViewSzamlalo = findViewById(R.id.textViewSzamlalo);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        layout = findViewById(R.id.relativeLayout);
        szamlalo = 0;
    }

    public void colorCheck() {
        if (!isPrime()) {
            textViewSzamlalo.setTextColor(getResources().getColor(R.color.white));
        }
        else if (szamlalo > 0) {
            textViewSzamlalo.setTextColor(Color.rgb(0, 128, 0));
        }
        else if (szamlalo < 0) {
            textViewSzamlalo.setTextColor(Color.rgb(255, 0, 0));
        }
        if (szamlalo == 0) {
            textViewSzamlalo.setTextColor(Color.rgb(61,0, 92));
        }
    }

    public boolean isPrime() {
        int szam = Math.abs(szamlalo);

        for (int i = 2; i <= szam / 2; ++i) {
            if (szam % i == 0) {
                return true;
            }
        }
        return false;
    }
}