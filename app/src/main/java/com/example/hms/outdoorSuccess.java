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

public class outdoorSuccess extends AppCompatActivity {

    Button outScuBtn;
    TextView outdoorSucTxt3;
    Integer tot;
    String source;

    final int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_success);
        tot = new Integer(0);

        outdoorSucTxt3 = findViewById(R.id.outdoorSucTxt3);
        source = getIntent().getStringExtra("SOURCE");
        tot = getIntent().getIntExtra("TOT", tot);

        outScuBtn = findViewById(R.id.outScuBtn);

        if (currentHour >= 12 && currentHour <= 18 && source.equals("Playground")) {
            tot = tot * 750;
            if (tot > 2250) {
                Toast.makeText(getApplicationContext(), "Eligible for a discount.", Toast.LENGTH_LONG).show();
            }
        } else if (currentHour >= 8 && currentHour <= 12 && source.equals("Hiking")) {
            tot = tot * 750 - 200;
            Toast.makeText(getApplicationContext(), "Eligible for a discount", Toast.LENGTH_LONG).show();
            outdoorSucTxt3.setText("Your Total for current facility cost is :  " + tot + ". " + "You have received a discount");
        } else {
            tot = tot * 750;
            Log.i("tot", String.valueOf(tot));
            outdoorSucTxt3.setText("Your Total for current facility cost is :  " + tot);
        }

        //button to navigate back to main
        outScuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(outdoorSuccess.this, mainPage.class));
            }
        });

    }

}