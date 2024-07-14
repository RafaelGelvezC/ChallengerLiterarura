package com.Alura.Literatura.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    private double numeroDescargas;

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    public Libros() {}

    public Libros(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idioma = Idioma.fromString(datosLibros.idiomas().get(0));
        this.numeroDescargas = datosLibros.numeroDescargas();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id).append("\n")
                .append("Libro: ").append(titulo).append("\n")
                .append("Idioma: ").append(idioma).append("\n")
                .append("Numero de Descargas: ").append(numeroDescargas).append("\n")
                .append("Autor: ").append(autor.getNombre()).append("\n")
                .append("Fecha de nacimiento: ").append(autor.getAnoNacimiento()).append("\n")
                .append("Fecha de muerte: ").append(autor.getAnoMuerte());
        return sb.toString();
    }
}