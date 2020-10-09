package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;;

public class indoorSuccess extends AppCompatActivity {

    Button indoorSucBtn;
    TextView newSucTxt3;
    Integer tot;
    String source;

    final int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor_success);

        tot = new Integer(0);

        newSucTxt3 = findViewById(R.id.newSucTxt3);
        source = getIntent().getStringExtra("SOURCE");
        tot = getIntent().getIntExtra("TOT", tot);

        indoorSucBtn = findViewById(R.id.indoorSucBtn);

        if (currentHour >= 21 && currentHour <= 22 && source.equals("Video Game Room")) {
            tot = tot * 750;
            if (tot > 2250) {
                Toast.makeText(getApplicationContext(), "Eligible for a discount.", Toast.LENGTH_LONG).show();
            }
        } else if (currentHour >= 16 && currentHour <= 18 && source.equals("Game Room")) {
            tot = tot * 750 - 200;
            Toast.makeText(getApplicationContext(), "Eligible for a discount", Toast.LENGTH_LONG).show();
            newSucTxt3.setText("Your Total for current facility cost is :  " + tot + ". " + "You have received a discount");
        } else {
            tot = tot * 750;
            Log.i("tot", String.valueOf(tot));
            newSucTxt3.setText("Your Total for current facility cost is :  " + tot);
        }

        //button to navigate back to main
        indoorSucBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(indoorSuccess.this, mainPage.class));
            }
        });

    }

}