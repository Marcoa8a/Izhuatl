package com.example.izhuatl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText txtName;
    private EditText txtLastName;
    private EditText txtMail;
    private EditText txtPassword;
    private Button btnRegister;

    private String userID;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = findViewById(R.id.name_text);
        txtLastName = findViewById(R.id.last_name_text);
        txtMail = findViewById(R.id.emailR_text);
        txtPassword = findViewById(R.id.passwordR_text);
        btnRegister = findViewById(R.id.btn_register);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnRegister.setOnClickListener(view -> {
            createUser();
        });
    }

    public void createUser(){
        String name = txtName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String mail = txtMail.getText().toString();
        String password = txtPassword.getText().toString();

        if(TextUtils.isEmpty(name)){
            txtName.setError("Ingrese un nombre");
            txtName.requestFocus();
        }else if(TextUtils.isEmpty(lastName)){
            txtLastName.setError("Ingrese un apellido");
            txtLastName.requestFocus();
        }else if(TextUtils.isEmpty(mail)){
            txtMail.setError("Ingrese un correo");
            txtMail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            txtPassword.setError("Ingrese una contraseña");
            txtPassword.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        userID = mAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = db.collection("users").document(userID);

                        Map<String,Object> user = new HashMap<>();
                        user.put("Nombre", name);
                        user.put("Apellido", lastName);
                        user.put("Correo", mail);
                        user.put("Contraseña", password);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d("TAG", "OnSuccess: Datos registrados" + userID);
                            }
                        });
                        Toast.makeText(Register.this, "Usuario registrado!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, MainActivity.class));
                    }else{
                        Toast.makeText(Register.this, "Usuario no registrado" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}