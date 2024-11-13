package com.example.menumoviles1;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private ArrayList<Alumno> listaAlumnos;
    private int idAlumno=0;


    public Controlador(MainActivity activity){
        listaAlumnos = new ArrayList<>();

        rellenarAlumnos();
    }

    public void agregarAlumno(){
        int num = buscarNumLibre();
        listaAlumnos.add(new Alumno(num,"alumno "+idAlumno);
        idAlumno++;
        reordenarLista();
    }
    public void borrarAlumno(int posicion){
        if(posicion >= 0 && posicion < listaAlumnos.size()){
            listaAlumnos.remove(posicion);
        }
    }
    private int buscarNumLibre(){
        for(int i=0;i<listaAlumnos.size();i++){
            if(i!=listaAlumnos.get(i).getNumero())return i;{
                return listaAlumnos.size();
            }
        }
    }

    public void reordenarLista(){
        listaAlumnos.sort((a1,a2)-> Integer.compare(a1.getNumero(),a2.getNumero()));
    }

    public void rellenarAlumnos(){
        for(int contador = 0;contador < 5;contador++){
            listaAlumnos.add(new Alumno(contador,"alumno"+idAlumno));
            idAlumno++;
        }
    }
    public List<Alumno>getListaAlumnos(){
        return listaAlumnos;
    }
    public String getNombreAlumno(int i){
        return 
    }



}
