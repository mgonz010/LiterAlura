# Desafio Challenge LiterAlura
## Bienvenido a LiterAlura...
Literalura es una aplicación que te permite gestionar tu biblioteca personal de libros.

## ¿Qué puedes hacer con Literalura?
- Buscar y Guarda libros por título o autor.
- Listar libros y autores registrados.
- Buscar autores vivos en un año específico.
- Listar libros por idioma.
- Obtener el top 10 de libros más buscados.
- Generar estadísticas sobre las descargas de libros.

## Prestaciones de LiterAlura
Literalura utiliza una API externa para obtener información sobre libros y autores: https://gutendex.com/ 
También almacena información en una base de datos local para que puedas acceder a ella incluso sin conexión a internet.


## Estructura del proyecto:
- src/main/java:
  - com.desafio.alura.Literatura:
    - model: Contiene las clases que representan los datos de libros y autores.
    - repositorio: Contiene las interfaces y clases que se utilizan para acceder a la base de datos.
    - service: Contiene las clases que implementan la lógica de negocio de la aplicación.
    - principal: Contiene la clase principal de la aplicación.
- src/main/resources: Contiene los archivos de configuración de la aplicación.
- pom.xml: Dependencias del proyecto.

## Tecnologías utilizadas:
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
