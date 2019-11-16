package com.example.alumno.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class inicio extends AppCompatActivity {

    TextView ctvCodigo;
    EditText cetNoControl;
    Button cbtnGenerar;
    JSONArray jsa;
    Map<String, String> parameter = new HashMap<>();
    Random random = new Random();
    int numero = (random.nextInt(900000) + 100000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ctvCodigo = (TextView) findViewById(R.id.tvCodigo);
        cetNoControl = (EditText) findViewById(R.id.etNoControl);
        cbtnGenerar=(Button)findViewById(R.id.btnGenerar);
        cetNoControl.setVisibility(View.GONE);
        String noControl = getIntent().getStringExtra("noControl");
        asignarCodigo("http://cesaraxelps.000webhostapp.com/verificacion/android_services/get_codigo.php?no_control=" + noControl);
        cetNoControl.setText(noControl);
    }

    public void asignarCodigo(final String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (response.equals("No hay")) {
                        cbtnGenerar.setVisibility(View.VISIBLE);
                        ctvCodigo.setText("No hay un código aún");
                    } else {
                        cbtnGenerar.setVisibility(View.GONE);
                        jsa = new JSONArray(response);
                        JSONObject row = jsa.getJSONObject(0);

                        String codigo = row.getString("codigo").toString();
                        ctvCodigo.setText(codigo);
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error al asignar el código", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(sr);
    }

    public void generar(View pantalla) {
        insertarCodigo("http://cesaraxelps.000webhostapp.com/verificacion/android_services/insertar_codigo.php");
    }

    public void insertarCodigo(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                if (response.equals("Realizado")) {
                    asignarCodigo("http://cesaraxelps.000webhostapp.com/verificacion/android_services/get_codigo.php?no_control=" + cetNoControl.getText().toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameter = new HashMap<>();
                parameter.put("codigo", String.valueOf(numero));
                parameter.put("no_control", cetNoControl.getText().toString());

                return parameter;
            }
        };

        queue.add(sr);
    }
}
