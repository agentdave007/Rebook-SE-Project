package com.example.rebook.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.rebook.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;
    private static final int RC_CODE=1;
    EditText mEmail,mPassword;
    TextView mForgetPassword;
    String[] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};;
    Button mLogin,mRegister;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    private SignInButton signIn; //google sign in
    GoogleSignInClient mGoogleSignInClient; //sign in client
    private String TAG ="IN the main activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        LinearLayout linearLayout = findViewById(R.id.rootConstraint);
        //animation start
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();
        // animation end

        mEmail = findViewById(R.id.email_id);
        mPassword = findViewById(R.id.email_pwd);
        mForgetPassword = findViewById(R.id.forgetPassword);
        progressBar=findViewById(R.id.progressBar_cyclic);
        mLogin = findViewById(R.id.loginbutton);
        mRegister = findViewById(R.id.registerbutton);
        signIn= findViewById(R.id.sign_in_button);
        mAuth=FirebaseAuth.getInstance();


        verifyPermission();

    }

    private void methodOncreateLogin(){
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(ProgressBar.VISIBLE);
                signInwithEmail(mEmail.getText().toString(),mPassword.getText().toString());
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,com.example.rebook.login.RegisterActivity.class);
                startActivity(intent);
            }
        });
        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,com.example.rebook.login.forgotpasswordactivity.class);
                startActivity(intent);
            }
        });

    }







    // sign in intent provided by gogle
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }




    private void verifyPermission(){



        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permission[0])== PackageManager.PERMISSION_GRANTED
                &&ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permission[1])== PackageManager.PERMISSION_GRANTED
        ){
            methodOncreateLogin();

        }else{
            ActivityCompat.requestPermissions(LoginActivity.this,permission,RC_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean showRationale=true;
        if(requestCode==RC_CODE){
            String wantPermission=permission[0];

            for(int i=0;i<permissions.length;i++){
               wantPermission= permissions[i];
               showRationale = ActivityCompat.shouldShowRequestPermissionRationale(LoginActivity.this,wantPermission);

               if(showRationale==false){
                   if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                           permission[0])== PackageManager.PERMISSION_GRANTED
                           &&ContextCompat.checkSelfPermission(this.getApplicationContext(),
                           permission[1])== PackageManager.PERMISSION_GRANTED
                   ){
                                showRationale=true;
                   }
                   break;
               }

        }
            if(showRationale==false){
              //  final boolean activitystarted=false;
                final Intent in = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri= Uri.fromParts("package",getPackageName(),null);
                in.setData(uri);
                //startActivity(in);// intent ;

                final Toast toast= Toast.makeText(this,"Click permission to grant permission otherwise app wont work "+ showRationale,Toast.LENGTH_SHORT);
                CountDownTimer toastCountDown;
                toastCountDown = new CountDownTimer(10000,500) {
                  boolean activitystarted=false;
                    @Override
                    public void onTick(long millisUntilFinished) {
                        toast.show();
                        if(activitystarted==false){
                            startActivity(in);
                            activitystarted=true;
                        }

                    }

                    @Override
                    public void onFinish() {
                        toast.cancel();
                        //startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                     //   methodOncreateLogin();
                        onCreate(null);
                    }
                };

                toast.show();
                toastCountDown.start();
            }
            else{
                verifyPermission();
            }
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    } // onactivityresult

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        progressBar.setVisibility(ProgressBar.VISIBLE);
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUIGoogle(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                            /* updateUI(null); */
                        }
                        progressBar.setVisibility(ProgressBar.INVISIBLE);
                        // ...
                    }
                });

    }

    private void updateUIGoogle(FirebaseUser user) {

        if(user!=null&&user.isEmailVerified()){
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());

            if (acct != null&& user!= null) {
                String personName = acct.getDisplayName();
                Toast.makeText(getApplicationContext(),"welcome"+personName,Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),com.example.rebook.profile.profile.class);
                startActivity(i);
            }
        }
        else if(user!=null){
            Toast.makeText(getApplicationContext(), "verify email first", Toast.LENGTH_LONG).show();
        }

    }
    private void updateUIEmail(FirebaseUser user) {

        if(user!=null&&user.isEmailVerified()){

                String personName = user.getDisplayName();
                Toast.makeText(getApplicationContext(),"welcome"+personName,Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),com.example.rebook.profile.profile.class);
                startActivity(i);
        }
        else if(user!=null){
            Toast.makeText(getApplicationContext(), "verify email first", Toast.LENGTH_LONG).show();
        }

    }


        /* checking whether user is signed in or not */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null&&currentUser.isEmailVerified()){
            Intent i= new Intent(LoginActivity.this,com.example.rebook.blankactivity.class);
            startActivity(i);
        }
    }

    private void signInwithEmail(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(getApplicationContext(), "sign in method login",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                            updateUIEmail(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();
                            updateUIEmail(null);
                        }

                        // ...
                    }
                });


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

