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

public class barMenu extends AppCompatActivity implements View.OnClickListener{
    String strMealList = "";
    Button barBtn;
    DatabaseReference dbRef;
    Meals meals;
    CheckBox barCb1, barCb1b, barCb2, barCb2b, barCb3, barCb3b;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_menu);

        meals = new Meals();
        barBtn = (Button)findViewById(R.id.barBtn);

        barCb1 = findViewById(R.id.barCb1);
        barCb1.setOnClickListener(this);
        barCb1b = findViewById(R.id.barCb1b);
        barCb1b.setOnClickListener(this);
        barCb2 = findViewById(R.id.barCb2);
        barCb2.setOnClickListener(this);
        barCb2b = findViewById(R.id.barCb2b);
        barCb2b.setOnClickListener(this);
        barCb3 = findViewById(R.id.barCb3);
        barCb3.setOnClickListener(this);
        barCb3b = findViewById(R.id.barCb3b);
        barCb3b.setOnClickListener(this);

        barBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("Bar").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    strMealList += myList.get(i) + ",";
                }

                Log.i("Ref", strMealList);
                Toast.makeText(getApplicationContext(), strMealList, Toast.LENGTH_SHORT).show();

                dbRef.child("Ref").setValue(strMealList);

                Intent intent = new Intent(getBaseContext(), configDash.class);
                intent.putExtra("SESSION_ID",currentDateTimeString);
                intent.putExtra("SOURCE","Bar");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.barCb1:
                if (barCb1.isChecked()) {
                    myList.add("Item1");
                }
                else if(!(barCb1.isChecked())){
                    myList.remove("Item1");
                }
                break;
            case R.id.barCb1b:
                if (barCb1b.isChecked()) {
                    myList.add("Item2");
                }
                else if(!(barCb1b.isChecked())){
                    myList.remove("Item2");
                }
                break;
            case R.id.barCb2:
                if (barCb2.isChecked()) {
                    myList.add("Item3");
                }
                else if(!(barCb2.isChecked())){
                    myList.remove("Item3");
                }
                break;
            case R.id.barCb2b:
                if (barCb2b.isChecked()) {
                    myList.add("Item4");
                }
                else if(!(barCb2b.isChecked())){
                    myList.remove("Item4");
                }
                break;
            case R.id.barCb3:
                if (barCb3.isChecked()) {
                    myList.add("Item5");
                }
                else if(!(barCb3.isChecked())){
                    myList.remove("Item5");
                }
                break;
            case R.id.barCb3b:
                if (barCb3b.isChecked()) {
                    myList.add("Item6");
                }
                else if(!(barCb3b.isChecked())){
                    myList.remove("Item6");
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "That is fine", Toast.LENGTH_SHORT).show();
        }
        Log.i("TagMyList",myList.toString());
    }
}