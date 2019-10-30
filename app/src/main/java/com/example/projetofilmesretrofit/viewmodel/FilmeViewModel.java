package com.example.projetofilmesretrofit.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projetofilmesretrofit.model.Filme;
import com.example.projetofilmesretrofit.repository.FilmeRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FilmeViewModel extends AndroidViewModel {
    private MutableLiveData<List<Filme>> listafilme = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeRepository repository = new FilmeRepository();





    public LiveData<List<Filme>> getListaFilme(){
        return this.listafilme;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getAllFilmes(String apiKey){
        disposable.add(
                repository.getFilmes(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn((AndroidSchedulers.mainThread()))
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .doOnTerminate(() -> loading.setValue(false))
                .subscribe(filmeResult -> {
                    listafilme.setValue(filmeResult.getFilmes());
                },
                        throwable ->{
                    Log.i ("LOG", "erro" + throwable.getMessage());
                        })
        );

    }

    public FilmeViewModel(@NonNull Application application) {
        super(application);
    }
}
