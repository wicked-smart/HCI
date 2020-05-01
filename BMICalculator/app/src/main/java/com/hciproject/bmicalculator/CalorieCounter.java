package com.hciproject.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalorieCounter extends AppCompatActivity {

    public static Spinner breakfastSpinner, lunchSpinner, dinnerSpinner;

    public static String breakfastOptions[] = {"Poha", "Maggi", "Bread Butter", "Sandwich", "Dosa", "nothing"},
                        lunchOptions[] = {"Roti Sabzi", "Dal Chawal", "Maggi", "Aloo Paratha", "Masala Dosa", "nothing"},
                        dinnerOptions[] = {"Roti Sabzi", "Dal Chawal", "Maggi", "Aloo Paratha", "Masala Dosa", "nothing"};

    public static TextView resultTextView;

    public static int totalCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);
        breakfastSpinner= findViewById(R.id.breakfastSpinner);
        lunchSpinner = findViewById(R.id.lunchSpinner);
        dinnerSpinner = findViewById(R.id.dinnerSpinner);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<String> breakfastAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, breakfastOptions);
        breakfastSpinner.setAdapter(breakfastAdapter);

        ArrayAdapter<String> lunchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lunchOptions);
        lunchSpinner.setAdapter(lunchAdapter);

        ArrayAdapter<String> dinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dinnerOptions);
        dinnerSpinner.setAdapter(dinnerAdapter);

    }

    public void calculate(View view)
    {
        totalCalories = getBreakfastCalories() + getLunchCalories() + getDinnerCalories();

        if(totalCalories <= 2000)
            resultTextView.setText("A standard adult needs 2000 calories a day. You had " + totalCalories + " calories today. You need " + (2000 - totalCalories) + " more today.");
        else
            resultTextView.setText("A standard adult needs 2000 calories a day. You had " + totalCalories + " calories today. You had " + (totalCalories - 2000) + " extra today.");
    }

    public static int getBreakfastCalories(){
        long selected = breakfastSpinner.getSelectedItemId();
        if(selected == 0)
            return 180;
        if(selected == 1)
            return 300;
        if(selected == 2)
            return 320;
        if(selected == 3)
            return 250;
        if(selected == 4)
            return 150;
        else
            return 0;
    }

    public static int getLunchCalories(){
        long selected = lunchSpinner.getSelectedItemId();
        if(selected == 0)
            return 900;
        if(selected == 1)
            return 1000;
        if(selected == 2)
            return 300;
        if(selected == 3)
            return 1300;
        if(selected == 4)
            return 800;
        else
            return 0;
    }

    public static int getDinnerCalories(){
        long selected = dinnerSpinner.getSelectedItemId();
        if(selected == 0)
            return 900;
        if(selected == 1)
            return 1000;
        if(selected == 2)
            return 300;
        if(selected == 3)
            return 1300;
        if(selected == 4)
            return 800;
        else
            return 0;
    }
}
