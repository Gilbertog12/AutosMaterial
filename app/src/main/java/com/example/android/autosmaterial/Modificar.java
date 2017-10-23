package com.example.android.autosmaterial;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Modificar extends AppCompatActivity {

    private EditText txtPlacaam, txtPreciom;
    private TextInputLayout cajaPlacam, cajaPreciom;
    private ArrayList<Integer> fotos;
    private Resources res;
    private Spinner Marcam;
    private Spinner Modelom;
    private Spinner Colorm;
    private int foto, marca,modelo,color;
    private ArrayAdapter<String> adapter;
    private String[] opcm;
    private Bundle bundle, b3;
    private Intent i;
    private String placa, precio,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        txtPlacaam = (EditText) findViewById(R.id.txtPlacam);
        txtPreciom = (EditText) findViewById(R.id.txtPreciom);


        res = this.getResources();
        cajaPlacam = (TextInputLayout) findViewById(R.id.cajaPlacam);
        cajaPreciom = (TextInputLayout) findViewById(R.id.cajaPreciom);

        Colorm = (Spinner) findViewById(R.id.cmbColorm);
        opcm = res.getStringArray(R.array.Colores);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opcm);
        Colorm.setAdapter(adapter);

        Modelom = (Spinner) findViewById(R.id.cmbModelom);
        opcm = res.getStringArray(R.array.Modelos);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opcm);
        Modelom.setAdapter(adapter);

        Marcam = (Spinner) findViewById(R.id.cmbColorm);
        opcm = res.getStringArray(R.array.Marcas);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opcm);
        Marcam.setAdapter(adapter);


        i = getIntent();
        bundle = i.getBundleExtra("datos");
        id= bundle.getString("id");
        foto = bundle.getInt("foto");
        placa = bundle.getString("placa");
        marca = bundle.getInt("marca");
        modelo = bundle.getInt("modelo");
        color = bundle.getInt("color");
        precio = bundle.getString("precio");
        txtPlacaam.setText(placa);
        Marcam.setSelection(marca);
        Modelom.setSelection(modelo);
        Colorm.setSelection(color);
        txtPreciom.setText(precio);



    }

    public void editar(View v){
        if (validarm()){
            Auto p = new Auto(id,foto,txtPlacaam.getText().toString(), Marcam.getSelectedItemPosition(),Modelom.getSelectedItemPosition(),Colorm.getSelectedItemPosition(),txtPreciom.getText().toString());
            p.editar();
            Snackbar.make(v, res.getString(R.string.mensaje_guardado), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            onBackPressedE();
        }
    }

    public boolean validarm(){
        if (validar_auxE(txtPlacaam, cajaPlacam)) return false;

        else if (Metodos.persona_editar(Datos.obtenerPersonas(), txtPlacaam.getText().toString(),placa)) {
            txtPlacaam.setError(res.getString(R.string.persona_existente_error));
            txtPlacaam.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validar_auxE(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError("No puede ser vacio");
            return true;
        }
        return false;
    }

    public void onBackPressedE(){
        Intent i = new Intent(this, DetalleAuto.class);
        Bundle b3 = new Bundle();
        b3.putString("id",id);
        b3.putInt("foto",foto);
        b3.putString("cedula", txtPlacaam.getText().toString());
        b3.putInt("Marca", Marcam.getSelectedItemPosition());
        b3.putInt("Modelo", Modelom.getSelectedItemPosition());
        b3.putInt("Color", Colorm.getSelectedItemPosition());
        b3.putString("Precio", txtPreciom.getText().toString());

        i.putExtra("datos",b3);
        startActivity(i);
    }
    }

