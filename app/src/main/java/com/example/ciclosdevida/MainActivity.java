package com.example.ciclosdevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TAG = "actividadUno";
    EditText id, nombres, apellidos, celular, correo, user, password, confiPassword;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        Log.i(TAG, "--onCreate");
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
        id = findViewById(R.id.etIdentificacion);
        nombres = findViewById(R.id.etNombre);
        apellidos = findViewById(R.id.etApellidos);
        celular = findViewById(R.id.etCelular);
        correo = findViewById(R.id.etCorreo);
        user= findViewById(R.id.etLoginUser);
        password = findViewById(R.id.etLoginPassword);
        confiPassword = findViewById(R.id.etConfirmarPassword);
        send = findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id.getText().toString().isEmpty() && !nombres.getText().toString().isEmpty() && !user.getText().toString().isEmpty() &&
                        !password.getText().toString().isEmpty() && !confiPassword.getText().toString().isEmpty()){
                    if (password==confiPassword){
                        Toast.makeText(MainActivity.this, "Datos correctos", Toast.LENGTH_SHORT).show();
                        //crearAlarma();
                        enviarPantallaDos();
                    }else{
                        Toast.makeText(MainActivity.this, "Los passwords no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }



        });
    }
    private void enviarPantallaDos() {
        String pass = password.getText().toString();
        Intent intent = new Intent(this, pantalla2.class);
        intent.putExtra("password", pass);
        startActivity(intent);
        Log.i("intent", "" + pass);
    }

    private void crearAlarma() {
        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "A trabajar!!")
                .putExtra(AlarmClock.EXTRA_HOUR, 4)
                .putExtra(AlarmClock.EXTRA_MINUTES, 10)
                .putExtra(AlarmClock.EXTRA_DAYS, 6);
        if (alarma.resolveActivity(getPackageManager())!= null){
            startActivity(alarma);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "--onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "--onRestart");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "--onDestroy");
    }
}