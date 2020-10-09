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

import com.example.hms.classes.indoorFacilities;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class new_indoor_view extends AppCompatActivity implements View.OnClickListener {
    String indoorFacilityList = "";
    Button newIndBtn;
    DatabaseReference dbRef;
    indoorFacilities indoorFacilities;
    CheckBox indoorcb1, indoorcb2, indoorcb3, indoorcb4, indoorcb5;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_indoor_view);

        indoorFacilities = new indoorFacilities();
        newIndBtn = findViewById(R.id.newIndBtn);

        indoorcb1 = findViewById(R.id.indoorcb1);
        indoorcb1.setOnClickListener(this);
        indoorcb2 = findViewById(R.id.indoorcb2);
        indoorcb2.setOnClickListener(this);
        indoorcb3 = findViewById(R.id.indoorcb3);
        indoorcb3.setOnClickListener(this);
        indoorcb4 = findViewById(R.id.indoorcb4);
        indoorcb4.setOnClickListener(this);
        indoorcb5 = findViewById(R.id.indoorcb5);
        indoorcb5.setOnClickListener(this);

        newIndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("IndoorFacilities").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    indoorFacilityList += myList.get(i) + ",";
                } //set the data to a string with "," as a split point and sent to DB

                Log.i("Tag", indoorFacilityList);

                dbRef.child("Ref").setValue(indoorFacilityList);

                Log.i("sessionID", currentDateTimeString);

                Intent intent = new Intent(getBaseContext(), indoorConfig.class);
                intent.putExtra("SESSION_ID", currentDateTimeString);
                intent.putExtra("SOURCE", "IndoorFacilities");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.indoorcb1:
                if (indoorcb1.isChecked()) {
                    myList.add("SwimmingPool");
                } else if (!(indoorcb1.isChecked())) {
                    myList.remove("SwimmingPool");
                }
                break;
            case R.id.indoorcb2:
                if (indoorcb2.isChecked()) {
                    myList.add("VideoGameRoom");
                } else if (!(indoorcb2.isChecked())) {
                    myList.remove("VideoGameRoom");
                }
                break;
            case R.id.indoorcb3:
                if (indoorcb3.isChecked()) {
                    myList.add("GameRoom");
                } else if (!(indoorcb3.isChecked())) {
                    myList.remove("GameRoom");
                }
                break;
            case R.id.indoorcb4:
                if (indoorcb4.isChecked()) {
                    myList.add("Gym");
                } else if (!(indoorcb4.isChecked())) {
                    myList.remove("Gym");
                }
                break;
            case R.id.indoorcb5:
                if (indoorcb5.isChecked()) {
                    myList.add("Spa");
                } else if (!(indoorcb5.isChecked())) {
                    myList.remove("Spa");
                }
                break;
            default:
//
        }
        Log.i("TagMyList", myList.toString());
    }
}