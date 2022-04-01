package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;


public class Profile extends AppCompatActivity {
    private MaterialButton save1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        save1 = (MaterialButton) findViewById(R.id.save1);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhousepref();
            }


        });
    }
    public void openhousepref() {
        Intent intent1 = new Intent(this, HousePref.class);
        startActivity(intent1);
    }
}