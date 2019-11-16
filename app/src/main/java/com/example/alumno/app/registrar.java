package com.example.alumno.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registrar extends AppCompatActivity {

    EditText cetRUsuario, cetRContrasena, cetRNoControl, cetRAlumno, cetRTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        cetRNoControl=(EditText)findViewById(R.id.etRNoControl);
        cetRUsuario=(EditText)findViewById(R.id.etRUsuario);
        cetRAlumno=(EditText)findViewById(R.id.etRAlumno);
        cetRContrasena=(EditText)findViewById(R.id.etRContrasena);
        cetRTelefono=(EditText)findViewById(R.id.etRTelefono);
    }

    public void cancelar(View pantalla){
        Intent login=new Intent(registrar.this, MainActivity.class);
        startActivity(login);
        finish();
    }

    public void registrar(View pantalla){
        insertar("http://cesaraxelps.000webhostapp.com/verificacion/android_services/insertar_alumno.php");
    }

    public void insertar(final String url){
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                if(response.equals("Realizado")){
                    Intent login=new Intent(registrar.this, MainActivity.class);
                    startActivity(login);
                    finish();
                } else {
                    cetRUsuario.setText("");
                    cetRContrasena.setText("");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameter = new HashMap<>();
                parameter.put("no_control", cetRNoControl.getText().toString());
                parameter.put("usuario", cetRUsuario.getText().toString());
                parameter.put("alumno", cetRAlumno.getText().toString());
                parameter.put("contrasena", cetRContrasena.getText().toString());
                parameter.put("telefono", cetRTelefono.getText().toString());

                return parameter;
            }
        };

        queue.add(sr);
    }
}
