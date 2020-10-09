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
import com.example.hms.classes.outdoorFacilities;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class newOutdoor extends AppCompatActivity implements View.OnClickListener {

    String outdoorFacilityList = "";
    Button newOutdoorBtn;
    DatabaseReference dbRef;
    outdoorFacilities outdoorFacilities;
    CheckBox outdoorcb1, outdoorcb2, outdoorcb3, outdoorcb4;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_outdoor);

        outdoorFacilities = new outdoorFacilities();
        newOutdoorBtn = findViewById(R.id.newOutdoorBtn);

        outdoorcb1 = findViewById(R.id.outdoorcb1);
        outdoorcb1.setOnClickListener(this);
        outdoorcb2 = findViewById(R.id.outdoorcb2);
        outdoorcb2.setOnClickListener(this);
        outdoorcb3 = findViewById(R.id.outdoorcb3);
        outdoorcb3.setOnClickListener(this);
        outdoorcb4 = findViewById(R.id.outdoorcb4);
        outdoorcb4.setOnClickListener(this);

        newOutdoorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("outdoorFacilities").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    outdoorFacilityList += myList.get(i) + ",";
                } //set the data to a string with "," as a split point and sent to DB

                Log.i("Tag", outdoorFacilityList);

                dbRef.child("Ref").setValue(outdoorFacilityList);

                Log.i("sessionID", currentDateTimeString);

                Intent intent = new Intent(getBaseContext(), ountdoorConfig.class);
                intent.putExtra("SESSION_ID", currentDateTimeString);
                intent.putExtra("SOURCE", "outdoorFacilities");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.outdoorcb1:
                if (outdoorcb1.isChecked()) {
                    myList.add("Cycling");
                } else if (!(outdoorcb1.isChecked())) {
                    myList.remove("Cycling");
                }
                break;
            case R.id.outdoorcb2:
                if (outdoorcb2.isChecked()) {
                    myList.add("Golf");
                } else if (!(outdoorcb2.isChecked())) {
                    myList.remove("Golf");
                }
                break;
            case R.id.outdoorcb3:
                if (outdoorcb3.isChecked()) {
                    myList.add("Hiking");
                } else if (!(outdoorcb3.isChecked())) {
                    myList.remove("Hiking");
                }
                break;
            case R.id.outdoorcb4:
                if (outdoorcb4.isChecked()) {
                    myList.add("Playground");
                } else if (!(outdoorcb4.isChecked())) {
                    myList.remove("Playground");
                }
                break;

            default:
//
        }
        Log.i("TagMyList", myList.toString());
    }
}