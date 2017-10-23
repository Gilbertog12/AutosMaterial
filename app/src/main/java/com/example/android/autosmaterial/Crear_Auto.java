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
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.autosmaterial.R.id.cmbColor;
import static com.example.android.autosmaterial.R.id.txtPlaca;
import static com.example.android.autosmaterial.R.id.txtprecio;

public class Crear_Auto extends AppCompatActivity {

    private EditText Placa,Precio;
    private TextInputLayout cajaPlaca;
    private TextInputLayout cajaPrecio;
    private Resources res;
    private Spinner Marca;
    private  Spinner Modelo;
    private  Spinner Color;
    private  String [] Marcas;
    private  String [] Modelos;
    private  String [] Colores;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__auto);

        Placa = (EditText)findViewById(txtPlaca);
        Precio = (EditText)findViewById(R.id.txtPrecio);
        Marca = (Spinner)findViewById(R.id.cmbMarca);
        Modelo = (Spinner)findViewById(R.id.cmbModelo);
        Color = (Spinner)findViewById(R.id.cmbColor);
        cajaPrecio = (TextInputLayout) findViewById(R.id.cajaPrecio);
        cajaPlaca = (TextInputLayout)findViewById(R.id.cajaPlaca);
        res = this.getResources();


        fotos = new ArrayList<>();
        fotos.add(R.drawable.imagen1);
        fotos.add(R.drawable.imagen2);
        fotos.add(R.drawable.imagen3);
        fotos.add(R.drawable.imagen4);

        Marcas =res.getStringArray(R.array.Marcas);
        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Marcas);
        Marca.setAdapter(adapter1);

        Modelos =res.getStringArray(R.array.Modelos);
        ArrayAdapter<String>Adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Modelos);
        Modelo.setAdapter(Adapter);

        Colores =res.getStringArray(R.array.Colores);
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Colores);
        Color.setAdapter(adapter2);}







    public void guadar(View v){

        if(validar()) {
            Auto p = new Auto(Metodos.fotoAleatoria(fotos),Placa.getText().toString(),
                    Marca.getSelectedItemPosition(), Modelo.getSelectedItemPosition(), Color.getSelectedItemPosition(),Precio.getText().toString());
            p.guardar();
            Snackbar.make(v, res.getString(R.string.mensaje_guardado), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            limpiar();
        }
    }
    public void limpiar(View v){
        limpiar();
    }

    private void limpiar(){
        Placa.setText("");
        Modelo.setSelection(0);
        Marca.setSelection(0);

        Color.setSelection(0);
        Precio.setText("");
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(Crear_Auto.this,Principal.class);
        startActivity(i);
    }
    public boolean validar(){
        if (validar_aux(Placa,cajaPlaca)) return false;

        else if (Metodos.existencia_persona(Datos.obtenerPersonas(),Placa.getText().toString())){
            Placa.setError(res.getString(R.string.persona_existente_error));
            Placa.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validar_aux(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(res.getString(R.string.no_vacio_error));
            return true;
        }
        return false;
    }




}

