package com.example.librosapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.librosapp.model.Repository;
import com.example.librosapp.model.laravel.LibroClient;
import com.example.librosapp.model.laravel.VentasClient;
import com.example.librosapp.model.pojo.Libro;
import com.example.librosapp.model.pojo.Venta;

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

    public void insertarLibro(Libro libro) {

        repository.insertarLibro(libro);

    }

    public void insertarVenta(Venta venta, Libro libro) {

        repository.insertarVenta(venta, libro);

    }

    public void editarLibro(long id, Libro libro) {

        repository.editarLibro(id, libro);

    }

    public void eliminarLibro(long id) {

        repository.eliminarLibro(id);

    }

}