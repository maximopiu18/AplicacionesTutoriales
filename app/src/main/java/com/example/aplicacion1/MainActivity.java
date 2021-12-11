package com.example.aplicacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvNombre;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = findViewById(R.id.main_activity_tv_nombre);
        btnEnviar = findViewById(R.id.main_activity_btn_abrir_ventana);

        tvNombre.setText("El Jhonas");
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirVentanaMenu();

            }
        });
    }

    public void abrirVentanaMenu() {
        Intent intent = new Intent(this, ActivityMenu.class);

        intent.putExtra("nombre",tvNombre.getText().toString());
        startActivity(intent);



    }


}