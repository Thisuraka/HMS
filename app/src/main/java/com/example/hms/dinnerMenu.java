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

public class dinnerMenu extends AppCompatActivity  implements View.OnClickListener {
    String strMealList = "";
    Button dinnerBtn;
    DatabaseReference dbRef;
    Meals meals;
    CheckBox dinnerCb1, dinnerCb1b, dinnerCb2, dinnerCb2b, dinnerCb3, dinnerCb3b;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_menu);

        meals = new Meals();
        dinnerBtn = (Button) findViewById(R.id.dinnerBtn);

        dinnerCb1 = findViewById(R.id.dinnerCb1);
        dinnerCb1.setOnClickListener(this);
        dinnerCb1b = findViewById(R.id.dinnerCb1b);
        dinnerCb1b.setOnClickListener(this);
        dinnerCb2 = findViewById(R.id.dinnerCb2);
        dinnerCb2.setOnClickListener(this);
        dinnerCb2b = findViewById(R.id.dinnerCb2b);
        dinnerCb2b.setOnClickListener(this);
        dinnerCb3 = findViewById(R.id.dinnerCb3);
        dinnerCb3.setOnClickListener(this);
        dinnerCb3b = findViewById(R.id.dinnerCb3b);
        dinnerCb3b.setOnClickListener(this);


        dinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Dinner").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    strMealList += myList.get(i) + ",";
                }

                Log.i("Ref", strMealList);
                Toast.makeText(getApplicationContext(), strMealList, Toast.LENGTH_SHORT).show();

                dbRef.child("Ref").setValue(strMealList);

                Intent intent = new Intent(getBaseContext(), configDash.class);
                intent.putExtra("SESSION_ID",currentDateTimeString);
                intent.putExtra("SOURCE","Dinner");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dinnerCb1:
                if (dinnerCb1.isChecked()) {
                    myList.add("Item1");
                }
                else if(!(dinnerCb1.isChecked())){
                    myList.remove("Item1");
                }
                break;
            case R.id.dinnerCb1b:
                if (dinnerCb1b.isChecked()) {
                    myList.add("Item2");
                }
                else if(!(dinnerCb1b.isChecked())){
                    myList.remove("Item2");
                }
                break;
            case R.id.dinnerCb2:
                if (dinnerCb2.isChecked()) {
                    myList.add("Item3");
                }
                else if(!(dinnerCb2.isChecked())){
                    myList.remove("Item3");
                }
                break;
            case R.id.dinnerCb2b:
                if (dinnerCb2b.isChecked()) {
                    myList.add("Item4");
                }
                else if(!(dinnerCb2b.isChecked())){
                    myList.remove("Item4");
                }
                break;
            case R.id.dinnerCb3:
                if (dinnerCb3.isChecked()) {
                    myList.add("Item5");
                }
                else if(!(dinnerCb3.isChecked())){
                    myList.remove("Item5");
                }
                break;
            case R.id.dinnerCb3b:
                if (dinnerCb3b.isChecked()) {
                    myList.add("Item6");
                }
                else if(!(dinnerCb3b.isChecked())){
                    myList.remove("Item6");
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "No dinner tonight?", Toast.LENGTH_SHORT).show();
        }

        Log.i("TagMyList",myList.toString());

    }
}