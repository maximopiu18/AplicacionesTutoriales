package com.example.aplicacion1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityListas extends AppCompatActivity {
    ListView lista;
    ArrayList<Integer> numeros;
    ArrayAdapter<Integer> adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        lista = findViewById(R.id.activity_listas_lista);

        createList();
    }

    public void createList() {
        numeros = new ArrayList<>();
        int i = 100;
        while (i > 0) {
            numeros.add(i);
            i--;
        }
        setAdapterToList();
    }

    public void setAdapterToList() {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numeros);
        lista.setAdapter(adapter);
        listenerList();
    }

    public void listenerList() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Log.e("POSICION", "POSICION" + posicion);
                Log.e("El numero es: ", "El numero es:" + numeros.get(posicion));
            }
        });
    }
}
