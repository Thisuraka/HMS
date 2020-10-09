package com.example.hms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class indoorConfigUpdate extends AppCompatActivity implements View.OnClickListener {

    Integer tot = 0;
    Button updateBtn;
    DatabaseReference dbRef;
    String indoorList = "";
    String sessionID, source;
    Switch updateSwitch1, updateSwitch2, updateSwitch3, updateSwitch4, updateSwitch5;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_config_update);

        tot = new Integer(0);

        sessionID = getIntent().getStringExtra("SESSION_ID");
        source = getIntent().getStringExtra("SOURCE");

        Log.i("sessionID", sessionID);
        Log.i("source", source);

        updateBtn = findViewById(R.id.updateBtn);

        updateSwitch1 = findViewById(R.id.updateSwitch1);
        updateSwitch1.setOnClickListener(this);
        updateSwitch2 = findViewById(R.id.updateSwitch2);
        updateSwitch2.setOnClickListener(this);
        updateSwitch3 = findViewById(R.id.updateSwitch3);
        updateSwitch3.setOnClickListener(this);
        updateSwitch4 = findViewById(R.id.updateSwitch4);
        updateSwitch4.setOnClickListener(this);
        updateSwitch5 = findViewById(R.id.updateSwitch5);
        updateSwitch5.setOnClickListener(this);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
                for (int i = 0; i < myList.size(); i++) {
                    indoorList += myList.get(i) + ",";
                }

                Log.i("Tag", indoorList);

                dbRef.child("Ref").setValue(indoorList);

                Intent intent = new Intent(getBaseContext(), indoorSuccess.class);
                intent.putExtra("TOT", tot);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.updateSwitch1:
                if (updateSwitch1.isChecked()) {
                    myList.add("SwimmingPool");
                    tot = tot + 1;
                } else if (!(updateSwitch1.isChecked())) {
                    myList.remove("SwimmingPool");
                }
                break;
            case R.id.updateSwitch2:
                if (updateSwitch2.isChecked()) {
                    myList.add("VideoGameRoom");
                    tot = tot + 1;
                } else if (!(updateSwitch2.isChecked())) {
                    myList.remove("VideoGameRoom");
                }
                break;
            case R.id.updateSwitch3:
                if (updateSwitch3.isChecked()) {
                    myList.add("GameRoom");
                    tot = tot + 1;
                } else if (!(updateSwitch3.isChecked())) {
                    myList.remove("GameRoom");
                }
                break;
            case R.id.updateSwitch4:
                if (updateSwitch4.isChecked()) {
                    myList.add("Gym");
                    tot = tot + 1;
                } else if (!(updateSwitch4.isChecked())) {
                    myList.remove("Gym");
                }
                break;
            case R.id.updateSwitch5:
                if (updateSwitch5.isChecked()) {
                    myList.add("Spa");
                    tot = tot + 1;
                } else if (!(updateSwitch5.isChecked())) {
                    myList.remove("Spa");
                }
                break;

            default:
        }
        Log.i("TagMyList", myList.toString());
    }
}