package com.example.carlosmc.appuni;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;


public class fragment_detalle_stand extends Fragment {

    String stand;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_stand, container, false);
        ((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar)v.findViewById(R.id.toolbar));
        if(((AppCompatActivity)getActivity()).getSupportActionBar() != null)
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, (Toolbar)v.findViewById(R.id.toolbar), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        stand=getArguments().getString("layout");
        CollapsingToolbarLayout collapser = (CollapsingToolbarLayout)v.findViewById(R.id.collapser);
        collapser.setTitle(stand.toUpperCase());
        ((TextView) v.findViewById(R.id.nombre_stand)).setText(getResources().getString(getResources().getIdentifier("nombre_stand_" + stand, "string", getActivity().getPackageName())));
        ((TextView) v.findViewById(R.id.info_stand)).setText(getResources().getString(getResources().getIdentifier("info_stand_" + stand, "string", getActivity().getPackageName())));
        loadImageParallax(v, getResources().getIdentifier(stand, "drawable", getActivity().getPackageName()));
        v.findViewById(R.id.irstand).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(getResources().getIdentifier("pagina_stand_" + stand, "string", getActivity().getPackageName()))));
                startActivity(intent);

            }
        });
        return v;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, RadioGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    private void loadImageParallax(View v,int id){
        ImageView image = (ImageView)v.findViewById(R.id.image_paralax);
        image.setImageResource(id);
    }
}
