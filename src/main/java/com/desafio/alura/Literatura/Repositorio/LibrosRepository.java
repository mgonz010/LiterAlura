package com.desafio.alura.Literatura.Repositorio;

import com.desafio.alura.Literatura.modelo.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long> {
    // Corregir nombres de métodos
    List<Libros> findByIdiomas(String idiomas);
    List<Libros> findByNombre(String nombre);

    @Query("SELECT DISTINCT l.nombre FROM Libros l")
    List<String> findAllAuthors();

    @Query("SELECT l FROM Libros l WHERE SUBSTRING(l.fechaDeNacimiento, 1, 4) > :year")
    List<Libros> findAuthorsAliveAfterYear(int year);
}
