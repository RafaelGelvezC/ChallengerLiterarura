package com.Alura.Literatura.repository;

import com.Alura.Literatura.modelo.Libros;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {
    private final List<Libros> libros = new ArrayList<>();

    public void guardar(Libros libro) {
        libros.add(libro);
    }

    public List<Libros> listar() {
        return new ArrayList<>(libros);
    }
}
