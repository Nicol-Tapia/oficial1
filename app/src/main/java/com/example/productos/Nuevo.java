package com.example.productos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Nuevo extends AppCompatActivity {
    EditText txtNombre, txtCantidad, txtPrecio, txtLugar, txtCategoria;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtLugar = findViewById(R.id.txtLugar);
        txtCategoria = findViewById(R.id.txtCategoria);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProductos dbProductos = new DbProductos(Nuevo.this);
                long id = dbProductos.insertarProducto(txtNombre.getText().toString(), txtCantidad.getText().toString(), txtPrecio.getText().toString(), txtLugar.getText().toString(), txtCategoria.getText().toString()
                );
                
                if(id>0){
                    Toast.makeText(Nuevo.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(Nuevo.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(Nuevo.this, ListaProductos.class);
                startActivity(i);

            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtLugar.setText("");
        txtCategoria.setText("");

    }
    
}
