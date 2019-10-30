package com.example.projetofilmesretrofit.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofilmesretrofit.R;
import com.example.projetofilmesretrofit.model.Filme;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFilme extends RecyclerView.Adapter<AdapterFilme.ViewHolder> {

    private List<Filme> listafilmes;

    public AdapterFilme(List<Filme> listafilmes) {
        this.listafilmes = listafilmes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filme filme = listafilmes.get(position);
        holder.onBind(filme);

    }

    public void atualizarLista(List<Filme> novaLista){
        this.listafilmes.clear();
        this.listafilmes = novaLista;
        notifyDataSetChanged();
    }




    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFilme);
            textView = itemView.findViewById(R.id.txtTitulo);
        }

        public void onBind(Filme filme) {
            textView.setText(filme.getTitle());

            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + filme.getPosterPath()).into(imageView);
        }
    }
}
