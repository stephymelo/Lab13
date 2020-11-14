package com.example.lab13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("message");

    private Button userButton;
    private EditText userName;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userButton=findViewById(R.id.userButton);
        userName=findViewById(R.id.userTextEdit);
        userButton.setOnClickListener(this);

        loadDatabase();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userButton:
                //lectura database
                String id = database.getReference().child("user").child("contact").push().getKey();


                if(userName.getText().toString().equals("steph")){

                }else{

                    DatabaseReference reference = database.getReference().child("user").child(id);

                    Usuario user = new Usuario(
                            id,
                            userName.getText().toString()

                    );
                    reference.setValue(user);

                }


                Intent i = new Intent(this,LlamarActivity.class);
                i.putExtra("userid", id);
                startActivity(i);
                break;

        }
    }

    public void loadDatabase(){

    }

}