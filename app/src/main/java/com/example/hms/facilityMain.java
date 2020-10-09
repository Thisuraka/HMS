package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class facilityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_main);

        final ImageView imageView1 = (ImageView) findViewById(R.id.fmImg1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.fmImg2);

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                switch (view.getId()){
                    case R.id.fmImg1:
                        intent.setClass(facilityMain.this,new_indoor_view.class);
                        break;
                    case R.id.fmImg2:
                        intent.setClass(facilityMain.this,newOutdoor.class);
                        break;
                    default:
                        break;
                }
                startActivity(intent);

                //goodnight

            }
        };
        imageView1.setOnClickListener(listener);
        imageView2.setOnClickListener(listener);



    }
}