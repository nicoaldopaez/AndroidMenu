package com.example.menumoviles1;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Controlador controlador;
    private Adaptador adaptador;
    private List<String> listaDeAlumnos;
    private ListView listaAlumnosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        controlador = new Controlador();
        listaDeAlumnos=new ArrayList<>();
        controlador.crearAlumno();

        for(Alumno alumno : controlador.getListaAlumnos()){
            listaDeAlumnos.add(alumno.getNombre());
        }

        adaptador = new Adaptador(this, R.layout.item_layout, controlador.getListaAlumnos());
        listaAlumnosListView = findViewById(R.id.listaAlumnos);
        listaAlumnosListView.setAdapter(adaptador);

        registerForContextMenu(listView);
        listaAlumnosListView.setOnItemClickListener(controlador);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.controlador.getNombre(info.position));
        inflater.inflate(R.menu.action_bar_menu,menu);
    }
    public boolean onOptionItemSelected(MenuItem item){
        if(item.getItemId()==R.id.btnAdd){
            controlador.agregarAlumno();
            adaptador.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.btnDel){
            controlador.borrarAlumno(info.position);
            adaptador.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void establecerActionBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor();
    }


}