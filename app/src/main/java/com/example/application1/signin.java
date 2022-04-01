package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.ScriptGroup;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;



public class signin extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
      //  { openResetpass(); }




        MaterialButton Login = (MaterialButton) findViewById(R.id.Login);
        MaterialButton Resetpass = (MaterialButton) findViewById(R.id.Resetpass) ;
        Resetpass =  (MaterialButton) findViewById(R.id.Resetpass);
        Resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResetpass();
            }


        });

        EditText inputEmail = findViewById(R.id.username);
        EditText inputPassword = findViewById(R.id.Password);

        //karankamath19@gmail.com  akkkkkk
       // Login.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {
              //  openMainActivity();
            //}
           // public void onClick(View view) {
               // performLogin();



          //  }
        //});

    }

   // private void performLogin() {
        // yeh nahi chalra tha isliye alt enter karke suggestions add kiya
       /* GalleryViewModel inputEmail = null;
        String email =inputEmail.getText().toString().trim();
        GalleryViewModel inputPassword = null;
        String password =inputPassword.getText().toString().trim();
        String emailpattern= "^(.+)@(\\S+) $";

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!email.matches(emailpattern)){
            Toast.makeText(getApplicationContext(), "Invalid email address!", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }*/


    //}
   // public void openResetpass() {
   //     Intent intent1 = new Intent(this, forgotpass.class);
   //     startActivity(intent1);
   // }
    public void openResetpass() {
        Intent intent1 = new Intent(this, forgotpass.class);
        startActivity(intent1);
    }
}
