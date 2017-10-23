package com.example.android.autosmaterial;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 21/10/2017.
 */

public class Metodos {

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public static boolean existencia_persona(ArrayList<Auto> Autos, String Placa){
        for (int i = 0; i <Autos.size() ; i++) {
            if(Autos.get(i).getPlaca().equals(Placa)){
                return true;
            }
        }
        return false;
    }
    public static boolean persona_editar(ArrayList<Auto> Autos, String cedulaE, String cedulaActual){

        if (!cedulaActual.equals(cedulaE)) {
            if (existencia_persona(Autos, cedulaE)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
