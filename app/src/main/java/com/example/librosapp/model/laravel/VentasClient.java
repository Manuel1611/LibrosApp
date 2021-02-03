package com.example.librosapp.model.laravel;

import com.example.librosapp.model.pojo.Venta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VentasClient {

    @DELETE("ventas/{id}")
    Call<Integer> deleteVenta(@Path("id") long id);

    @GET("ventas/{id}")
    Call<Venta> getVentaById(@Path("id") long id);

    @GET("ventas")
    Call<List<Venta>> getAllVentas();

    @POST("ventas")
    Call<Long> postVenta(@Body Venta venta);

    @PUT("ventas/{id}")
    Call<Integer> putVenta(@Path("id") long id, @Body Venta venta);

}