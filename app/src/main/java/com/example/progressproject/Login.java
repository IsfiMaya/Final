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

public class Login extends AppCompatActivity {
    TextView createnewAccount;

    Button btnlogin;
    EditText edtEmail,edtPass;
    String Email,Password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_siswa);


        edtEmail=findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnlogin=findViewById(R.id.buttonLogin  );

        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,HomeSiswaActivity.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforLogin();
            }
        });
    }

    private void perforLogin() {

        String Email=edtEmail.getText().toString();
        String Password=edtPass.getText().toString();

        if (!Email.matches(emailPattern)) {
            edtEmail.setError("Enter Connext Email");
        }else if(Password.isEmpty() || Password.length()<6)
        {
            edtPass.setError("Enter Proper Password");
        }else
        {
            progressDialog.setMessage("Please Wait While Login...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Login.this, "Login Sukses", Toast.LENGTH_LONG).show();
                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Login.this, "Email Dan Password Anda Salah"+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent=new Intent(Login.this,HomeSiswaActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
