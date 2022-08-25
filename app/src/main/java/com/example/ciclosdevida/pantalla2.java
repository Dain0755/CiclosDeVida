package com.example.ciclosdevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla2 extends AppCompatActivity {
    TextView id, nombres, apellidos, celular, correo;
    ImageView foto;
    Button tomarFoto;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String TAG = "pantalla2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        Log.i(TAG, "--onCreate--");
        id = findViewById(R.id.tvIdentificacion);
        nombres = findViewById(R.id.tvNombres);
        apellidos = findViewById(R.id.etApellidos);
        celular = findViewById(R.id.etCelular);
        correo = findViewById(R.id.etCorreo);
        String identi = getIntent().getStringExtra("id");
        String nombre = getIntent().getStringExtra("nombres");
        id.setText(identi);
        nombres.setText(nombre);
        tomarFoto = findViewById(R.id.btnInsertar);
        tomarFoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "--onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "--onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "--onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "--onDestroy");
    }
}