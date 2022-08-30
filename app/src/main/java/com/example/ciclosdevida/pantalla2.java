package com.example.ciclosdevida;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class pantalla2 extends AppCompatActivity {
    TextView id, nombres, apellidos;
    EditText  celular, correo, hora, minuto, dia, mensaje;
    ImageView foto;
    Button tomarFoto, programar;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String TAG = "pantalla2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);
        Log.i(TAG, "--onCreate--");
        id = findViewById(R.id.tvIdentificacion);
        nombres = findViewById(R.id.tvNombres);
        apellidos = findViewById(R.id.tvApellidos);
        celular = findViewById(R.id.etCelular);
        correo = findViewById(R.id.etCorreo);
        String identi = getIntent().getStringExtra("id");
        String nombre = getIntent().getStringExtra("nombres");
        String apelli = getIntent().getStringExtra("apellidos");
        id.setText(identi);
        nombres.setText(nombre);
        apellidos.setText(apelli);
        tomarFoto = findViewById(R.id.btnTomar);
        programar = findViewById(R.id.btnHora);
        hora = findViewById(R.id.etHora);
        minuto = findViewById(R.id.etMinuto);
        dia = findViewById(R.id.etDias);
        mensaje = findViewById(R.id.etMensaje);
        foto = findViewById(R.id.ivImagen);
        tomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        programar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    createAlarm();
            }
        });
    }

    private void takePicture() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imageBitmap);
        }
    }
    private void createAlarm() {
        if (!hora.getText().toString().isEmpty() && !minuto.getText().toString().isEmpty() && !dia.getText().toString().isEmpty()) {
            String mensa = mensaje.getText().toString();
            int hour = Integer.parseInt(hora.getText().toString());
            int minute = Integer.parseInt(minuto.getText().toString());
            int days = Integer.parseInt(dia.getText().toString());
            Intent alarm = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE,  mensa)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour)
                    .putExtra(AlarmClock.EXTRA_MINUTES, minute)
                    .putExtra(AlarmClock.EXTRA_DAYS, days);
            if (alarm.resolveActivity(getPackageManager())!= null){
                startActivity(alarm);
            }
        }else{
            Toast.makeText(pantalla2.this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
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