package com.example.carlosmc.facultades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class SimpleAdaptador extends RecyclerView.Adapter<SimpleAdaptador.SimpleViewHolder> implements
        ItemClickListener{
    private static Context context;
    private List<Facus> items;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        public TextView nombre;
        public ImageView avatar;
        public ItemClickListener listener;

        public SimpleViewHolder(View v,ItemClickListener listener){
            super(v);
            nombre = (TextView)v.findViewById(R.id.list_item_textview);
            avatar = (ImageView)v.findViewById(R.id.avatar);
            context = itemView.getContext();
            this.listener = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){

            listener.onItemClick(v,getAdapterPosition());
        }
    }

    public SimpleAdaptador(Context context, List<Facus> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new SimpleViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder viewHolder,int i){
        Facus current = items.get(i);
        viewHolder.nombre.setText(current.getName());
        Glide.with(viewHolder.avatar.getContext()).load(
                current.getIdDrawable()).centerCrop().into(viewHolder.avatar);
        //viewHolder.avatar.setImageResource(current.getIdDrawable());
    }

    @Override
    public void onItemClick(View view,int position){
        Intent intent;
        switch (position){
            case 0:
                FauaDetail.createInstance((Activity) context, items.get(position));
                break;
            case 1:
                FcDetail.createInstance((Activity) context, items.get(position));
                /*intent = new Intent(context,FcDetail.class);
                context.startActivity(intent);*/
                break;
            case 2:
                FiaDetail.createInstance((Activity) context,items.get(position));
                break;
            case 3:
                FicDetail.createInstance((Activity) context,items.get(position));
                break;
            case 4:
                FiecsDetail.createInstance((Activity) context,items.get(position));
                break;
            case 5:
                FieeDetail.createInstance((Activity) context,items.get(position));
                break;
            case 6:
                FigmmDetail.createInstance((Activity) context,items.get(position));
                break;
            case 7:
                FiisDetail.createInstance((Activity) context,items.get(position));
                break;
            case 8:
                FimDetail.createInstance((Activity) context,items.get(position));
                break;
            case 9:
                FipDetail.createInstance((Activity) context,items.get(position));
                break;
            case 10:
                fiqtDetail.createInstance((Activity) context,items.get(position));
                break;
            default:
                intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
                break;
        }

    }



}

interface ItemClickListener{
    void onItemClick(View view,int position);
}

