package com.example.rebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
public class blankactivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blankactivity);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                {
                    Toast.makeText(getApplicationContext(),"User sign out",Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(getApplicationContext(),com.example.rebook.login.LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }
    public void backtoHome(View v){
        Intent i= new Intent(getApplicationContext(),com.example.rebook.launch.MainActivity.class);
        startActivity(i);
        finish();
    }
}
