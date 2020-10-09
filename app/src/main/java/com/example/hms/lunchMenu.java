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

public class lunchMenu extends AppCompatActivity implements View.OnClickListener {
    String strMealList = "";
    Button lunchBtn;
    DatabaseReference dbRef;
    Meals meals;
    CheckBox lunchCb1, lunchCb1b, lunchCb2, lunchCb2b, lunchCb3, lunchCb3b;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    /*    Disclaimer
    date and time system is used to uniquely identify an instance, in case an overlap happens it would be handled
    by a merge which would not affect the system in any way
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_menu);

        meals = new Meals();
        lunchBtn = findViewById(R.id.lunchBtn);

        lunchCb1 = findViewById(R.id.lunchCb1);
        lunchCb1.setOnClickListener(this);
        lunchCb1b = findViewById(R.id.lunchCb1b);
        lunchCb1b.setOnClickListener(this);
        lunchCb2 = findViewById(R.id.lunchCb2);
        lunchCb2.setOnClickListener(this);
        lunchCb2b = findViewById(R.id.lunchCb2b);
        lunchCb2b.setOnClickListener(this);
        lunchCb3 = findViewById(R.id.lunchCb3);
        lunchCb3.setOnClickListener(this);
        lunchCb3b = findViewById(R.id.lunchCb3b);
        lunchCb3b.setOnClickListener(this);

        lunchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Lunch").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    strMealList += myList.get(i) + ",";
                }

                Log.i("Tag", strMealList);
                Toast.makeText(getApplicationContext(), strMealList, Toast.LENGTH_SHORT).show();

                dbRef.child("Ref").setValue(strMealList);

                Intent intent = new Intent(getBaseContext(), configDash.class);
                intent.putExtra("SESSION_ID", currentDateTimeString);
                intent.putExtra("SOURCE", "Lunch");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lunchCb1:
                if (lunchCb1.isChecked()) {
                    myList.add("Item1");
                } else if (!(lunchCb1.isChecked())) {
                    myList.remove("Item1");
                }
                break;
            case R.id.lunchCb1b:
                if (lunchCb1b.isChecked()) {
                    myList.add("Item2");
                } else if (!(lunchCb1b.isChecked())) {
                    myList.remove("Item2");
                }
                break;
            case R.id.lunchCb2:
                if (lunchCb2.isChecked()) {
                    myList.add("Item3");
                } else if (!(lunchCb2.isChecked())) {
                    myList.remove("Item3");
                }
                break;
            case R.id.lunchCb2b:
                if (lunchCb2b.isChecked()) {
                    myList.add("Item4");
                } else if (!(lunchCb2b.isChecked())) {
                    myList.remove("Item4");
                }
                break;
            case R.id.lunchCb3:
                if (lunchCb3.isChecked()) {
                    myList.add("Item5");
                } else if (!(lunchCb3.isChecked())) {
                    myList.remove("Item5");
                }
                break;
            case R.id.lunchCb3b:
                if (lunchCb3b.isChecked()) {
                    myList.add("Item6");
                } else if (!(lunchCb3b.isChecked())) {
                    myList.remove("Item6");
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "Lunch is important !", Toast.LENGTH_SHORT).show();
        }
        Log.i("TagMyList", myList.toString());
    }
}