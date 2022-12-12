package com.example.izhuatl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private FirebaseAuth mAuth;
    private EditText txtMail;
    private EditText txtPassword;
    private Button btnLogin;
    private Button btnRegister;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        this.gestureDetector = new  GestureDetector(this, this);
        gestureDetector.setOnDoubleTapListener(this);

        txtMail = findViewById(R.id.email_text);
        txtPassword = findViewById(R.id.password_text);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(view -> {
            userLogin();
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
            startActivity(new Intent());
        }
    }

   public void userLogin(){
        String mail = txtMail.getText().toString();
        String password = txtPassword.getText().toString();

        if(TextUtils.isEmpty(mail)){
            txtMail.setError("Ingrese un correo");
            txtMail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
            txtPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Bienvenid@", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MenuDrawer.class));
                    }else{
                        Log.w("TAG", "Error", task.getException());
                    }
                }
            });
        }
    }

    public void Login(View view) {
        Intent intent = new Intent(this, MenuDrawer.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(this, RecoverAccount.class);
        startActivity(intent);
    }

    public void registerUser(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Uri webpage = Uri.parse("https://www.facebook.com/profile.php?id=100086646683854&mibextid=ZbWKwL");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Toast.makeText(this, "Página de Facebook de Izhuatl", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Uri webpage = Uri.parse("https://instagram.com/izhu.atl?igshid=YmMyMTA2M2Y=");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Toast.makeText(this, "Página de Instagram de Izhuatl", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        String toNumber ="524493633549";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber));
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}