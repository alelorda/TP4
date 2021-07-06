package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    private EditText editTextCorreo,editTextPasswordRegistro,editTextNombreCompleto,editTextIngresarUsuario, editTextRepetirPasswordRegistro,editTextemail;
    private Button btnRegistrar2, btnIngresar2;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        editTextCorreo = findViewById(R.id.editTextemail);
        editTextPasswordRegistro = findViewById(R.id.editTextRepetirPasswordRegistro);
        editTextNombreCompleto = findViewById(R.id.editTextemail);
        editTextIngresarUsuario = findViewById(R.id.editTextemail);
        btnRegistrar2 = findViewById(R.id.btnRegistrar2);
        btnIngresar2 = findViewById(R.id.btnRegistrar2);
        editTextRepetirPasswordRegistro = findViewById(R.id.editTextemail);
        editTextemail = findViewById(R.id.editTextemail);
        pref = getSharedPreferences("his_pref", Context.MODE_PRIVATE);

        btnRegistrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();

                String correo = editTextCorreo.getText().toString();
                String pass = editTextPasswordRegistro.getText().toString();
                String email = editTextemail.getText().toString();
                String nombre = editTextNombreCompleto.getText().toString();
                String usuario = editTextIngresarUsuario.getText().toString();
                String reppass = editTextRepetirPasswordRegistro.getText().toString();

                editor.putString("correo",correo);
                editor.putString("pass",pass);
                editor.putString("email",email);
                editor.putString("nombre",nombre);
                editor.putString("usuario",usuario);
                editor.putString("reppass",reppass);

                editor.commit();
                finish();
            }
        });

    }
}