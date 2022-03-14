package com.example.switch_book;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RegistroUsuarioActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener  {

    EditText txtNombre, txtEmail, txtPassword;
    Button btnRegistrar;
    ProgressDialog progreso;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrousuario);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        request = Volley.newRequestQueue(getApplicationContext());
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebService();
            }
        });


    }

    public void cargarWebService(){
        /*progreso = new ProgressDialog(getApplicationContext());
        progreso.setMessage("Cargando...");
        progreso.show();*/

        String url = "https://switch-up.000webhostapp.com/registro.php?nombre="+txtNombre.getText().toString()+"&email="+txtEmail.getText().toString()+"&password="+txtPassword.getText().toString()+"";
        url=url.replace(" ","%20");
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        //progreso.hide();
        Toast.makeText(getApplicationContext(),"No se puede guardar...", Toast.LENGTH_LONG).show();
        Log.i("Error", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Registro guardado", Toast.LENGTH_LONG).show();
        //progreso.hide();
        txtNombre.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }
}