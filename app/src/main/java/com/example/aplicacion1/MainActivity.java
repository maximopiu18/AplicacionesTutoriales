package com.example.aplicacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{



    Operaciones operaciones;
    Button btn1;
    ImageView imgBack;
    TextView tvTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadInstances();
        loadUI();
        loadListeners();


    }

    private void loadInstances(){

        operaciones = new Operaciones();
        Utilerias utilerias = new Utilerias();
        utilerias.getName();
    }

    private void loadUI(){
        btn1 = findViewById(R.id.main_activity_btn_1);
        imgBack = findViewById(R.id.btn_back);
        tvTittle = findViewById(R.id.tv_title_header);

        tvTittle.setText("Pantalla Principal");

    }
    private void loadListeners(){
        Context context = MainActivity.this;
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "bienvenido", Toast.LENGTH_SHORT).show();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Quieres salir de la app ? ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void message(){

    }





}