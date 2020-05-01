package com.hciproject.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBMI(View view){
        intent = new Intent(this, BmiCalculator.class);
        startActivity(intent);
    }

    public void onClickCalorie(View view){
        intent = new Intent(this, CalorieCounter.class);
        startActivity(intent);
    }
}
