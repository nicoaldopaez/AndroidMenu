package com.example.menumoviles1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    private Context context;
    private List<String> alumnos;
    private int layout;
    public Adaptador(Context context, int layout,List<String>alumnos){
        this.context = context;
        this.layout = layout;
        this.alumnos = alumnos;
    }

    @Override
    public int getCount() {
        return alumnos.size();
    }

    @Override
    public Object getItem(int i) {
        return alumnos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View v=view;
        ViewHolder holder;
        if(v==null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            v=layoutInflater.inflate(this.layout,null);
            holder = new ViewHolder();
            holder.nameTextView=v.findViewById(R.id.alumnoText);
            v.setTag(holder);
        }
        else{
            holder=(ViewHolder) v.getTag();
        }
        String nombreAlumno=alumnos.get(i);
        holder.nameTextView.setText(nombreAlumno);
        holder.number.setText("N "+alumnos.getNumero);
        return v;
    }
    static class ViewHolder{
        private TextView nameTextView;
        private TextView numero;
    }


}
