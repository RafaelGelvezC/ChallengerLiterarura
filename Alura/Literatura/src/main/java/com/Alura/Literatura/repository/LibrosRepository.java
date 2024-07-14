package com.Alura.Literatura.repository;

import com.Alura.Literatura.modelo.Idioma;
import com.Alura.Literatura.modelo.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long> {
    Optional<Libros> findByTituloIgnoreCase(String titulo);

    List<Libros> findByIdioma(Idioma idioma);
}
