package com.desafio.alura.Literatura.principal;

import com.desafio.alura.Literatura.modelo.Datos;
import com.desafio.alura.Literatura.modelo.DatosLibros;
import com.desafio.alura.Literatura.repository.AutorRepository;
import com.desafio.alura.Literatura.service.ConsumoAPI;
import com.desafio.alura.Literatura.service.ConvierteDatos;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private Scanner teclado = new Scanner(System.in);
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";


    public void muestraMenu() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    
                    =================================================
                    ===========   L I T E R A L U R A  ==============
                    =================================================
                    
                    ===== REGISTRO DE LIBROS EN LA BASE DE DATOS ====
                    ==  1 - Buscar Libro por titulo - Api GutenDex ==
                    
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
                    buscarLibroWeb();
                    break;
                case 2:
                    listaLibrosRegistrados();
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

    //Top 10 libros mas Descargados

    private void buscarLibroWeb() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        //System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        //System.out.println(datos);

        //Top 10 libros mas Descargados
        System.out.println("Top 10 libros mas Descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescarga).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

    }

    //Busqueda de libros por nombre
    private void listaLibrosRegistrados() {
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
    }


}