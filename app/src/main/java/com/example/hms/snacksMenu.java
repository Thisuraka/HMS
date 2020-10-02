package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.Date;

public class snacksMenu extends AppCompatActivity implements View.OnClickListener {
    String strMealList = "";
    Button snacksBtn;
    DatabaseReference dbRef;
    Meals meals;
    CheckBox snacksCb1, snacksCb1b, snacksCb2, snacksCb2b, snacksCb3, snacksCb3b;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_menu);

        meals = new Meals();
        snacksBtn = findViewById(R.id.snacksBtn);

        snacksCb1 = findViewById(R.id.snacksCb1);
        snacksCb1.setOnClickListener(this);
        snacksCb1b = findViewById(R.id.snacksCb1b);
        snacksCb1b.setOnClickListener(this);
        snacksCb2 = findViewById(R.id.snacksCb2);
        snacksCb2.setOnClickListener(this);
        snacksCb2b = findViewById(R.id.snacksCb2b);
        snacksCb2b.setOnClickListener(this);
        snacksCb3 = findViewById(R.id.snacksCb3);
        snacksCb3.setOnClickListener(this);
        snacksCb3b = findViewById(R.id.snacksCb3b);
        snacksCb3b.setOnClickListener(this);



        snacksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Snacks").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    strMealList += myList.get(i) + ",";
                }

                Log.i("Ref", strMealList);
                Toast.makeText(getApplicationContext(), strMealList, Toast.LENGTH_SHORT).show();

                dbRef.child("Ref").setValue(strMealList);

                Intent intent = new Intent(getBaseContext(), configDash.class);
                intent.putExtra("SESSION_ID",currentDateTimeString);
                intent.putExtra("SOURCE","Snacks");
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.snacksCb1:
                if (snacksCb1.isChecked()) {
                    myList.add("Snack1");
                }
                else if(!(snacksCb1.isChecked())){
                    myList.remove("Snack1");
                }
                break;
            case R.id.snacksCb1b:
                if (snacksCb1b.isChecked()) {
                    myList.add("Snack2");
                }
                else if(!(snacksCb1b.isChecked())){
                    myList.remove("Snack2");
                }
                break;
            case R.id.snacksCb2:
                if (snacksCb2.isChecked()) {
                    myList.add("Snack3");
                }
                else if(!(snacksCb2.isChecked())){
                    myList.remove("Snack3");
                }
                break;
            case R.id.snacksCb2b:
                if (snacksCb2b.isChecked()) {
                    myList.add("Snack4");
                }
                else if(!(snacksCb2b.isChecked())){
                    myList.remove("Snack4");
                }
                break;
            case R.id.snacksCb3:
                if (snacksCb3.isChecked()) {
                    myList.add("Snack5");
                }
                else if(!(snacksCb3.isChecked())){
                    myList.remove("Snack5");
                }
                break;
            case R.id.snacksCb3b:
                if (snacksCb3b.isChecked()) {
                    myList.add("Snack6");
                }
                else if(!(snacksCb3b.isChecked())){
                    myList.remove("Snack6");
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "Snack time !", Toast.LENGTH_SHORT).show();
        }

        Log.i("TagMyList",myList.toString());
    }
}