package com.example.rebook.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rebook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class forgotpasswordactivity extends AppCompatActivity {

    EditText mEditEmail;
    Button btnForget;
    ProgressBar progressBar;
    String TAG = "some";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpasswordactivity);
        btnForget = findViewById(R.id.btnForgot);
        mEditEmail= findViewById(R.id.emailForgotpwd);
        progressBar=findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.INVISIBLE);
    }


    public void onSubmitClick(View view) {
        // [START send_password_reset]
        progressBar.setVisibility(ProgressBar.VISIBLE);

       FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = mEditEmail.getText().toString().trim();
        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(forgotpasswordactivity.this, "Email sent successfully", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Email sent.");
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                        }
                        else{
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                            Toast.makeText(forgotpasswordactivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



        // [END send_password_reset]
    }

}