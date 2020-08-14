package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mealsOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_options);

        Button btn = (Button)findViewById(R.id.mealsBreakfastBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mealsOptions.this, breakfastMenu.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.mealsLunchBtn);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mealsOptions.this, lunchMenu.class));
            }
        });

        Button btn3 = (Button)findViewById(R.id.mealsDinnerBtn);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mealsOptions.this, dinnerMenu.class));
            }
        });
    }
}