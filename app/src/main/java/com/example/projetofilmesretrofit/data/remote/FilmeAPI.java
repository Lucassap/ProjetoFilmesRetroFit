package com.example.projetofilmesretrofit.data.remote;

import com.example.projetofilmesretrofit.repository.FilmeResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeAPI {
    @GET("movie/now_playing")
    Observable<FilmeResult> getAllFilmes(@Query("api_key") String apyKey);





}
