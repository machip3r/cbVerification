package com.example.alumno.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class splash extends AppCompatActivity {

    EditText cetUsuario, cetContrasena;
    JSONArray jsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cetUsuario = (EditText) findViewById(R.id.etUsuario);
        cetContrasena = (EditText) findViewById(R.id.etContrasena);
    }

    public void verificar(View pantalla) {
        if (!cetUsuario.getText().equals("") && !cetContrasena.getText().equals("")) {
            //autentificar("http://mh3.epizy.com/view/practice/6/verificar.php?user="+cetUsuario.getText().toString());
            autentificar("http://cesaraxelps.000webhostapp.com/verificacion/android_services/verificar_alumno.php?usuario=" + cetUsuario.getText().toString());
            //autentificar("http://www.csm.alonsher.com/6/verificar.php?user="+cetUsuario.getText().toString());
        } else {
            Toast.makeText(getApplicationContext(), "Por favor rellena los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void autentificar(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    jsa = new JSONArray(response);
                    JSONObject row = jsa.getJSONObject(0);
                    String no_control = row.getString("no_control").toString();
                    String contrasena = row.getString("contrasena").toString();
                    if (contrasena.equals(cetContrasena.getText().toString())) {
                        Intent welcome = new Intent(splash.this, inicio.class);
                        welcome.putExtra("noControl", no_control);
                        startActivity(welcome);
                    } else {
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Usuario no existente, regístrate por favor", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(sr);
    }

    public void registrar(View pantalla) {
        Intent registro = new Intent(splash.this, registrar.class);
        startActivity(registro);
    }
}
