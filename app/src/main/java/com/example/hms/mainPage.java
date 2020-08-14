package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageView imageView1 = (ImageView) findViewById(R.id.accomImg);
        ImageView imageView2 = (ImageView) findViewById(R.id.otherfacImg);
        ImageView imageView3 = (ImageView) findViewById(R.id.mealsImg);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                switch (view.getId()){
                    case R.id.mealsImg:
                        intent.setClass(mainPage.this,mealsOptions.class);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        };

        imageView3.setOnClickListener(listener);

    }
}