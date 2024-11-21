package com.desafio.alura.Literatura.principal;

import com.desafio.alura.Literatura.Repositorio.LibrosRepository;
import com.desafio.alura.Literatura.modelo.Datos;
import com.desafio.alura.Literatura.modelo.DatosLibros;
import com.desafio.alura.Literatura.modelo.Libros;
import com.desafio.alura.Literatura.service.ConsumoAPI;
import com.desafio.alura.Literatura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {
    private final LibrosRepository repositorio;
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();

    @Autowired
    public Principal(LibrosRepository repositorio) {
        this.repositorio = repositorio;
    }


    public void muestraMenu() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    
                    =================================================
                    ===========   L I T E R A L U R A  ==============
                    =================================================
                    =================================================
                    ===== REGISTRO DE LIBROS EN LA BASE DE DATOS ====
                    ==  1 - Buscar Libro por titulo - Api GutenDex ==
                    =================================================
                    =================================================
                    ===== CONSULTA DE LIBROS EN LA BASE DE DATOS ====
                    ==  2 - Listar Libros registrados.             ==
                    ==  3 - Listar Autores registrados.            ==
                    ==  4 - Listar Autores vivos por año.          ==
                    ==  5 - Listar Libros por IDIOMA.              ==
                    ==                                             ==
                    ==  0 - Salir                                  ==
                    =================================================
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscaLibros();
                    break;
                case 2:
                    buscaLibros();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opcion no Valida...");
            }
        }
    }


    //Busqueda de libros por nombre
    private Optional<DatosLibros> getDatosLibros() {
        System.out.println("Ingrese el nombre del Libro que desea BUSCAR");
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            System.out.println("Libro Encontrado : ");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro NO Encontrado");
        }

        return libroBuscado;
    }

    private void buscaLibros() {
        Optional<DatosLibros> datos = getDatosLibros();
        if (datos.isPresent()) {
            Libros libro = new Libros(datos);
            repositorio.save(libro);
            System.out.println("Libro guardado exitosamente: " + libro.getTitulo());
        }
    }


}