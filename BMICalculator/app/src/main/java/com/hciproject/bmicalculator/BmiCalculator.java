package com.hciproject.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BmiCalculator extends AppCompatActivity {

    public static EditText heightEditText, weightEditText;
    public static TextView bmiDisplay, category;
    public static double height, weight, bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        bmiDisplay = findViewById(R.id.bmiDisplayTextView);
        category = findViewById(R.id.categoryDisplayTextView);
    }

    public void calculateBMI(View view)
    {
        height = Double.parseDouble(heightEditText.getText().toString());
        weight = Double.parseDouble(weightEditText.getText().toString());

        bmi = weight / Math.pow(height, 2);

        DecimalFormat df = new DecimalFormat("##.##");
        bmi = Double.parseDouble(df.format(bmi));

        bmiDisplay.setText("Your BMI is: " + bmi);

        if(bmi < 18.5)
            category.setText("You are thin.");
        else if(bmi < 25)
            category.setText("You are healthy.");
        else if(bmi < 30)
            category.setText("You are overweight");
        else
            category.setText("You are obese.");

    }
}
