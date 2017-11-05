package com.example.luis.conexiondatos.vistas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luis.conexiondatos.R;
import com.example.luis.conexiondatos.modelos.personas;
import com.example.luis.conexiondatos.utilidades.HttpManager;
import com.example.luis.conexiondatos.utilidades.JsonPersonas;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<personas> listaPersonas;
    ProgressBar pbProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbProgreso = (ProgressBar) findViewById(R.id.pbProgreso);
    }

    public Boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    public void loadData(View view) {
        if (isOnline()) {
            MyTask task = new MyTask();
            task.execute("http://api.myjson.com/bins/ex7mz");
        } else {
            Toast.makeText(this, "No tenemos conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData () {
        //comprobamos que ya tenemos la lista de elementos imprimiendo un dato en pantalla
        Toast.makeText(this, listaPersonas.get(1).getNombres(), Toast.LENGTH_SHORT).show();
    }

    public class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() { //antes de la peticion
            super.onPreExecute();
            pbProgreso.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) { //durante la peticion, accion principal de carga de datos
            String content = null;
            try {
                //listaPersonas = JsonPersonas.getData(content);
                content = HttpManager.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onPostExecute(String s) { //despues de la peticion
            super.onPostExecute(s);
            try {
                listaPersonas = JsonPersonas.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            pbProgreso.setVisibility(View.GONE);
            processData();
        }
    }

    //tareas asincronas en android
    //http://api.myjson.com/bins/ex7mz
    //webservices
}
