package com.example.android.autosmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 21/10/2017.
 */

public class AdaptadorAuto extends RecyclerView.Adapter<AdaptadorAuto.AutoViewHolder> {
    private ArrayList<Auto> Autos;
    private Resources res;
    private OnAutoClickListener clickListener;

    public AdaptadorAuto(Context contexto, ArrayList<Auto> Autos, OnAutoClickListener clickListener){
        this.Autos=Autos;
        res = contexto.getResources();
        this.clickListener=clickListener;
    }

    @Override
    public AutoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new AutoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AutoViewHolder holder, int position) {
        final Auto p = Autos.get(position);
        holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res,p.getFoto(),null));
        holder.placa.setText(p.getPlaca());
        holder.marca.setText(p.getMarca());
        holder.modelo.setText(p.getModelo());
        holder.Precio.setText(p.getPrecio());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onAutoClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Autos.size();
    }

    public static class AutoViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView marca;
        private TextView modelo;
        private TextView Precio;
        private View v;

        public AutoViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = (ImageView)itemView.findViewById(R.id.imgFoto);
            placa = (TextView)itemView.findViewById(R.id.lblPlaca);
            marca = (TextView)itemView.findViewById(R.id.lblMarca);
            modelo =(TextView)itemView.findViewById(R.id.lblModelo);
            Precio =(TextView)itemView.findViewById(R.id.lblPrecio);
        }
    }

    public interface OnAutoClickListener {
        void onAutoClick(Auto p);
    }
}