package com.example.projetofilmesretrofit.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.projetofilmesretrofit.R;
import com.example.projetofilmesretrofit.model.Result;
import com.example.projetofilmesretrofit.view.adapter.AdapterFilme;
import com.example.projetofilmesretrofit.viewmodel.FilmeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    AdapterFilme adapterFilme;
    private List<Result> listaResults = new ArrayList<>();
    private FilmeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapterFilme);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getAllFilmes("bde8033d3274c91b292a5293c6349052");
        viewModel.getListaFilme().observe(this, resultaLista-> {
            adapterFilme.atualizarLista(resultaLista);
        });
    }

     void initViews(){
        recyclerView = findViewById(R.id.recyclerViewFilmes);
        progressBar = findViewById(R.id.progress_bar);
        adapterFilme = new AdapterFilme(listaResults);
        viewModel = ViewModelProviders.of(this).get(FilmeViewModel.class);

     }
}
