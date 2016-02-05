package com.example.carlosmc.facultades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class FcDetail extends AppCompatActivity{

    private static final String EXTRA_NAME = "com.example.carlosmc.facultades.name";
    private static final String EXTRA_DRAWABLE = "com.example.carlosmc.facultades.drawable";

    protected static int[] imagefc = {
            R.drawable.ifisica,R.drawable.quimica,R.drawable.fisica,
            R.drawable.matematica,R.drawable.cc
    };
    String[] titulo;

    private ListView lista;
    ListViewAdapter adapter;
    int currentViewPager;
    String nombreEscuelafc;

    public static void createInstance(Activity activity, Facus title){
        Intent intent = getLaunchIntent(activity, title);
        activity.startActivity(intent);
    }

    public static Intent getLaunchIntent(Context context, Facus facu) {
        Intent intent = new Intent(context, FcDetail.class);
        intent.putExtra(EXTRA_NAME, facu.getName());
        intent.putExtra(EXTRA_DRAWABLE, facu.getIdDrawable());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc);

        //escuelas = (CardView)findViewById(R.id.escuelitas);

        setToolbar();
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        String name = i.getStringExtra(EXTRA_NAME);
        int idDrawable = i.getIntExtra(EXTRA_DRAWABLE, -1);

        CollapsingToolbarLayout collapser = (CollapsingToolbarLayout)findViewById(R.id.collapser);
        collapser.setTitle(name);

        loadImageParallax(idDrawable);

        lista = (ListView) findViewById(R.id.list_escuelas);

        titulo = getResources().getStringArray(R.array.escuelas_fc);
        adapter = new ListViewAdapter(this,imagefc,titulo);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("idescuela",currentViewPager);
                i.putExtra("position",position);

                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadImageParallax(int id){
        ImageView image = (ImageView)findViewById(R.id.image_paralax);
        Glide.with(this).load(id).centerCrop().into(image);
    }

    private void showSnackBar(String msg){
        Snackbar.make(findViewById(R.id.coordinator), msg, Snackbar.LENGTH_LONG).show();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings:
                showSnackBar("Se abren los ajustes");
                return true;
            case R.id.action_add:
                showSnackBar("AÃ±adir a ...");
                return true;
            case R.id.action_favorite:
                showSnackBar("AÃ±adir a favoritos");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    public class ListViewAdapter extends BaseAdapter {
        Context context;
        int[] imagenes;
        String[] titulos;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, int[] imagenes,String[] titulos){
            this.context = context;
            this.imagenes = imagenes;
            this.titulos = titulos;
        }

        @Override
        public int getCount() {return titulos.length;}

        @Override
        public Object getItem(int position) {return null;}

        @Override
        public long getItemId(int position) {return 0;}

        public View getView(int position,View convertView,ViewGroup parent){
            ImageView imgImg;
            TextView txtTitle;

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.fragment_fc,parent,false);

            imgImg = (ImageView) itemView.findViewById(R.id.imagen_ifisica);
            txtTitle = (TextView) itemView.findViewById(R.id.titulo_ifisica);

            imgImg.setImageResource(imagenes[position]);
            txtTitle.setText(titulos[position]);

            return itemView;
        }
    }

}
