<h1 align="center"> Literalura_Alura_ONE </h1>

<h2>Descripción del proyecto</h2>
Este proyecto fue realizado para poner en práctica los conocimientos aprendidos en los cursos `Java: trabajando con lambdas, streams y Spring Framework` y `Java: persistencia de datos y consultas con Spring Data JPA`. El proyecto nos permite consultar datos acerca de los libros del Proyecto Gutenberg mendiante el consumo de su API, Gutendex. Posteriormente, los datos consultados se guardan en una base de datos de Postgres.
El programa presenta un menú que consta de 6 opciones:

  1. Buscar libro por título
     
  2. Mostrar libros registrados
     
  3. Mostrar autores registrados
     
  4. Mostrar autores en determinado año
     
  5. Mostrar libros por idioma
      
  6. Salir


<h2>Estatus del proyecto</h2>
:white_check_mark: Terminado :white_check_mark:

## :hammer:Funcionalidades del proyecto

- `Funcionalidad 1`: La opción 1 del menú nos permite ingresar el título (también acepta búsqueda parcial) del libro que deseamos buscar y se mostrará la información del libro encontrado. Si no se encuentra un libro con ese nombre, se desplegará un mensaje.
-  `Funcionalidad 2`: La función número 2 del menú nos muestra los libros que ya registramos en la base de datos, buscándolos previamente.
-  `Funcionalidad 3`: La opción 3 nos muestra los autores que ya están registrados en nuestra base de datos.
-  `Funcionalidad 4`: La opción 4 nos permite ingresar un año específico y nos mostrará qué autores estaban vivos en ese año.
-  `Funcionalidad 5`: La quinta opción nos permite elegir sobre qué idioma deseamos buscar y nos mostrará los libros registrados en tal idioma.
-  `Funcionalidad 6`: Por último, la opción 6 cierra la programa.
