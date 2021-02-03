package com.example.librosapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Libro {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("titulo")
    @Expose
    private String titulo;

    @SerializedName("editorial")
    @Expose
    private String editorial;

    @SerializedName("paginas")
    @Expose
    private long paginas;

    @SerializedName("autor")
    @Expose
    private String autor;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("numVentas")
    @Expose
    private int numVentas;

    public Libro(long id, String titulo, String editorial, long paginas, String autor, String url, int numVentas) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
        this.autor = autor;
        this.url = url;
        this.numVentas = numVentas;
    }

    public Libro(String titulo, String editorial, long paginas, String autor, String url, int numVentas) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
        this.autor = autor;
        this.url = url;
        this.numVentas = numVentas;
    }

    public Libro(String titulo, String editorial, long paginas, String autor, String url) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.paginas = paginas;
        this.autor = autor;
        this.url = url;
    }

    public Libro() {

        this(0, "", "", 0, "", "", 0);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public long getPaginas() {
        return paginas;
    }

    public void setPaginas(long paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", url='" + url + '\'' +
                ", numVentas=" + numVentas +
                '}';
    }
}