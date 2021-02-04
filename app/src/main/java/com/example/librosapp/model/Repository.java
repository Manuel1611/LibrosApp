package com.example.librosapp.model;

import android.content.Context;

import com.example.librosapp.R;
import com.example.librosapp.model.laravel.LibroClient;
import com.example.librosapp.model.laravel.VentasClient;
import com.example.librosapp.model.pojo.Libro;
import com.example.librosapp.model.pojo.Venta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public void insertarLibro(Libro libro) {

        Call<Long> libroCall = libroClient.postLibro(libro);

        libroCall.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {

            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {

            }
        });

    }

    public void insertarVenta(Venta venta, Libro libro) {

        Call<Long> ventaCall = ventasClient.postVenta(venta);

        ventaCall.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {

                libro.setNumVentas(libro.getNumVentas() + 1);

                Call<Boolean> libroCall = libroClient.putLibro(libro.getId(), libro);

                libroCall.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {

            }
        });

    }

    public void editarLibro(long id, Libro libro2) {

        Call<Boolean> libroCall = libroClient.putLibro(id, libro2);

        libroCall.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });

    }

    public void eliminarLibro(long id) {

        Call<Boolean> libroCall = libroClient.deleteLibro(id);

        libroCall.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });

    }

}