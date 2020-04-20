package com.example.rebook.login;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rebook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity  {
    EditText mEmail,mPassword;
    Button mRegisterbtn;
    TextView mloginPageBack;
    ProgressBar progressBar;
    String TAG=" Register activity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        mRegisterbtn=findViewById(R.id.registerBtn);
        mEmail=findViewById(R.id.email_reg);
        mPassword=findViewById(R.id.email_pwd_reg);
        mloginPageBack=findViewById(R.id.alreadyLogin);
        progressBar=findViewById(R.id.progressBar_cyclic);

        mAuth = FirebaseAuth.getInstance();
        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(mEmail.getText().toString(),mPassword.getText().toString());
            }
        });
        mloginPageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(RegisterActivity.this,com.example.rebook.login.LoginActivity.class);
                startActivity(i);

            }
        });
    }//oncreate

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
      //  updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if(currentUser!=null){
            Toast.makeText(getApplicationContext(),"Registration successful",Toast.LENGTH_LONG).show();
            Intent i= new Intent(RegisterActivity.this,com.example.rebook.login.LoginActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();
        }
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            sendEmailVerification();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "ID already exists",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        progressBar.setVisibility(ProgressBar.INVISIBLE);
                        // [START_EXCLUDE]
                        // [END_EXCLUDE]
                    }
                });

        // [END create_user_with_email]
    }

    private void sendEmailVerification() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            user.sendEmailVerification()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),
                                        "Verification email sent to mail id" ,
                                        Toast.LENGTH_SHORT).show();
                                Log.d("Verification", "Verification email sent to mail id" );
                                FirebaseAuth.getInstance().signOut();
                            } else {
                                Log.e(TAG, "sendEmailVerification", task.getException());
                                Toast.makeText(getApplicationContext(),
                                        "Failed to send verification email.",
                                        Toast.LENGTH_SHORT).show();
                            }
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                        }
                    });
        }
    }


    private boolean validateForm(){
        boolean valid =true;
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Required.");
            valid = false;
        } else {
            mEmail.setError(null);
        }
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Required.");
            valid = false;
        } else {
            mPassword.setError(null);
        }

        return valid;
    }


}
