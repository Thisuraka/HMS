package com.example.hms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class outdoorConfigUpdate extends AppCompatActivity implements View.OnClickListener {

    Integer tot = 0;
    Button outdoorUpdateBtn;
    DatabaseReference dbRef;
    String outdoorList = "";
    String sessionID, source;
    Switch outdoorUpdateSwitch1, outdoorUpdateSwitch2, outdoorUpdateSwitch3, outdoorUpdateSwitch4;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_config_update);

        tot = new Integer(0);

        sessionID = getIntent().getStringExtra("SESSION_ID");
        source = getIntent().getStringExtra("SOURCE");

        Log.i("sessionID", sessionID);
        Log.i("source", source);

        outdoorUpdateBtn = findViewById(R.id.outdoorUpdateBtn);

        outdoorUpdateSwitch1 = findViewById(R.id.outdoorUpdateSwitch1);
        outdoorUpdateSwitch1.setOnClickListener(this);
        outdoorUpdateSwitch2 = findViewById(R.id.outdoorUpdateSwitch2);
        outdoorUpdateSwitch2.setOnClickListener(this);
        outdoorUpdateSwitch3 = findViewById(R.id.outdoorUpdateSwitch3);
        outdoorUpdateSwitch3.setOnClickListener(this);
        outdoorUpdateSwitch4 = findViewById(R.id.outdoorUpdateSwitch4);
        outdoorUpdateSwitch4.setOnClickListener(this);



        outdoorUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
                for (int i = 0; i < myList.size(); i++) {
                    outdoorList += myList.get(i) + ",";
                }

                Log.i("Tag", outdoorList);

                dbRef.child("Ref").setValue(outdoorList);

                Intent intent = new Intent(getBaseContext(), outdoorSuccess.class);
                intent.putExtra("TOT", tot);
                intent.putExtra("SOURCE", source);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.outdoorUpdateSwitch1:
                if (outdoorUpdateSwitch1.isChecked()) {
                    myList.add("Cycling");
                    tot = tot + 1;
                } else if (!(outdoorUpdateSwitch1.isChecked())) {
                    myList.remove("Cycling");
                }
                break;
            case R.id.outdoorUpdateSwitch2:
                if (outdoorUpdateSwitch2.isChecked()) {
                    myList.add("Golf");
                    tot = tot + 1;
                } else if (!(outdoorUpdateSwitch2.isChecked())) {
                    myList.remove("Golf");
                }
                break;
            case R.id.outdoorUpdateSwitch3:
                if (outdoorUpdateSwitch3.isChecked()) {
                    myList.add("Hiking");
                    tot = tot + 1;
                } else if (!(outdoorUpdateSwitch3.isChecked())) {
                    myList.remove("Hiking");
                }
                break;
            case R.id.outdoorUpdateSwitch4:
                if (outdoorUpdateSwitch4.isChecked()) {
                    myList.add("Playground");
                    tot = tot + 1;
                } else if (!(outdoorUpdateSwitch4.isChecked())) {
                    myList.remove("Playground");
                }
                break;


            default:
        }
        Log.i("TagMyList", myList.toString());
    }
}