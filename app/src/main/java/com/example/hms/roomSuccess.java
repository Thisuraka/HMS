package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class roomSuccess extends AppCompatActivity {

    Button roomDonebtn;
    TextView roomTotMsg;
    Integer tot;
    String source;

    final int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_success);

        tot = new Integer(0);

        roomTotMsg = findViewById(R.id.roomTotMsg);
        source = getIntent().getStringExtra("SOURCE");
        tot = getIntent().getIntExtra("TOT", tot);

        roomDonebtn = findViewById(R.id.roomDonebtn);

        if (currentHour >= 21 && currentHour <= 22 && source.equals("Room1")) {
            tot = tot * 25000;
            if (tot > 50000) {
                Toast.makeText(getApplicationContext(), "Eligible for a discount.", Toast.LENGTH_LONG).show();
            }
        } else if (currentHour >= 16 && currentHour <= 18 && source.equals("Room2")) {
            tot = tot * 25000 - 5000;
            Toast.makeText(getApplicationContext(), "Eligible for a discount", Toast.LENGTH_LONG).show();
            roomTotMsg.setText("Your Total for current Room Reservation cost is :  " + tot + ". " + "You have received a discount");
        } else {
            tot = tot * 25000;
            Log.i("tot", String.valueOf(tot));
            roomTotMsg.setText("Your Total for current facility cost is :  " + tot);
        }

        //button to navigate back to main
        roomDonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomSuccess.this, mainPage.class));
            }
        });

    }

}