package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity {
    private MaterialButton Login0;
    private MaterialButton Register0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Register0 = (MaterialButton) findViewById(R.id.Register0);
        Register0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();
            }


        });
        Login0 = (MaterialButton) findViewById(R.id.Login0);
        Login0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignin();
            }
        });
    }
    public void opensignup() {
        Intent intent1 = new Intent(this, signup.class);
        startActivity(intent1);
    }
    public void opensignin() {
        Intent intent2 = new Intent(this, signin.class);
        startActivity(intent2);
    }
}