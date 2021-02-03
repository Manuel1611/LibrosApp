package com.example.librosapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.librosapp.model.Repository;
import com.example.librosapp.model.laravel.LibroClient;
import com.example.librosapp.model.laravel.VentasClient;
import com.example.librosapp.model.pojo.Libro;

public class ViewModel extends AndroidViewModel {

    private Repository repository;
    Libro libro;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);

    }

    public LibroClient getLibroClient(){
        return repository.getLibroClient();
    }

    public VentasClient getVentasClient(){
        return repository.getVentasClient();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}