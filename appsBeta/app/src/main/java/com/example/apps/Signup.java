package com.example.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {

    TextInputEditText username, email, password, confirmPass;
    Button SignUp;
    TextView loginRedirect;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.userSign);
        email = findViewById(R.id.emailSign);
        password = findViewById(R.id.passSign);
        confirmPass = findViewById(R.id.confirmPassword);
        SignUp = findViewById(R.id.SignUpBTN);
        loginRedirect = findViewById(R.id.LoginRedirect);

        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass1 = password.getText().toString().trim();
                String pass2 = confirmPass.getText().toString().trim();
                if (username!=null && email!=null && password!=null || confirmPass!=null){
                    if (pass1.equals(pass2)){
                        checkUsername();
                    }else {
                        Toast.makeText(Signup.this, "password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Signup.this, "all field must be filled", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public void checkUsername(){
        String userName = username.getText().toString().trim();
        reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkusr = reference.orderByChild("username").equalTo(userName);
        checkusr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    username.setError("username already exist");
                } else  {

                    database = FirebaseDatabase.getInstance();
                    reference = database.getReference("users");
                    String user = username.getText().toString();
                    String eml = email.getText().toString();
                    String pass = password.getText().toString();
                    String confirmpass = confirmPass.getText().toString();
                    DBaseHelper helperClass = new DBaseHelper(user, eml, pass, confirmpass);
                    reference.child(user).setValue(helperClass);
                    Toast.makeText(Signup.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Signup.this, Login.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}