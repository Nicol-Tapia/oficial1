package com.example.productos;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductosViewHolder>{

    ArrayList<Productos> listaProductos;
    public ListaProductosAdapter(ArrayList<Productos> listaProductos){
        this.listaProductos = listaProductos;
    }
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_productos,null,false);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaProductosAdapter.ProductosViewHolder holder, int position) {
        holder.viewNombre.setText(listaProductos.get(position).getNombre());
        holder.viewCantidad.setText(listaProductos.get(position).getCantidad());
        holder.viewPrecio.setText(listaProductos.get(position).getPrecio());
        holder.viewLugar.setText(listaProductos.get(position).getLugar());
        holder.viewCategoria.setText(listaProductos.get(position).getCategoria());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewCantidad, viewPrecio, viewLugar, viewCategoria;
        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCantidad = itemView.findViewById(R.id.viewCantidad);
            viewPrecio = itemView.findViewById(R.id.viewPrecio);
            viewLugar = itemView.findViewById(R.id.viewLugar);
            viewCategoria = itemView.findViewById(R.id.viewCategoria);
        }
    }
}

