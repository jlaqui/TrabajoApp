package com.proyectofinal.trabajoseguro.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DataCategoria {
    private Context context;
    public  DataCategoria (Context context){
        this.context=context;
    }
    public String[] listaCategorias(){
        //ArrayList<Categoria> categorias =new ArrayList<>();
        ArrayList<String> categorias= new ArrayList<>();
        ArrayList<String> empresas= new ArrayList<>();
        ConexionSQLite conn= new ConexionSQLite(context, "bd_trabajaseguro", null, 1, null);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT*FROM Categoria ", null);
        while(cursor.moveToNext()){
              categorias.add(cursor.getString(1));
        }
/*
        cursor = db.rawQuery(" SELECT*FROM usuarios ", null);
        while(cursor.moveToNext()){
            empresas.add(cursor.getString(1));
        }
        for (int i = 0; i < empresas.size(); ++i) {
            Log.i("Usuario ", empresas.get(i));
        }*/

        db.close();

        return categorias.toArray(new String[categorias.size()]);
    }
}
