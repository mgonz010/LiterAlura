package com.desafio.alura.Literalura.Repository;


import com.desafio.alura.Literalura.persistencia.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.lenguaje >= :idioma")
    List<Libro> findForLanguaje(String idioma);

}
