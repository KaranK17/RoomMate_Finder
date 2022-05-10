package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class Profile extends AppCompatActivity {
    private MaterialButton save1;
    private EditText bio, firstname,lastname, date;
    private RadioButton male,female,prof,student;
    private ToggleButton yesno;
    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bio = findViewById(R.id.bio);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        date = findViewById(R.id.Date);
        male= findViewById(R.id.male);
        female= findViewById(R.id.female);
        prof= findViewById(R.id.professional);
        student= findViewById(R.id.student);
        yesno= findViewById(R.id.toggleButton);

        auth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();



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
        Profile.put("firstname",firstname.getText().toString());
        Profile.put("lastname",lastname.getText().toString());
        Profile.put("bio",bio.getText().toString());
        Profile.put("date",date.getText().toString());

        if(male.isSelected()){
            Profile.put("gender","Male");
        }
        else{
            Profile.put("gender","Female");
        }
        if(student.isSelected()){
            Profile.put("profession","Student");
        }
        else{
            Profile.put("profession","Professional");
        }

        if(yesno.isSelected()){
            Profile.put("isfinding","yes");
        }

        db.collection("UserProfile").document(auth.getCurrentUser().getUid()).set(Profile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Profile.this, "Data Added", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Profile.this, HousePref.class);
                    startActivity(intent1);
                }
            }
        });



    }
}