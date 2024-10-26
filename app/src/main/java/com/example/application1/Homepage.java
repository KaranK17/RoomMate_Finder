package com.example.application1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity
{
    private static final String TAG = "Homepage";
    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    private Integer i = 0;
    private Button btnNxt;

    ArrayList<User> details = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        textView = findViewById(R.id.tvValue);
        textView1 = findViewById(R.id.tvValueL);
        textView2= findViewById(R.id.tvValueB);
        textView3 = findViewById(R.id.tvValueG);
        textView4= findViewById(R.id.tvValueP);
        textView5 = findViewById(R.id.tvValueD);
        textView6 = findViewById(R.id.tvValuePn);
        btnNxt = findViewById(R.id.Refresh);
        db=FirebaseFirestore.getInstance();
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i >= details.size())
                {
                    i = 0;
                }
                textView.setText("Name: " + details.get(i).firstname);
                textView1.setText(details.get(i).lastname);
                textView2.setText("Date: "+details.get(i).date);
                textView3.setText("Gender: "+details.get(i).gender);
                textView4.setText("Profession: "+details.get(i).profession);
                textView5.setText("Bio: "+details.get(i).bio);
                textView6.setText("Phone: "+details.get(i).phone);
            }
        });
        db.collection("UserProfile")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                                User u = new User(
                                        document.getString("firstname"),
                                        document.getString("lastname"),
                                        document.getString("date"),
                                        document.getString("gender"),
                                        document.getString("profession"),
                                        document.getString("bio"),
                                        document.getString("phone")
                                );

                                details.add(u);
                            }
                            textView.setText("Name: " + details.get(i).firstname);
                            textView1.setText(details.get(i).lastname);
                            textView2.setText("Date: "+details.get(i).date);
                            textView3.setText("Gender: "+details.get(i).gender);
                            textView4.setText("Profession: "+details.get(i).profession);
                            textView5.setText("Bio: "+details.get(i).bio);
                            textView6.setText("Phone: "+details.get(i).phone);

                        } else {
                           // Log.w(TAG, "Error getting documents.", task.getException());

                        }


                    }

                });

    }
}


class User{

    String firstname,lastname,bio,gender,profession,date, phone;
    User(String firstname,String lastname, String date,String gender, String profession,String bio,String phone)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender= gender;
        this.profession = profession;
        this.date = date;
        this.bio = bio;
        this.phone = phone;


    }
}