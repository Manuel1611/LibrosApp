package com.example.librosapp.model.laravel;

import com.example.librosapp.model.pojo.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LibroClient {

    @DELETE("libro/{id}")
    Call<Boolean> deleteLibro(@Path("id") long id);

    @GET("libro/{id}")
    Call<Libro> getLibroById(@Path("id") long id);

    @GET("libro")
    Call<List<Libro>> getAllLibros();

    @POST("libro")
    Call<Long> postLibro(@Body Libro libro);

    @PUT("libro/{id}")
    Call<Boolean> putLibro(@Path("id") long id, @Body Libro libro);

}