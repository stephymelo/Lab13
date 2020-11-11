package com.example.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LlamarActivity extends AppCompatActivity {
    private String numeroContacto;
    private Button agregarButton;
    private EditText numContactoEdit,nomContactoEdit;
    private int numContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);
        numContactoEdit=findViewById(R.id.numContactoEdit);
        nomContactoEdit=findViewById(R.id.nomContactoEdit);
        agregarButton=findViewById(R.id.agregarButton);

    }





    /*
    onClick Llamar
    convertir el string de numeroContacto a int
    usar el metodo de llamar




     */


}