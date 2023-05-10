package com.example.productos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity{
    Button btnAgregar;
    RecyclerView listaProductos;
    ArrayList<Productos> listaArrayProductos;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_listaproductos);
        listaProductos = findViewById(R.id.listaproductosr);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbProductos dbProductos = new DbProductos(ListaProductos.this);
        listaArrayProductos = new ArrayList<>();

        ListaProductosAdapter adapter = new ListaProductosAdapter(dbProductos.mostrarProductos());
        listaProductos.setAdapter(adapter);

        btnAgregar = findViewById(R.id.btnagregarproducto);
        btnAgregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(ListaProductos.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(ListaProductos.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ListaProductos.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(ListaProductos.this, Nuevo.class);
                startActivity(i);
            }
        });
    }
}

