package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class roomReserve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_reserve);

        Button btn1 = (Button)findViewById(R.id.roomrespagebtn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomReserve.this,accomMain.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.roomrespagebtn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomReserve.this, roomreservemiddle.class));
            }
        });
    }
}