package com.example.android.lastass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

//    private TextView textViewUserEmail;
    private FirebaseAuth firebaseAuth;
    private Button buttonLogout;
    private Switch mySwitch;
    private Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mySwitch = findViewById(R.id.mySwitch);
        final View root = mySwitch.getRootView();

        mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ProfileActivity.this, getResources().getStringArray(R.array.spinnerItems)[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Listener on Swicth to toggle the background color
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("kj","isChecked -> "+isChecked);
                if(isChecked){
                    root.setBackgroundColor(getResources().getColor(R.color.black));
                }else {
                    root.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                }
            }
        });



        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

//        textViewUserEmail = findViewById(R.id.textViewUserEmail);
//        textViewUserEmail.setText("Welcome " + user.getEmail() + ";)");
        buttonLogout = findViewById(R.id.logoutButton);

        buttonLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
