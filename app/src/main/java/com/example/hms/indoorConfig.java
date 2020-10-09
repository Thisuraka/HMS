package com.example.hms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class indoorConfig extends AppCompatActivity {
    DatabaseReference dbRef;
    Button update, confirm, clear;
    String sessionID, source, test;
    Switch indoorSwitch1, indoorSwitch2, indoorSwitch3, indoorSwitch4, indoorSwitch5;
    Integer tot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_config);

        confirm = findViewById(R.id.configBtn2);
        update = findViewById(R.id.configBtn1);
        clear = findViewById(R.id.configBtn3);

        indoorSwitch1 = findViewById(R.id.indoorSwitch1);
        indoorSwitch2 = findViewById(R.id.indoorSwitch2);
        indoorSwitch3 = findViewById(R.id.indoorSwitch3);
        indoorSwitch4 = findViewById(R.id.indoorSwitch4);
        indoorSwitch5 = findViewById(R.id.indoorSwitch5);

        sessionID = getIntent().getStringExtra("SESSION_ID");
        source = getIntent().getStringExtra("SOURCE");
        Log.i("sessionID", sessionID);
        Log.i("source", source);

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    test = Objects.requireNonNull(dataSnapshot.child("Ref").getValue()).toString();
                    String[] str = test.split(",");
                    List<String> al;
                    al = Arrays.asList(str);

                    Log.i("al", String.valueOf(al));

                    for (int i = 0; i < al.size(); i++) {
//                        System.out.println(al.get(i));
                        String b = al.get(i);
                        switch (b) {
                            case "SwimmingPool":
                                indoorSwitch1.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "VideoGameRoom":
                                indoorSwitch2.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "GameRoom":
                                indoorSwitch3.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "Gym":
                                indoorSwitch4.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "Spa":
                                indoorSwitch5.setChecked(true);
                                tot = tot + 1;
                                break;

                        }
                    }
                    Toast.makeText(getApplicationContext(), "Please Confirm", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //acts as the delete function
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
                dbRef.removeValue();
                startActivity(new Intent(indoorConfig.this, mainPage.class));
            }
        });

        //navigates to update function
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), indoorConfigUpdate.class);
                intent.putExtra("SESSION_ID", sessionID);
                intent.putExtra("SOURCE", source);
                startActivity(intent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), indoorSuccess.class);
                intent.putExtra("TOT", tot);
                intent.putExtra("SOURCE", source);
                startActivity(intent);
            }
        });
    }
}
