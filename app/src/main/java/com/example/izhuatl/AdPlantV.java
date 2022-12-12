package com.example.izhuatl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.izhuatl.modal.Plant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdPlantV extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private EditText txtNamePlant;
    private EditText txtSizePlant;
    private EditText txtDatePlant;
    private EditText txtTypePlant;

    Button btnShow, btnUpdate, btnDelete;

    Plant plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_plant_v);

        txtNamePlant = findViewById(R.id.enterName);
        txtTypePlant = findViewById(R.id.enterType);
        txtDatePlant = findViewById(R.id.enterDate);
        txtSizePlant = findViewById(R.id.enterSize);

        btnShow = findViewById(R.id.btn_showPlant);
        btnUpdate = findViewById(R.id.btn_updatePlant);
        btnDelete = findViewById(R.id.btn_deletePlant);

        plant = new Plant();
    }

    public void AddPlant(View view) {
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }

    public void showPlant(View view){
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Plant").child("1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    txtNamePlant.setText(dataSnapshot.child("nameP").getValue().toString());
                    txtTypePlant.setText(dataSnapshot.child("typeP").getValue().toString());
                    txtDatePlant.setText(dataSnapshot.child("dateP").getValue().toString());
                    txtSizePlant.setText(dataSnapshot.child("sizeP").getValue().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "No data to dislpay", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void updatePlant(View view){
        DatabaseReference updateRef = FirebaseDatabase.getInstance().getReference().child("Plant");
        updateRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("1")){
                    try{
                        plant.setNameP(txtNamePlant.getText().toString().trim());
                        plant.setTypeP(txtTypePlant.getText().toString().trim());
                        plant.setDateP(txtDatePlant.getText().toString().trim());
                        plant.setSizeP(txtSizePlant.getText().toString().trim());

                        databaseReference = FirebaseDatabase.getInstance().getReference().child("Plant").child("1");
                        databaseReference.setValue(plant);

                        Toast.makeText(getApplicationContext(), "Data update successfully", Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "Data is not valid", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "No source to update", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void deletePlant(View view){
        DatabaseReference deleteRef = FirebaseDatabase.getInstance().getReference().child("Plant");
        deleteRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("1")){
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Plant").child("1");
                    databaseReference.removeValue();
                    Toast.makeText(getApplicationContext(), "Plant deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No data source to delete", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}






























