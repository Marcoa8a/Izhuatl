package com.example.izhuatl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.izhuatl.modal.Plant;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlant extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private EditText txtNamePlant;
    private EditText txtSizePlant;
    private EditText txtDatePlant;
    private EditText txtTypePlant;
    private Button btnSave;

    Plant plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        txtNamePlant = findViewById(R.id.enterName);
        txtTypePlant = findViewById(R.id.enterType);
        txtDatePlant = findViewById(R.id.enterDate);
        txtSizePlant = findViewById(R.id.enterSize);

        btnSave = findViewById(R.id.btn_save);

        plant = new Plant();

    }

    public void SavePlant(View view) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Plant");
        try{
            if(TextUtils.isEmpty(txtNamePlant.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the name of the plant", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(txtSizePlant.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the size of the plant", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(txtDatePlant.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the date of the plant", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(txtTypePlant.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the type of the plant", Toast.LENGTH_SHORT).show();
            }else{
                plant.setNameP(txtNamePlant.getText().toString().trim());
                plant.setTypeP(txtTypePlant.getText().toString().trim());
                plant.setDateP(txtDatePlant.getText().toString().trim());
                plant.setSizeP(txtSizePlant.getText().toString().trim());

                databaseReference.push().setValue(plant);
                Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, AdPlantV.class));

            }
        }catch(NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid information", Toast.LENGTH_SHORT).show();
        }
    }
}





























