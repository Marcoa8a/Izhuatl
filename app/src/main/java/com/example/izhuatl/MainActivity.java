package com.example.izhuatl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}