package com.desafio.alura.Literatura.modelo;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "libros")

public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;
    private String nombre;
    private String idiomas;
    private Double numeroDeDescarga;
    private String fechaDeNacimiento;

    public Libros(Optional<DatosLibros> datos) {
        if (datos.isPresent()) {
            DatosLibros libro = datos.get();
            this.titulo = libro.titulo();
            this.nombre = libro.autor().isEmpty() ? "Autor Desconocido" : libro.autor().get(0).nombre();
            this.idiomas = libro.idiomas().isEmpty() ? "Idioma Desconocido" : libro.idiomas().get(0);
            this.numeroDeDescarga = libro.numeroDeDescarga();
            this.fechaDeNacimiento = libro.autor().isEmpty() ? "Fecha Desconocida" : libro.autor().get(0).fechaDeNacimiento();
        }
    }

    @Override
    public String toString() {
        return
                "Id=" + Id +
                        ", titulo='" + titulo + '\'' +
                        ", nombre='" + nombre + '\'' +
                        ", idiomas='" + idiomas + '\'' +
                        ", numeroDeDescarga=" + numeroDeDescarga +
                        ", fechaDeNacimiento='" + fechaDeNacimiento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescarga() {
        return numeroDeDescarga;
    }

    public void setNumeroDeDescarga(Double numeroDeDescarga) {
        this.numeroDeDescarga = numeroDeDescarga;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

}



