package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class mealsOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_options);

        Calendar date = null;
        Button btn1 = (Button)findViewById(R.id.mealsBreakfastBtn);
        Button btn2 = (Button)findViewById(R.id.mealsLunchBtn);
        Button btn3 = (Button)findViewById(R.id.mealsDinnerBtn);
        Button btn4 = (Button)findViewById(R.id.mealsBarBtn);
        Button btn5 = (Button)findViewById(R.id.mealsSnackBtn);

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        final int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println(currentHour);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentHour >= 6 && currentHour <= 10){
                    startActivity(new Intent(mealsOptions.this, breakfastMenu.class));
                    Toast.makeText(getApplicationContext(), "Breakfast Time!! ", Toast.LENGTH_SHORT).show();
                }
                else{
                    //temp
                    startActivity(new Intent(mealsOptions.this, breakfastMenu.class));
                    Toast.makeText(getApplicationContext(), "Not the time for Breakfast :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentHour >= 11 && currentHour <= 15){
                    startActivity(new Intent(mealsOptions.this, lunchMenu.class));
                    Toast.makeText(getApplicationContext(), "Lunch Time!! ", Toast.LENGTH_SHORT).show();
                }
                else{
                    //temp
                    startActivity(new Intent(mealsOptions.this, lunchMenu.class));
                    Toast.makeText(getApplicationContext(), "Not the time for Lunch :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentHour >= 19 && currentHour <= 22){
                    startActivity(new Intent(mealsOptions.this, dinnerMenu.class));
                    Toast.makeText(getApplicationContext(), "Dinner Time!! ", Toast.LENGTH_SHORT).show();
                }
                else{   //temp
                    startActivity(new Intent(mealsOptions.this, dinnerMenu.class));
                    Toast.makeText(getApplicationContext(), "Not the time for Dinner :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentHour >= 16 && currentHour <= 01){
                    startActivity(new Intent(mealsOptions.this, barMenu.class));
                    Toast.makeText(getApplicationContext(), "Lets Sumihiri Pane!! ", Toast.LENGTH_SHORT).show();
                }
                else{
                    //temp
                    startActivity(new Intent(mealsOptions.this, barMenu.class));
                    Toast.makeText(getApplicationContext(), "Bar is closed :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentHour >= 7 && currentHour <= 23){
                    startActivity(new Intent(mealsOptions.this, snacksMenu.class));
                    Toast.makeText(getApplicationContext(), "Snack Time!! ", Toast.LENGTH_SHORT).show();
                }
                else{
//temp
                    startActivity(new Intent(mealsOptions.this, snacksMenu.class));
                    Toast.makeText(getApplicationContext(), "Snacks? Now? ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
