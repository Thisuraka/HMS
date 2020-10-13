package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class roomreserve4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomreserve4);

        Button btn1 = (Button)findViewById(R.id.roomrespage4btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  roomreserve4.this,roomreservemiddle.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.roomrespage4btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  roomreserve4.this, newChooseRoom.class));
            }
        });
    }
}