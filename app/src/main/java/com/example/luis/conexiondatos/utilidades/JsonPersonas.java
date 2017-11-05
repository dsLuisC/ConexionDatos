package com.example.luis.conexiondatos.utilidades;

import com.example.luis.conexiondatos.modelos.personas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 31/10/17.
 * Clase para convertir una estructura de datos JSON a tipo arrayList
 */

public class JsonPersonas {
    public static List<personas> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);

        List<personas> listaPersonas = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            listaPersonas.add(new personas(item.getString("nombres"), item.getString("apellidos"), item.getInt("edad"), item.getString("telefono")));
        }

        return listaPersonas;
    }
}
