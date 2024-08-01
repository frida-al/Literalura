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


<h1 align="center"> Literalura_Alura_ONE ENGLISH</h1>

<h2> Considerations: the project is in Spanish</h2>
<h2>Project description</h2>
I developed this project to practice using Java, Spring Framework, SQL, and API consomption. The project allows us to check data about the books stored in Project Gutenberg, using the API `Gutendex`. The data consulted is stored in a database in Postgres.
The menu of the project has 6 options:

  1. Find book by title
     
  2. Show registered books
     
  3. Show registered authors
     
  4. Show authors in a specific year
     
  5. Show registered books per language
      
  6. Exit

<h2>Project status</h2>
:white_check_mark: **Finished** :white_check_mark:


## :hammer:Features

- `Option 1`: This first option will allow us to write the title of a book (or a part of it) that we wish to look up and will display the info of said book. If the book is not found, it will display a message. 
-  `Option 2`: Number two will show us the books that have already been registered in the database. The registration occurs when we search the book.
-  `Option 3`: Number three will show us the authors of the books that are already registered in the database.
-  `Option 4`: Number four allows us to look up all the authors that were alive in a year. The input of this option will be the year we want to look up.
-  `Option 5`: This fifth option allows us to look up books in a specific language. The output will be the books in said language that have already been registered.
-  `Option 6`: Lastly, option 6 closes the program.
