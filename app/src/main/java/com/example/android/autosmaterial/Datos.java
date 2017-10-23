package com.example.android.autosmaterial;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by android on 21/10/2017.
 */

public class Datos {

    private static String db = "autos";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Auto> Autos = new ArrayList();

    public static void guardarAuto(Auto p) {
        p.setId(databaseReference.push().getKey());
        databaseReference.child(db).child(p.getId()).setValue(p);



    }

    public static ArrayList<Auto> obtenerPersonas() {
        return Autos;
    }

    public static void setAutos(ArrayList<Auto> per) {
        Autos = per;
    }
    public static void editarAuto(Auto p){
        databaseReference.child(db).child(p.getId()).setValue(p);
        // personas.set(0,p);
    }
    public static void eliminarAuto(Auto p) {
        databaseReference.child(db).child(p.getId()).removeValue();

    }
}
