package com.example.ciclosdevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        id = findViewById(R.id.etIdentificacion);
        nombres = findViewById(R.id.etNombre);
        apellidos = findViewById(R.id.etApellidos);
        celular = findViewById(R.id.etCelular);
        correo = findViewById(R.id.etCorreo);
        user= findViewById(R.id.etLoginUser);
        password = findViewById(R.id.etPassword);
        confiPassword = findViewById(R.id.etConfirmPassword);
        send = findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena1 = password.getText().toString();
                String cadena2 = confiPassword.getText().toString();
                if (!id.getText().toString().isEmpty() && !nombres.getText().toString().isEmpty() && !apellidos.getText().toString().isEmpty() && !user.getText().toString().isEmpty() &&
                        !password.getText().toString().isEmpty() && !confiPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    if (cadena1.equals(cadena2)){
                        enviarPantallaDos();
                        id.setText("");
                        nombres.setText("");
                        apellidos.setText("");
                        user.setText("");
                        password.setText("");
                        confiPassword.setText("");
                    }else{
                        Toast.makeText(MainActivity.this, "Los passwords no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void enviarPantallaDos() {
        String pass = id.getText().toString();
        String nombr = nombres.getText().toString();
        String apelli = apellidos.getText().toString();
        Intent intent = new Intent(this, pantalla2.class);
        intent.putExtra("id", pass);
        intent.putExtra("nombres", nombr);
        intent.putExtra("apellidos", apelli);
        startActivity(intent);
        Log.i("intent", "" + pass + nombr + apelli);
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
        Log.i(TAG, "--onRestart");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "--onDestroy");
    }
}