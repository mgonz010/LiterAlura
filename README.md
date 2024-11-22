# Desafio Challenge LiterAlura
## Bienvenido a LiterAlura...
LiterAlura es una aplicación que te permite gestionar tu biblioteca personal de libros.

## ¿Qué puedes hacer con Literalura?
- Buscar y Guarda libros por nombre del libror.
- Listar libros y autores registrados.
- Buscar autores vivos en un año específico.
- Listar libros por idioma.
- Obtener el top 10 de libros más buscados.
- Generar estadísticas sobre las descargas de libros.

## Prestaciones de LiterAlura
LiterAlura consume informacion de una API externa para obtener información de libros, https://gutendex.com/ 
Posteriormente almacena la informacion requerida en una base de datos local para que posteriormente gestionar la informacion obtenidad desde la API, al ser local no necesita conexión a internet.

Gutendex es una API que permite acceder a la biblioteca de libros de Project Gutenberg. Ofrece funcionalidades para buscar libros por tipo MIME y para buscar nombres de autores y títulos de libros mediante ciertas palabras clave.


## Estructura del proyecto:
  - com.desafio.alura.Literatura:
    - modelo: Clases que gestionan y aplican la persistencia de los datos de los libros.
    - repositorio: Clases que gestiona el acceso a la base de datos.
    - service: Clases que realiza las prestaciones a las clases del sistema.
    - principal: Clase principal de la aplicación.
- resources: Configuración para conectar con la Base de Datos del programa.
- pom.xml: Dependencias del proyecto.

## Recurso y Tecnologías Utilizadas
- Git - Git Hub
- Intellij IDEA
- PostgreSQL
- Java 21
- Spring
- Spring Data JPA

