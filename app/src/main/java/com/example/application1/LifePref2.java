package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class LifePref2 extends AppCompatActivity {
    private MaterialButton save4;
    private RadioButton hindi,english,marathi,married,unamarried,yes4,yes5,no4,no5,yes6,no6;
    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_pref2);

        hindi = findViewById(R.id.hindi);
        english = findViewById(R.id.English);
        marathi= findViewById(R.id.Marathi);
        married= findViewById(R.id.Married);
        unamarried = findViewById(R.id.UnMarried);
        no4= findViewById(R.id.no4);
        yes4= findViewById(R.id.yes4);
        no5 = findViewById(R.id.no5);
        yes5 = findViewById(R.id.yes5);
        no6= findViewById(R.id.no6);
        yes6= findViewById(R.id.yes6);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        save4 = (MaterialButton) findViewById(R.id.save4);
        save4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> LifePref2 = new HashMap<>();
                if (english.isSelected()) {
                    LifePref2.put("PrefLang", "English");
                }
                else if(hindi.isSelected()) {
                    LifePref2.put("PrefLang", "Hindi");
                }
                else {
                    LifePref2.put("PrefLang", "Marathi");
                }
                if (married.isSelected()) {
                    LifePref2.put("Status", "Married");
                } else {
                    LifePref2.put("Status", "UnMarried");
                }
                if (yes4.isSelected()) {
                    LifePref2.put("LightsOn", "yes");
                }
                else {
                    LifePref2.put("LightsOn", "no");
                }
                if (yes5.isSelected()) {
                    LifePref2.put("Communicative", "yes");
                }
                else {
                    LifePref2.put("Communicative", "no");
                }
                if (yes6.isSelected()) {
                    LifePref2.put("Cooking", "yes");
                }
                else {
                    LifePref2.put("Cooking", "no");
                }
                db.collection(" LifePref2").document(auth.getCurrentUser().getUid()).set( LifePref2).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LifePref2.this, "Data Added", Toast.LENGTH_SHORT).show();


                        }
                    }
                });


            }


        });



    }
    }
