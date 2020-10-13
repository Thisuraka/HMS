package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class roomreservemiddle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomreservemiddle);

        Button btn1 = (Button)findViewById(R.id.roomrespage3btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( roomreservemiddle.this,roomReserve.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.roomrespage3btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( roomreservemiddle.this, roomreserve4.class));
            }
        });
    }
}