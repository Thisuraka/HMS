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
    Button bfBtn;
    DatabaseReference dbRef;
    Meals meals;
    CheckBox bfCb1, bfCb1b, bfCb2, bfCb2b, bfCb3, bfCb3b;
    ArrayList<String> myList = new ArrayList<String>();
    private Object Tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_menu);

        meals = new Meals();
        bfBtn = (Button) findViewById(R.id.bfBtn);

        bfCb1 = (CheckBox) findViewById(R.id.bfCb1);
        bfCb1.setOnClickListener((View.OnClickListener) this);
        bfCb1b = (CheckBox) findViewById(R.id.bfCb1b);
        bfCb1b.setOnClickListener((View.OnClickListener) this);
        bfCb2 = (CheckBox) findViewById(R.id.bfCb2);
        bfCb2.setOnClickListener((View.OnClickListener) this);
        bfCb2b = (CheckBox) findViewById(R.id.bfCb2b);
        bfCb2b.setOnClickListener((View.OnClickListener) this);
        bfCb3 = (CheckBox) findViewById(R.id.bfCb3);
        bfCb3.setOnClickListener((View.OnClickListener) this);
        bfCb3b = (CheckBox) findViewById(R.id.bfCb3b);
        bfCb3b.setOnClickListener((View.OnClickListener) this);


        
    }



    @Override
    public void onClick(View view) {
        dbRef = FirebaseDatabase.getInstance().getReference().child("Breakfast");

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
                Toast.makeText(getApplicationContext(), "Breakfast is important !", Toast.LENGTH_SHORT).show();
        }

        Log.i((String) Tag, String.valueOf(myList));

        String strMealList = "";

        for (int i = 0; i < myList.size(); i++) {
            strMealList += myList.get(i) + ",";
        }
        Log.i((String) Tag, "Heeeeeerrreeeeeeeeeeeeeeeeee");
        Log.i((String) Tag, strMealList);

        dbRef.child("Breakfast").setValue(strMealList);

        Toast.makeText(getApplicationContext(), strMealList, Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(breakfastMenu.this, configDash.class));

    }


}