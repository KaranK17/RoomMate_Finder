package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class HousePref extends AppCompatActivity {
    private MaterialButton save2;
    private EditText location, miles, minbud, maxbud;
    private RadioButton studio, priv;
    private FirebaseAuth auth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_pref);

        location = findViewById(R.id.Location);
        miles = findViewById(R.id.Miles);
        minbud = findViewById(R.id.MinBud);
        maxbud = findViewById(R.id.MaxBud);
        studio = findViewById(R.id.studio);
        priv = findViewById(R.id.priv);


        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        save2 = (MaterialButton) findViewById(R.id.save2);
        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlifestylepref();
            }


        });
    }

    public void openlifestylepref() {
        HashMap<String, Object> HousePref = new HashMap<>();
        HousePref.put("location", location.getText().toString());
        HousePref.put("miles", miles.getText().toString());
        HousePref.put("minbud", minbud.getText().toString());
        HousePref.put("maxbud", maxbud.getText().toString());

        if (studio.isSelected()) {
            HousePref.put("roomtype", "studio");
        } else {
            HousePref.put("roomtype", "private");
        }

        db.collection("HousePref").document(auth.getCurrentUser().getUid()).set(HousePref).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(HousePref.this, "Data Added", Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(HousePref.this, LifeStyle.class);
                    startActivity(intent1);
                }
            }
        });

    }
}
