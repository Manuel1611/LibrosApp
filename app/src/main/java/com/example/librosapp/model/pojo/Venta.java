package com.example.librosapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venta {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("idlibro")
    @Expose
    private long idlibro;

    @SerializedName("precio")
    @Expose
    private double precio;

    public Venta(long id, long idlibro, double precio) {
        this.id = id;
        this.idlibro = idlibro;
        this.precio = precio;
    }

    public Venta(long idlibro, double precio) {
        this.idlibro = idlibro;
        this.precio = precio;
    }

    public Venta() {

        this(0, 0, 0);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(long idlibro) {
        this.idlibro = idlibro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", idlibro=" + idlibro +
                ", precio=" + precio +
                '}';
    }

}