package com.example.android.autosmaterial;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleAuto extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Auto p;
    private String placa,precio,id;
    private int fot,modelo,marca,color;
    private Bundle bundle;
    private Intent i;
    private ImageView foto;
    private Resources res;
    private TextView plc,marc,mod,prec;
    private String [] opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_auto);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        plc =(TextView)findViewById(R.id.lblPlacaD);
        marc = (TextView)findViewById(R.id.lblMarcaD);
        mod = (TextView)findViewById(R.id.lblModeloD);
        prec = (TextView)findViewById(R.id.lblPrecioD);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        foto = (ImageView) findViewById(R.id.fotoAuto);
        res = this.getResources();
        i = getIntent();
        bundle = i.getBundleExtra("datos");
        id = bundle.getString("id");
        placa = bundle.getString("placa");
        marca = bundle.getInt("marca");
        modelo = bundle.getInt("modelo");
        fot = bundle.getInt("foto");
        precio = bundle.getString("precio");




        collapsingToolbarLayout.setTitle(placa+" "+modelo);
        foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
        plc.setText(placa);
        mod.setText(modelo);


    }
    public void editar(View v){
        Intent i = new Intent(DetalleAuto.this, Modificar.class);
        Bundle b2 = new Bundle();
        b2.putString("id",id);
        b2.putInt("foto",fot);

         i.putExtra("datos",b2);
        startActivity(i);
    }

  /*  public void eliminar(View v){
        String positivo,negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_eliminar_mensaje));
        builder.setMessage(res.getString(R.string.eliminar_mensaje));
        positivo = res.getString(R.string.si_eliminar_mensaje);
        negativo = res.getString(R.string.no_eliminar_mensaje);



        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Persona p = new Persona(id);
                Datos.eliminarPersona(p);
                onBackPressed();

            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();



    }*/
    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetalleAuto.this,Principal.class);
        startActivity(i);
    }
    }

