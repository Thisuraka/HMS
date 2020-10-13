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

public class roomUpdate extends AppCompatActivity implements View.OnClickListener{

    Integer tot = 0;
    Button roomUpbtn1;
    DatabaseReference dbRef;
    String roomList = "";
    String sessionID, source;
    Switch roomUpS1, roomUpS2, roomUpS3, roomUpS4;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_update);


        tot = new Integer(0);

        sessionID = getIntent().getStringExtra("SESSION_ID");
        source = getIntent().getStringExtra("SOURCE");

        Log.i("sessionID", sessionID);
        Log.i("source", source);

        roomUpbtn1 = findViewById(R.id.roomUpbtn1);

        roomUpS1 = findViewById(R.id.roomUpS1);
        roomUpS1.setOnClickListener(this);
        roomUpS2 = findViewById(R.id.roomUpS2);
        roomUpS2.setOnClickListener(this);
        roomUpS3 = findViewById(R.id.roomUpS3);
        roomUpS3.setOnClickListener(this);
        roomUpS4 = findViewById(R.id.roomUpS4);
        roomUpS4.setOnClickListener(this);



        roomUpbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
                for (int i = 0; i < myList.size(); i++) {
                    roomList += myList.get(i) + ",";
                }

                Log.i("Tag", roomList);

                dbRef.child("Ref").setValue(roomList);

                Intent intent = new Intent(getBaseContext(), roomSuccess.class);
                intent.putExtra("TOT", tot);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.roomUpS1:
                if (roomUpS1.isChecked()) {
                    myList.add("Room1");
                    tot = tot + 1;
                } else if (!(roomUpS1.isChecked())) {
                    myList.remove("Room1");
                }
                break;
            case R.id.roomUpS2:
                if (roomUpS2.isChecked()) {
                    myList.add("Room2");
                    tot = tot + 1;
                } else if (!(roomUpS2.isChecked())) {
                    myList.remove("Room2");
                }
                break;
            case R.id.roomUpS3:
                if (roomUpS3.isChecked()) {
                    myList.add("Room3");
                    tot = tot + 1;
                } else if (!(roomUpS3.isChecked())) {
                    myList.remove("Room3");
                }
                break;
            case R.id.roomUpS4:
                if (roomUpS4.isChecked()) {
                    myList.add("Room4");
                    tot = tot + 1;
                } else if (!(roomUpS4.isChecked())) {
                    myList.remove("Room4");
                }
                break;


            default:
        }
        Log.i("TagMyList", myList.toString());
    }
}