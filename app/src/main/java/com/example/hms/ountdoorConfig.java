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

public class ountdoorConfig extends AppCompatActivity {

    DatabaseReference dbRef;
    Button update, confirm, clear;
    String sessionID, source, test;
    Switch outdoorConfigSwitch1, outdoorConfigSwitch2, outdoorConfigSwitch3, outdoorConfigSwitch4;
    Integer tot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ountdoor_config);

        confirm = findViewById(R.id.outdoorConfigBtn2);
        update = findViewById(R.id.outdoorConfigBtn1);
        clear = findViewById(R.id.outdoorConfigBtn3);

        outdoorConfigSwitch1 = findViewById(R.id.outdoorConfigSwitch1);
        outdoorConfigSwitch2 = findViewById(R.id.outdoorConfigSwitch2);
        outdoorConfigSwitch3 = findViewById(R.id.outdoorConfigSwitch3);
        outdoorConfigSwitch4 = findViewById(R.id.outdoorConfigSwitch4);

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
                            case "Cycling":
                                outdoorConfigSwitch1.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "Golf":
                                outdoorConfigSwitch2.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "Hiking":
                                outdoorConfigSwitch3.setChecked(true);
                                tot = tot + 1;
                                break;
                            case "Playground":
                                outdoorConfigSwitch4.setChecked(true);
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
                startActivity(new Intent(ountdoorConfig.this, mainPage.class));
            }
        });

        //navigates to update function
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), outdoorConfigUpdate.class);
                intent.putExtra("SESSION_ID", sessionID);
                intent.putExtra("SOURCE", source);
                startActivity(intent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), outdoorSuccess.class);
                intent.putExtra("TOT", tot);
                intent.putExtra("SOURCE", source);
                startActivity(intent);
            }
        });
    }
}

