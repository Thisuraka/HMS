package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hms.classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtBxWelcomeNic, txtBxWelcomeCode;
    Button loginBtn;
    DatabaseReference dbRef;
    User user;

    private void clearControls() {
        txtBxWelcomeNic.setText("");
        txtBxWelcomeCode.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User();
        txtBxWelcomeNic = findViewById(R.id.txtBxWelcomeNic);
        txtBxWelcomeCode = findViewById(R.id.txtBxWelcomeCode);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("User");
                try {
                    if (TextUtils.isEmpty(txtBxWelcomeNic.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter NIC", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txtBxWelcomeCode.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter Code", Toast.LENGTH_SHORT).show();
                    } else if (txtBxWelcomeNic.equals("admin") && txtBxWelcomeCode.equals("1234")) {
                        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, mainPage.class));
                    } else {
                        user.setNic(txtBxWelcomeNic.getText().toString().trim());
                        user.setCode(Integer.parseInt(txtBxWelcomeCode.getText().toString().trim()));

                        dbRef.child("User").setValue(user);

                        Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                        clearControls();
                        startActivity(new Intent(MainActivity.this, mainPage.class));
                    }

                    //temporary. remove later
                    startActivity(new Intent(MainActivity.this, mainPage.class));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}