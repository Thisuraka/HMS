package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class updateMenu extends AppCompatActivity implements View.OnClickListener {

    Integer tot=0;
    Button umBtn;
    DatabaseReference dbRef;
    String strMealList = "";
    String sessionID, source;
    Switch uSwitch1, uSwitch2, uSwitch3, uSwitch4, uSwitch5, uSwitch6;
    ArrayList<String> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        tot = new Integer(0);

        sessionID = getIntent().getStringExtra("SESSION_ID");
        source = getIntent().getStringExtra("SOURCE");

        Log.i("sessionID", sessionID);
        Log.i("source", source);

        umBtn = (Button)findViewById(R.id.umBtn);

        uSwitch1 = findViewById(R.id.uSwitch1);
        uSwitch1.setOnClickListener(this);
        uSwitch2 = findViewById(R.id.uSwitch2);
        uSwitch2.setOnClickListener(this);
        uSwitch3 = findViewById(R.id.uSwitch3);
        uSwitch3.setOnClickListener(this);
        uSwitch4 = findViewById(R.id.uSwitch4);
        uSwitch4.setOnClickListener(this);
        uSwitch5 = findViewById(R.id.uSwitch5);
        uSwitch5.setOnClickListener(this);
        uSwitch6 = findViewById(R.id.uSwitch6);
        uSwitch6.setOnClickListener(this);

        umBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child(source).child(sessionID);
                for (int i = 0; i < myList.size(); i++) {
                    strMealList += myList.get(i) + ",";
                }

                Log.i("Tag", strMealList);

                dbRef.child("Ref").setValue(strMealList);

                Intent intent = new Intent(getBaseContext(), orderSuccess.class);
                intent.putExtra("TOT",tot);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.uSwitch1:
                if (uSwitch1.isChecked()) {
                    myList.add("Item1");
                    tot = tot + 1;
                }
                else if(!(uSwitch1.isChecked())){
                    myList.remove("Item1");
                }
                break;
            case R.id.uSwitch2:
                if (uSwitch2.isChecked()) {
                    myList.add("Item2");
                    tot = tot + 1;
                }
                else if(!(uSwitch2.isChecked())){
                    myList.remove("Item2");
                }
                break;
            case R.id.uSwitch3:
                if (uSwitch3.isChecked()) {
                    myList.add("Item3");
                    tot = tot + 1;
                }
                else if(!(uSwitch3.isChecked())){
                    myList.remove("Item3");
                }
                break;
            case R.id.uSwitch4:
                if (uSwitch4.isChecked()) {
                    myList.add("Item4");
                    tot = tot + 1;
                }
                else if(!(uSwitch4.isChecked())){
                    myList.remove("Item4");
                }
                break;
            case R.id.uSwitch5:
                if (uSwitch5.isChecked()) {
                    myList.add("Item5");
                    tot = tot + 1;
                }
                else if(!(uSwitch5.isChecked())){
                    myList.remove("Item5");
                }
                break;
            case R.id.uSwitch6:
                if (uSwitch6.isChecked()) {
                    myList.add("Item6");
                    tot = tot + 1;
                }
                else if(!(uSwitch6.isChecked())){
                    myList.remove("Item6");
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "Breakfast is important !", Toast.LENGTH_SHORT).show();
        }
        Log.i("TagMyList",myList.toString());
    }
}