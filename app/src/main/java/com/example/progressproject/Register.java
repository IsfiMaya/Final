package com.example.progressproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Register extends AppCompatActivity {
    Button btnRegister;
    EditText inputUsername, inputEmail, inputPassword, inputConformPassword;
    String Username,Email,Password,ConformPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account);


        inputUsername = findViewById(R.id.inputUsername);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConformPassword = findViewById(R.id.inputConformPassword);
        btnRegister=findViewById(R.id.btnRegister);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();
            }
        });

    }

    private void PerforAuth() {
        String Username=inputUsername.getText().toString();
        String Email=inputEmail.getText().toString();
        String Password=inputPassword.getText().toString();
        String ConformPassword=inputConformPassword.getText().toString();

        if (!Email.matches(emailPattern)) {
            inputEmail.setError("Enter Connext Email");
        }else if(Password.isEmpty() || Password.length()<6)
        {
            inputPassword.setError("Enter Proper Password");
        }else if (!Password.equals(ConformPassword))
        {
            inputConformPassword.setError("Password Not macth field");
        }else
        {
            progressDialog.setMessage("Please Wait While Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Register.this, "Registrasi Sukses", Toast.LENGTH_LONG).show();
                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Register.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(Register.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
