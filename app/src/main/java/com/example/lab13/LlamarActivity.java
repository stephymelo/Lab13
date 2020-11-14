package com.example.lab13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LlamarActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("message");
    private Button agregarButton;
    private EditText numContactoEdit,nomContactoEdit;
    private ContactoAdapter adapter;
    private ListView usuarioList;
    private String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);

        numContactoEdit=findViewById(R.id.numContactoEdit);
        nomContactoEdit=findViewById(R.id.nomContactoEdit);
        agregarButton=findViewById(R.id.agregarButton);
        adapter = new ContactoAdapter();
        usuarioList.setAdapter(adapter);
        usuarioList=findViewById(R.id.lista);
        idUsuario = getIntent().getExtras().getString("userid");

        loadDatabase();


        agregarButton.setOnClickListener(
                (v)->{
                    String id =  database.getReference().child("contactos").child(idUsuario).push().getKey(); //para escribirse como firebase
                    DatabaseReference reference = database.getReference().child("contactos").child(idUsuario).child(id);
                    Contacto contactos = new Contacto(
                            id,
                            idUsuario,
                            nomContactoEdit.getText().toString(),
                            numContactoEdit.getText().toString()
                    );
                    reference.setValue(contactos);

                }
        );


    }



    public void loadDatabase(){
        reference= database.getReference().child("user").child(idUsuario);
        reference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        adapter.clear();
                        for (DataSnapshot child :snapshot.getChildren() ) {
                            Contacto contacto =child.getValue(Contacto.class);
                            adapter.agregarUser(contacto);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }

        );
    }


}