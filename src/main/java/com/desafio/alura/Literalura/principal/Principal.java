package com.desafio.alura.Literalura.principal;


import com.desafio.alura.Literalura.Repository.AutorRepository;
import com.desafio.alura.Literalura.Repository.LibroRepository;
import com.desafio.alura.Literalura.persistencia.Autor;
import com.desafio.alura.Literalura.persistencia.Libro;
import com.desafio.alura.Literalura.servicios.ConvierteDatos;
import com.desafio.alura.Literalura.modelo.Respuesta;
import com.desafio.alura.Literalura.servicios.ConsumoAPI;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepository libroRepositorio;
    private AutorRepository autorRepositorio;

    public Principal(LibroRepository libroRepositorio, AutorRepository autorRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void menu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    █████████████████████████████████████████████████
                    ████████████   L i t e r A l u r a  █████████████
                    ███████████████  MENU PRINCIPAL  ████████████████
                    █████████████████████████████████████████████████
                    █████ REGISTRO DE LIBROS EN LA BASE DE DATOS ████
                    ██  1 - Buscar Libro por titulo - Api GutenDex ██
                    █████████████████████████████████████████████████
                    █████████████████████████████████████████████████
                    █████ CONSULTA DE LIBROS EN LA BASE DE DATOS ████
                    ██  2 - Listar Libros registrados.             ██
                    ██  3 - Listar Autores registrados.            ██
                    ██  4 - Listar Autores vivos por año.          ██
                    ██  5 - Listar Libros por IDIOMA.              ██
                    ██                                             ██
                    ██  0 - Salir                                  ██
                    █████████████████████████████████████████████████
        			""";
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    buscarLibros();
                    break;
                case 3:
                    buscarAutores();
                    break;
                case 4:
                    buscarAutoresVivo();
                    break;
                case 5:
                    buscarPorIdiomas();
                    break;
                case 0:
                    System.out.println("Hasta pronto, saliendo de LiterAlura... \n");
                    break;
                default:
                    System.out.println("Opción inválida, ingrese nuevamente");
            }
        }

    }

    private void buscarLibros() {

        List<Libro> libros = libroRepositorio.findAll();

        if (!libros.isEmpty()) {
            System.out.println("\n████████████████████████████████████");
            System.out.println("████████ LIBROS REGISTRADOS ████████");
            System.out.println("████████████████████████████████████");
            for (Libro libro : libros) {
                System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println(" Titulo    : " + libro.getTitulo());
                System.out.println(" Autor     : " + libro.getAutor().getNombre());
                System.out.println(" Idioma    : " + libro.getLenguaje());
                System.out.println(" Descargas : " + libro.getDescargas());
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            }

        } else {
            System.out.println("███████ NO SE REGISTROS PARA LA OPCION SELECCIONADA ███████\n");
        }

    }

    private void buscarAutores() {
        List<Autor> autores = autorRepositorio.findAll();

        if (!autores.isEmpty()) {
            System.out.println("\n████████████████████████████████████");
            System.out.println("███████ AUTORES REGISTRADOS ████████");
            System.out.println("████████████████████████████████████");
            for (Autor autor : autores) {
                System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println(" Nombre              : " + autor.getNombre());
                System.out.println(" Fecha de Nacimiento : " + autor.getFechaNacimiento());
                System.out.println(" Fecha de Muerte     : " + autor.getFechaFallecimiento());
                System.out.println(" Libros              : " + autor.getLibros().getTitulo());
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            }
        } else {
            System.out.println("███████ NO SE REGISTROS PARA LA OPCION SELECCIONADA ███████\n");

        }

    }

    private void buscarAutoresVivo() {
        System.out.println("Escriba el año para en el que vivio: ");
        var anio = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorRepositorio.findForYear(anio);

        if (!autores.isEmpty()) {
            System.out.println("\n████████████████████████████████████");
            System.out.println("██████████ AUTORES VIVOS ███████████");
            System.out.println("████████████████████████████████████");
            for (Autor autor : autores) {
                System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println(" Nombre: " + autor.getNombre());
                System.out.println(" Fecha de nacimiento: " + autor.getFechaNacimiento());
                System.out.println(" Fecha de fallecimiento: " + autor.getFechaFallecimiento());
                System.out.println(" Libros: " + autor.getLibros().getTitulo());
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            }
        } else {
            System.out.println("███████ NO SE REGISTROS PARA LA OPCION SELECCIONADA ███████\n");

        }
    }

    private void buscarPorIdiomas() {

        var menu = """
				▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
				███████ Seleccione un Idioma ███████
				▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
				██████	 1.- Español  ██████████████
				██████	 2.- Ingles   ██████████████
				████████████████████████████████████
					""";
        System.out.println(menu);
        var idioma = teclado.nextInt();
        teclado.nextLine();

        String seleccion = "";

        if(idioma == 1) {
            seleccion = "es";
        } else 	if(idioma == 2) {
            seleccion = "en";
        }

        List<Libro> libros = libroRepositorio.findForLanguaje(seleccion);

        if (!libros.isEmpty()) {
            System.out.println("\n████████████████████████████████████");
            System.out.println("████████ LIBROS POR IDIOMAS ████████");
            System.out.println("████████████████████████████████████");
            for (Libro libro : libros) {
                System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                System.out.println(" Titulo   : " + libro.getTitulo());
                System.out.println(" Autor    : " + libro.getAutor().getNombre());
                System.out.println(" Idioma   : " + libro.getLenguaje());
                System.out.println(" Descargas: " + libro.getDescargas());
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
            }

        } else {
            System.out.println("███████ NO SE REGISTROS PARA LA OPCION SELECCIONADA ███████\n");
        }


    }

    private void buscarLibroWeb() {
        Respuesta datos = getDatosSerie();

        if (!datos.results().isEmpty()) {

            Libro libro = new Libro(datos.results().get(0));
            libro = libroRepositorio.save(libro);

        }

        System.out.println("Datos: ");
        System.out.println(datos);
    }

    private Respuesta getDatosSerie() {
        System.out.println("Ingresa el nombre del libro que deseas buscar: ");
        var titulo = teclado.nextLine();
        titulo = titulo.replace(" ", "%20");
        System.out.println("Titlulo : " + titulo);
        System.out.println(URL_BASE + titulo);
        var json = consumoApi.obtenerDatos(URL_BASE + titulo);
        System.out.println(json);
        Respuesta datos = conversor.obtenerDatos(json, Respuesta.class);
        return datos;
    }

}