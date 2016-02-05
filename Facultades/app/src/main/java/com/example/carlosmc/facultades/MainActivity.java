package com.example.carlosmc.facultades;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private LinearLayoutManager lManager;
    private CollapsingToolbarLayout collapser;
    private List<Facus> facus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iniciaDatos();

        SimpleAdaptador adaptador = new SimpleAdaptador(this,facus);

        //obtener recycler
        recycler = (RecyclerView)findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        //usar administrador para linearLayout}
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        recycler.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void iniciaDatos(){
        facus = new ArrayList<>();
        facus.add(new Facus("FAUA",R.drawable.faua));
        facus.add(new Facus("FC",R.drawable.fc));
        facus.add(new Facus("FIA",R.drawable.fia));
        facus.add(new Facus("FIC",R.drawable.fic));
        facus.add(new Facus("FIECS",R.drawable.fiecs));
        facus.add(new Facus("FIEE",R.drawable.fiee));
        facus.add(new Facus("FIGMM",R.drawable.figmm));
        facus.add(new Facus("FIIS",R.drawable.fiis));
        facus.add(new Facus("FIM",R.drawable.fim));
        facus.add(new Facus("FIP",R.drawable.fip));
        facus.add(new Facus("FIQT",R.drawable.fiqt));
    }
}
