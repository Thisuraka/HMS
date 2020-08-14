package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class updateMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        ImageView imageView1 = (ImageView) findViewById(R.id.umAdd);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                switch (view.getId()){
                    case R.id.umAdd:
                        intent.setClass(updateMenu.this,addItem.class);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        };

        imageView1.setOnClickListener(listener);



        Button btn = (Button)findViewById(R.id.umBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(updateMenu.this, configDash.class));
            }
        });

    }
}