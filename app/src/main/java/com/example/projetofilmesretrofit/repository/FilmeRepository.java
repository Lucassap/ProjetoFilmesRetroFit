package com.example.projetofilmesretrofit.repository;

import com.example.projetofilmesretrofit.model.FilmeResult;

import io.reactivex.Observable;

import static com.example.projetofilmesretrofit.data.remote.RetrofitService.getApiService;

public class FilmeRepository {

    public Observable<FilmeResult> getFilmes(String apiKey){
        return getApiService().getAllFilmes(apiKey);
    }
}
