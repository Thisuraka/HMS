package com.example.hms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class configDash extends AppCompatActivity {

    Button update, confirm;
    String sessionID, source, test;
    Switch switch1, switch2, switch3, switch4, switch5, switch6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_dash);

        confirm = (Button)findViewById(R.id.confDashBtn2);
        update = (Button)findViewById(R.id.confDashBtn1);

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch4 = findViewById(R.id.switch4);
        switch5 = findViewById(R.id.switch5);
        switch6 = findViewById(R.id.switch6);

        sessionID = getIntent().getStringExtra("SESSION_ID");
        source = getIntent().getStringExtra("SOURCE");
        Log.i("sessionID", sessionID);
        Log.i("source", source);

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    test = dataSnapshot.child("Ref").getValue().toString();
                    String str[] = test.split(",");
                    List<String> al = new ArrayList<String>();
                    al = Arrays.asList(str);

                    Log.i("al", String.valueOf(al));

                    for(int i=0; i<al.size(); i++ ){
//                        System.out.println(al.get(i));
                        String b = al.get(i);
                        switch(b){
                            case "Item1":
                                switch1.setChecked(true);
                                break;
                            case "Item2":
                                switch2.setChecked(true);
                                break;
                            case "Item3":
                                switch3.setChecked(true);
                                break;
                            case "Item4":
                                switch4.setChecked(true);
                                break;
                            case "Item5":
                                switch5.setChecked(true);
                                break;
                        }
                    }

 //                   Toast.makeText(getApplicationContext(), "yeps", Toast.LENGTH_SHORT).show();
                }
                else{
//                    Toast.makeText(getApplicationContext(), "bummer", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(configDash.this, updateMenu.class));
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(configDash.this, success.class));
            }
        });
    }
}