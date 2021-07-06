package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InicioActivity extends AppCompatActivity {

    private ImageButton  btnCoreo, btnWeb, btnTelefono;
    String pagina="https://github.com/alelorda";
    String correo;
    //String asunto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnCoreo = findViewById(R.id.btnCoreo);
        btnTelefono =  findViewById(R.id.btnTelefono);
        btnWeb = findViewById(R.id.btnWeb);
        btnCoreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destinatarios = {"alexis@alexis","lionel@lionel"};
                enviarEmail(destinatarios,"consulta de nota");

            }
        });

        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:123456789"));
                startActivity(i);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri destino= Uri.parse(pagina);
                Intent a=new Intent(Intent.ACTION_VIEW,destino);
                startActivity(a);
            }
        });
    }

    public void enviarEmail(String[] correo, String asunto) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "alexis@lorda");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto");
        intent.putExtra(Intent.EXTRA_TEXT, "Hola, me pongo en contacto");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}