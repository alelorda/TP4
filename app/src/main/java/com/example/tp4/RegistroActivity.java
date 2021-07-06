package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    private EditText editTextCorreo,editTextPasswordRegistro,editTextNombreCompleto;
    private Button btnRegistrar2, btnIngresar2;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextPasswordRegistro = findViewById(R.id.editTextPasswordRegistro);
        editTextNombreCompleto = findViewById(R.id.editTextNombreCompleto);
        btnRegistrar2 = findViewById(R.id.btnRegistrar2);
        btnIngresar2 = findViewById(R.id.btnRegistrar2);

        pref = getSharedPreferences("his_pref", Context.MODE_PRIVATE);

        btnRegistrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();

                String correo = editTextCorreo.getText().toString();
                String pass = editTextPasswordRegistro.getText().toString();
                String nombre = editTextNombreCompleto.getText().toString();

                editor.putString("correo",correo);
                editor.putString("pass",pass);
                editor.putString("nombre",nombre);

                editor.commit();
            }
        });

    }
}