package com.example.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    private Button userButton;
    private EditText userName;
    private String userNameBase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userButton=findViewById(R.id.userButton);
        userName=findViewById(R.id.userTextEdit);
        userButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userButton:
                //lectura database


               // if(userName.equals data base username){
               // traigame los contactos de ese usuario
               // }else{
               // crea un nuevo usuario - crea con id, username, contactos vacios
                //push ref database
                //}
                Intent i = new Intent(this,LlamarActivity.class);
                startActivity(i);
                break;

        }
    }
}