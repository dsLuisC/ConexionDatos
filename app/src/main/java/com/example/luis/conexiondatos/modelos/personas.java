package com.example.luis.conexiondatos.modelos;

/**
 * Created by luis on 31/10/17.
 * Clase para manejar el modelo de nuestra entidad
 */

public class personas {
    private String nombres;
    private String apellidos;
    private int edad;
    private String telefono;

    public personas(String nombres, String apellidos, int edad, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
