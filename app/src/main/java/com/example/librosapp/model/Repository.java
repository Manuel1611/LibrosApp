package com.example.librosapp.model;

import android.content.Context;

import com.example.librosapp.model.laravel.LibroClient;
import com.example.librosapp.model.laravel.VentasClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    LibroClient libroClient;
    VentasClient ventasClient;

    public Repository(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://informatica.ieszaidinvergeles.org:9024/laraveles/librosApp/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        libroClient = retrofit.create(LibroClient.class);
        ventasClient = retrofit.create(VentasClient.class);

    }

    public LibroClient getLibroClient(){
        return libroClient;
    }

    public VentasClient getVentasClient(){
        return ventasClient;
    }

}