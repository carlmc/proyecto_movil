package com.example.carlosmc.facultades;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FieeDetail extends AppCompatActivity{

    private static final String EXTRA_NAME = "com.example.carlosmc.facultades.name";
    private static final String EXTRA_DRAWABLE = "com.example.carlosmc.facultades.drawable";

    public static void createInstance(Activity activity, Facus title){
        Intent intent = getLaunchIntent(activity, title);
        activity.startActivity(intent);
    }

    public static Intent getLaunchIntent(Context context, Facus facu) {
        Intent intent = new Intent(context, FieeDetail.class);
        intent.putExtra(EXTRA_NAME, facu.getName());
        intent.putExtra(EXTRA_DRAWABLE, facu.getIdDrawable());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiee);

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


    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadImageParallax(int id){
        ImageView image = (ImageView)findViewById(R.id.image_paralax);
        Glide.with(this).load(id).centerCrop().into(image);
    }
}
