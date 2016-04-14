package com.example.carlosmc.appuni;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class fragment_stand extends Fragment {

    ListView listaStand;
    ArrayAdapter adaptador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lista_stands, container, false);
        ((Toolbar)v.findViewById(R.id.toolbar)).setTitle("stands");

        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, (Toolbar)v.findViewById(R.id.toolbar), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        listaStand = (ListView) v.findViewById(R.id.lista_stands);
        adaptador = new StandArrayAdapter(v.getContext(), DataStand.STANDS, this);
        listaStand.setAdapter(adaptador);

        listaStand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final BuildingStand item = (BuildingStand)adaptador.getItem(position);
                Bundle arguments = new Bundle();
                arguments.putString("layout", item.stand);
                android.support.v4.app.Fragment fragment = new fragment_detalle_stand();
                fragment.setArguments(arguments);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal, fragment).addToBackStack(null).commit();
            }
        });
        return v;
    }
}
