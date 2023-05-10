package com.example.productos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TableLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbProductos extends DbHelper{

    Context context;

    public DbProductos(Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProducto(String nombre, String cantidad, String precio, String lugar, String categoria){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("cantidad", cantidad);
            values.put("precio", precio);
            values.put("lugar", lugar);
            values.put("categoria", categoria);

            id = db.insert(TABLA_PRODUCTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Productos> mostrarProductos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos productos = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM " + TABLA_PRODUCTOS, null);

        if (cursorProductos.moveToFirst()){
            do{
                productos = new Productos();
                productos.setId(cursorProductos.getInt(0));
                productos.setNombre(cursorProductos.getString(1));
                productos.setCantidad(cursorProductos.getString(2));
                productos.setPrecio(cursorProductos.getString(3));
                productos.setLugar(cursorProductos.getString(4));
                productos.setCategoria(cursorProductos.getString(5));

                listaProductos.add(productos);
            }while(cursorProductos.moveToNext());
        }
        cursorProductos.close();
        return listaProductos;
    }
}
