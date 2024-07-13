package com.Alura.Literatura.repository;

import com.Alura.Literatura.modelo.Autor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutorRepository {
    private final List<Autor> autores = new ArrayList<>();

    public void guardar(Autor autor) {
        autores.add(autor);
    }

    public List<Autor> listar() {
        return new ArrayList<>(autores);
    }

    public List<Autor> listarVivosEnAnio(int anio) {
        return autores.stream()
                .filter(autor -> (autor.getAnoNacimiento() <= anio) && (autor.getAnoMuerte() == 0 || autor.getAnoMuerte() >= anio))
                .collect(Collectors.toList());
    }
}
