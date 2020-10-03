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

public class orderSuccess extends AppCompatActivity {

    Button done;
    TextView suc2;
    Integer tot;
    String source;

    final int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        tot = new Integer(0);

        suc2 = findViewById(R.id.suc2);
        source = getIntent().getStringExtra("SOURCE");
        tot = getIntent().getIntExtra("TOT", tot);

        done = (Button) findViewById(R.id.sucBtn);

        if (currentHour >= 21 && currentHour <= 22 && source == "Bar") {
            tot = tot * 750;
            if (tot > 2250){
                Toast.makeText(getApplicationContext(), "Eligible for a discount. Contact Bar staff", Toast.LENGTH_LONG).show();
            }
        }
        else if (currentHour >= 16 && currentHour <= 18 && source == "Snacks"){
            tot = tot * 750 - 200;
            Toast.makeText(getApplicationContext(), "Eligible for a discount", Toast.LENGTH_LONG).show();
            suc2.setText("Your Total for current order is :  " + tot + ". " + "You have received a discount");
        }
        else{
            tot = tot * 750;
            Log.i("tot", String.valueOf(tot));
            suc2.setText("Your Total for current order is :  " + tot);
        }




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(orderSuccess.this, mainPage.class));
            }
        });

    }

}