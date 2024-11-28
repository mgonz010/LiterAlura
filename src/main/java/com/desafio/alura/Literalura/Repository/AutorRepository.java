package com.desafio.alura.Literalura.Repository;

import java.util.List;

import com.desafio.alura.Literalura.persistencia.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE :anio between a.fechaNacimiento AND a.fechaFallecimiento")
    List<Autor> findForYear(int anio);
}
