package com.Alura.Literatura.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libros {
    private int id;
    private String titulo;
    private List<Autor> autores;
    private List<String> categoria;
    private List<String> idiomas;
    private Map<String, String> formato;
    private int downloadCount;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    @JsonAlias("title")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    @JsonAlias("authors")
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    @JsonAlias("subjects")
    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    @JsonAlias("languages")
    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Map<String, String> getFormato() {
        return formato;
    }

    @JsonAlias("formats")
    public void setFormato(Map<String, String> formato) {
        this.formato = formato;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    @JsonAlias("download_count")
    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", categoria=" + categoria +
                ", idiomas=" + idiomas +
                ", formato=" + formato +
                ", downloadCount=" + downloadCount +
                '}';
    }
}