package com.example.application1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//activity_otp_send
import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class activity_otp_send extends Activity {
    private  activity_otp_send binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
     private MaterialButton Save6;
    private View MaterialbuttonSave6;
    EditText etPhone = findViewById(R.id.etPhone);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = activity_otp_send.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        binding.MaterialbuttonSave6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (binding.etPhone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(activity_otp_send.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else if (binding.etPhone.getText().toString().trim().length() != 10) {
                    Toast.makeText(activity_otp_send.this, "Type valid Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    otpSend();
                }
            }
        });
    }

    private static activity_otp_send inflate(LayoutInflater layoutInflater) {
        return null;
    }

    private int getRoot() {
        return 0;
    }



    private void otpSend() {
        binding.MaterialbuttonSave6.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                binding.MaterialbuttonSave6.setVisibility(View.VISIBLE);
                Toast.makeText(activity_otp_send.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                binding.MaterialbuttonSave6.setVisibility(View.VISIBLE);
                Toast.makeText(activity_otp_send.this, "OTP is successfully send.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_otp_send.this, activity_otp_verify .class);
                intent.putExtra("phone", binding.etPhone.getText().toString().trim());
                intent.putExtra("verificationId", verificationId);
                startActivity(intent);
            }
        };





        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + binding.etPhone.getText().toString().trim())
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}
