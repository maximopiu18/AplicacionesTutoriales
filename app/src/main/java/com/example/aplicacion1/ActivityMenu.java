package com.example.aplicacion1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class ActivityMenu extends AppCompatActivity {

    String TAG = "ActivityMenu";

    TextView tvNombre;

    ImageView imgFoto;
    Button btnGaleria;
    Button btnCamera;
    int GALERY = 1000;
    int CAMERA = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //checkIntentExtras();

        imgFoto=findViewById(R.id.img1);
        btnGaleria = findViewById(R.id.activity_menu_galeria);
        btnCamera = findViewById(R.id.activity_menu_camara);
        loadListeners();


    }

    public void loadListeners(){
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA);

            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Selecciona una imagen"),GALERY);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALERY){
            if (resultCode==RESULT_OK){

            }
            else if(resultCode==RESULT_CANCELED){

            }

        }

        if (requestCode==CAMERA){
            if (resultCode==RESULT_OK){
                Log.e(TAG,"Se carga la imagen de camara");
               Bitmap photo = (Bitmap)data.getExtras().get("data");
               imgFoto.setImageBitmap(photo);
            }
            else if (resultCode == RESULT_CANCELED){
                Log.e(TAG,"SE CANCELO EL FLUJO AL REGRESARNOS DE LA CAMARA");
            }
        }
    }

    public void checkIntentExtras(){
        if(getIntent().hasExtra("nombre")){
            Log.e(TAG,"El dato existe");
            tvNombre.setText(getIntent().getExtras().getString("nombre"));
        }
        else {
            Log.e(TAG, "El dato no existe");
            tvNombre.setText("No hay datos o no existe");
        }

    }

}
