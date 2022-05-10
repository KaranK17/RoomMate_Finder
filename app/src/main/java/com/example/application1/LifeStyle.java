package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class LifeStyle extends AppCompatActivity {
    private MaterialButton save3;
    private RadioButton veg,nonveg,yes0,no0,yes1,no1,occasional1,yes2,no2,occasional2,yes3,no3;
    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_style);

        veg = findViewById(R.id.veg);
        nonveg = findViewById(R.id.nonveg);
        yes0= findViewById(R.id.yes0);
        no0 = findViewById(R.id.no0);
        yes1 = findViewById(R.id.yes1);
        no1= findViewById(R.id.no1);
        yes2= findViewById(R.id.yes2);
        no2 = findViewById(R.id.no2);
        yes3 = findViewById(R.id.yes3);
        no3= findViewById(R.id.no3);
        occasional1= findViewById(R.id.occasional1);
        occasional2= findViewById(R.id.occasional2);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        save3 = (MaterialButton) findViewById(R.id.save3);
        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> LifeStylePref = new HashMap<>();
                if (veg.isSelected()) {
                    LifeStylePref.put("Food", "veg");
                } else {
                    LifeStylePref.put("Food", "nonveg");
                }
                if (yes0.isSelected()) {
                    LifeStylePref.put("Alcohol", "yes");
                } else {
                    LifeStylePref.put("Alcohol", "no");
                }
                if (yes1.isSelected()) {
                    LifeStylePref.put("Smoke", "yes");
                }
                else if(no1.isSelected()) {
                    LifeStylePref.put("Smoke", "no");
                }
                else {
                    LifeStylePref.put("Smoke", "occasional");
                }
                if (yes2.isSelected()) {
                    LifeStylePref.put("PetFriendly", "yes");
                }
                else if(occasional2.isSelected()) {
                    LifeStylePref.put("PetFriendly", "ocassional2");
                }
                else {
                    LifeStylePref.put("PetFriendly", "no");
                }
                if (yes3.isSelected()) {
                    LifeStylePref.put("SharedCooking", "yes");
                }
                else {
                    LifeStylePref.put("SharedCooking", "no");
                }
                db.collection("LifeStylePref").document(auth.getCurrentUser().getUid()).set(LifeStylePref).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LifeStyle.this, "Data Added", Toast.LENGTH_SHORT).show();

                            Intent intent1 = new Intent(LifeStyle.this, LifePref2.class);
                            startActivity(intent1);

                        }
                    }
                });


            }


        });



    }
}