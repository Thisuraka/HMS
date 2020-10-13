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

import com.example.hms.classes.Rooms;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class newChooseRoom extends AppCompatActivity implements View.OnClickListener {

    String roomList = "";
    Button ReserveBtn;
    DatabaseReference dbRef;
    Rooms Rooms;
    CheckBox chooseRoomCb1, chooseRoomCb2, chooseRoomCb3, chooseRoomCb4;
    ArrayList<String> myList = new ArrayList<>();
    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_choose_room);

        Rooms = new Rooms();
        ReserveBtn = findViewById(R.id.ReserveBtn);

        chooseRoomCb1 = findViewById(R.id.chooseRoomCb1);
        chooseRoomCb1.setOnClickListener(this);
        chooseRoomCb2 = findViewById(R.id.chooseRoomCb2);
        chooseRoomCb2.setOnClickListener(this);
        chooseRoomCb3 = findViewById(R.id.chooseRoomCb3);
        chooseRoomCb3.setOnClickListener(this);
        chooseRoomCb4 = findViewById(R.id.chooseRoomCb4);
        chooseRoomCb4.setOnClickListener(this);


        ReserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Rooms").child(currentDateTimeString);
                for (int i = 0; i < myList.size(); i++) {
                    roomList += myList.get(i) + ",";
                } //set the data to a string with "," as a split point and sent to DB

                Log.i("Tag", roomList);

                dbRef.child("Ref").setValue(roomList);

                Log.i("sessionID", currentDateTimeString);

                Intent intent = new Intent(getBaseContext(), roomConfig.class);
                intent.putExtra("SESSION_ID", currentDateTimeString);
                intent.putExtra("SOURCE", "Rooms");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chooseRoomCb1:
                if (chooseRoomCb1.isChecked()) {
                    myList.add("Room1");
                } else if (!(chooseRoomCb1.isChecked())) {
                    myList.remove("Room1");
                }
                break;
            case R.id.chooseRoomCb2:
                if (chooseRoomCb2.isChecked()) {
                    myList.add("Room2");
                } else if (!(chooseRoomCb2.isChecked())) {
                    myList.remove("Room2");
                }
                break;
            case R.id.chooseRoomCb3:
                if (chooseRoomCb3.isChecked()) {
                    myList.add("Room3");
                } else if (!(chooseRoomCb3.isChecked())) {
                    myList.remove("Room3");
                }
                break;
            case R.id.chooseRoomCb4:
                if (chooseRoomCb4.isChecked()) {
                    myList.add("Room4");
                } else if (!(chooseRoomCb4.isChecked())) {
                    myList.remove("Room4");
                }
                break;

            default:
//
        }
        Log.i("TagMyList", myList.toString());
    }
}