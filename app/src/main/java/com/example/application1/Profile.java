package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ToggleButton;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;


public class Profile extends AppCompatActivity {
    private MaterialButton save1;
    private EditText bio, firstname,lastname, date;
    private RadioButton male,female,prof,student;
    private ToggleButton yesno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bio = findViewById(R.id.bio);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        date = findViewById(R.id.editTextDate);
        male= findViewById(R.id.male);
        female= findViewById(R.id.female);
        prof= findViewById(R.id.proffesional);
        student= findViewById(R.id.student);
        yesno= findViewById(R.id.toggleButton);





        save1 = (MaterialButton) findViewById(R.id.save1);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                openhousepref();
            }


        });
    }
    public void openhousepref() {
        HashMap<String,Object> Profile= new HashMap<>();
        Profile.put("firstname",firstname.getText());
        Profile.put("lastname",lastname.getText());
        Profile.put("bio",bio.getText());
        Profile.put("date",date.getText());
        Intent intent1 = new Intent(this, HousePref.class);
        startActivity(intent1);
    }
}