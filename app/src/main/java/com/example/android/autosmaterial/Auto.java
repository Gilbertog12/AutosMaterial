package com.example.android.autosmaterial;

/**
 * Created by android on 21/10/2017.
 */

public class Auto {
    private String id;
    private int foto;
    private String Placa;
    private int Marca;
    private int Modelo;
    private int Color;
    private String Precio ;

    public Auto(String id, int foto, String placa,int marca, int modelo, int color, String precio) {
        this.id = id;
        this.foto = foto;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Color = color;
        Precio = precio;
    }
    public Auto(int foto, String placa,int marca, int modelo, int color, String precio) {

        this.foto = foto;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Color = color;
        Precio = precio;
    }


    public Auto(String id){
        this.id=id;
    }



    public Auto(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public int getMarca() {
        return Marca;
    }

    public void setMarca(int marca) {
        Marca = marca;
    }

    public  void eliminar(Auto p){
        Datos.eliminarAuto(this);
    }

    public void editar(){
        Datos.editarAuto(this);
    }

    public void guardar() {
        Datos.guardarAuto(this);
    }
}
