package com.example.menumoviles1;

public class  Alumno {
    private int numero;
    private String nombre;
    public Alumno(int numero, String nombre){
        this.nombre=nombre;
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
