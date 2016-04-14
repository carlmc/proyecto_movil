package com.example.carlosmc.appuni;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StandArrayAdapter<T> extends ArrayAdapter<T> {
    Fragment fragmento;
    public StandArrayAdapter(Context context, List<T> objects, Fragment fragmento){
        super(context, 0, objects);
        this.fragmento=fragmento;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItemView = convertView;
        /*if (null == convertView) {
            listItemView = inflater.inflate(
                    R.layout.vista_edificio,
                    parent,
                    false);
        }*/

        //Obteniendo instancias de los elementos
        TextView titulo = (TextView)listItemView.findViewById(R.id.nombre);
        ImageView icono = (ImageView)listItemView.findViewById(R.id.icono);
        Button ver=(Button)listItemView.findViewById(R.id.ver);
        Button ir=(Button)listItemView.findViewById(R.id.ir);

        BuildingStand item = (BuildingStand) getItem(position);
        titulo.setText(item.nombres);
        icono.setImageResource( item.iconos);
        ver.setVisibility(View.GONE);
        ir.setVisibility(View.GONE);
        return listItemView;
    }
}
