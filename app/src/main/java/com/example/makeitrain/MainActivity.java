package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private Button showInfo;
    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);
        //makeItRain.setOnClickListener(v -> Log.d("MainActivity", "onClick: Make it Rain"));

    }

    public void showMoney(View view) {
        NumberFormat numberFormat= NumberFormat.getCurrencyInstance();
        moneyCounter+=1000;
        if(moneyCounter==20000){
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                    R.color.Red));
        }
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("MIR", "showMoney: "+moneyCounter);
    }

    public void showInfo(View view) {
       // Toast.makeText(MainActivity.this,R.string.app_info,Toast.LENGTH_SHORT)
        //        .show();

        Snackbar make = Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
        .setAction("More", v ->
                Log.d("Snack", "Onclick: Snack More"));
        make.show();
    }
}

