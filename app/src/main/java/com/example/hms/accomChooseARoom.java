package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class accomChooseARoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accom_choose_a_room);

        Button btn1 = (Button)findViewById(R.id.ambutton3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(accomChooseARoom.this, roomReserve.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.ambutton4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(accomChooseARoom.this, roomReserve.class));
            }
        });

         Button btn3 = (Button)findViewById(R.id.ambutton5);

         btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(accomChooseARoom.this, roomReserve.class));
            }
        });
    }
}