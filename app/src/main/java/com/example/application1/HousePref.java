package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class HousePref extends AppCompatActivity {
    private MaterialButton save2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_pref);

        save2 = (MaterialButton) findViewById(R.id.save2);
        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlifestylepref();
            }


        });
    }
    public void openlifestylepref() {
        Intent intent1 = new Intent(this, LifeStyle.class);
        startActivity(intent1);
    }
}