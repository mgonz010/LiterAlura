package com.desafio.alura.Literalura.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") String id,
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer download
) {

}
