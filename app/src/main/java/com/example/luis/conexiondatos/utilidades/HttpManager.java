package com.example.luis.conexiondatos.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by luis on 27/10/17.
 * Clase para gestionar las peticiones a traves de internet
 */

public class HttpManager {
    public static String getData(String ruta) throws IOException {
        BufferedReader reader = null;
        URL url = new URL(ruta);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line+"\n");
        }
        return stringBuilder.toString();
    }
}
