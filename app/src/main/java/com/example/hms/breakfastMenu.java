package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.hms.classes.Meals;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class breakfastMenu extends AppCompatActivity implements View.OnClickListener {
    String strMealList = "";
    Button bfBtn;
    DatabaseReference dbRef;
    Meals meals;
    CheckBox bfCb1, bfCb1b, bfCb2, bfCb2b, bfCb3, bfCb3b;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_menu);

        meals = new Meals();
        bfBtn = findViewById(R.id.bfBtn);

        bfCb1 = findViewById(R.id.bfCb1);
        bfCb1.setOnClickListener(this);
        bfCb1b = findViewById(R.id.bfCb1b);
        bfCb1b.setOnClickListener(this);
        bfCb2 = findViewById(R.id.bfCb2);
        bfCb2.setOnClickListener(this);
        bfCb2b = findViewById(R.id.bfCb2b);
        bfCb2b.setOnClickListener(this);
        bfCb3 = findViewById(R.id.bfCb3);
        bfCb3.setOnClickListener(this);
        bfCb3b = findViewById(R.id.bfCb3b);
        bfCb3b.setOnClickListener(this);

        bfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Meals");
                for (int i = 0; i < myList.size(); i++) {
                    strMealList += myList.get(i) + ",";
                }

                Log.i("Tag", strMealList);
                Toast.makeText(getApplicationContext(), strMealList, Toast.LENGTH_SHORT).show();

                dbRef.child("Breakfast").setValue(strMealList);

                startActivity(new Intent(breakfastMenu.this, configDash.class));

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bfCb1:
                if (bfCb1.isChecked()) {
                    myList.add("Meal1");
                }
                break;
            case R.id.bfCb1b:
                if (bfCb1b.isChecked()) {
                    myList.add("Meal2");
                }
                break;
            case R.id.bfCb2:
                if (bfCb2.isChecked()) {
                    myList.add("Meal3");
                }
                break;
            case R.id.bfCb2b:
                if (bfCb2b.isChecked()) {
                    myList.add("Meal4");
                }
                break;
            case R.id.bfCb3:
                if (bfCb3.isChecked()) {
                    myList.add("Meal5");
                }
                break;
            case R.id.bfCb3b:
                if (bfCb3b.isChecked()) {
                    myList.add("Meal6");
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "Breakfast is important !", Toast.LENGTH_SHORT).show();
        }

        Log.i("TagMyList",myList.toString());


    }
}