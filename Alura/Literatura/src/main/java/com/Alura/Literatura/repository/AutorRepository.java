package com.Alura.Literatura.repository;

import com.Alura.Literatura.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreIgnoreCase(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.anoNacimiento <= :ano AND (a.anoMuerte IS NULL OR a.anoMuerte >= :ano)")
    List<Autor> findAutoresVivosEnAno(@Param("ano") Integer ano);
}
