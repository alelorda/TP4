    package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
    private EditText editTextUsuario;
    private EditText editTextPassword;
    private Button btnRegistrar;
    private Button btnIngresar;
    String usuario= "alumno";
    String password="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre= String.valueOf(editTextUsuario.getText());
                String clave= String.valueOf(editTextPassword.getText());
                clave = clave.toLowerCase();
                nombre= nombre.toLowerCase();
                Intent ingresar = new Intent(getApplicationContext(),InicioActivity.class);
                if (nombre.equals(usuario) && clave.equals(password))  {

                    startActivity(ingresar);

                }else{ Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecta",Toast.LENGTH_LONG).show();}

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registrar = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(registrar);
            }
        });
    }
}