package com.example.android.lastass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //Directly start profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),
                    ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);
        buttonRegister = findViewById(R.id.registerButton);
        editTextEmail = findViewById(R.id.emailEt);
        editTextPassword = findViewById(R.id.passwordEt);
        textViewSignUp = findViewById(R.id.alreadyRegisterTv);
        buttonRegister.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }
    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(RegisterActivity.this,
                    "Please enter email",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(RegisterActivity.this,
                    "Please enter password",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Register User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            //User is successfully registered and logged in
                            //Directly start profile activity here
                            Toast.makeText(RegisterActivity.this,
                                    "Registered Successfully",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),
                                    ProfileActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this,
                                    "Could not register. Please try again",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            registerUser();
        }
        if(v == textViewSignUp){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
