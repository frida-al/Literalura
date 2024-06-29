package com.alura_cursos.Literalura1.principal;

import com.alura_cursos.Literalura1.Model.*;
import com.alura_cursos.Literalura1.repository.AutoresR;
import com.alura_cursos.Literalura1.repository.LibrosR;
import com.alura_cursos.Literalura1.servicios.ConsumoAPI;
import com.alura_cursos.Literalura1.servicios.ConvertirDatos;
import java.util.*;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvertirDatos convierteDatos = new ConvertirDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private LibrosR repository;
    private AutoresR repositoryAutores;
    private List<Libros> libros;
    private List<Autores> autor;

    public Principal (){}
    public Principal(LibrosR repository, AutoresR repositoryAutores) {
        this.repository = repository;
        this.repositoryAutores = repositoryAutores;
    }
    private void menu(){
        var menu = """
                    ***********************************
                        Menu:
                    1.- Buscar libros por titulo
                    2.- Mostrar libros registrados
                    3.- Mostrar autores registrados
                    4.- Mostrar autores en determinado año
                    5.- Mostrar libros por idiomas
                    6.- Salir
                    ************************************
                    """;
        System.out.println(menu);
    }
    public void seleccionMenu (){
        var opcion = 0;
        while (opcion != 6) {

            menu();

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    buscarAutorPorYear();
                    break;
                case 5:
                    buscarLibrosPorIdioma();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar nuestra aplicación, vuelva pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }


    public void buscarLibro() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var buscaLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + buscaLibro.replace(" ", "+"));
        var buscador = convierteDatos.obtenerDatos(json, DatosG.class);

        Optional<DatosLibros> libroBuscado = buscador.resultado().stream()
                .filter(l -> l.titulo().toUpperCase().contains(buscaLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            DatosLibros datosLibros = libroBuscado.get();
            DatosAutores datosAutor = datosLibros.autor().get(0);
            Autores autor = repositoryAutores.findByNombre(datosAutor.nombre());
            
            if (autor == null) {
                autor = new Autores(datosAutor);
                repositoryAutores.save(autor);
            }

            Libros libro = repository.findByTituloContainsIgnoreCase(datosLibros.titulo());


            if (libro == null) {
                libro = new Libros(datosLibros, autor);
                repository.save(libro);
                System.out.println(libro);
            }
            else {
                System.out.println("El libro ya se encuentra registrado");
            }
            }
        else {
            System.out.println("No se encontró dicho libro");
        }
    }

    private void mostrarLibrosRegistrados(){
        libros = repository.findAll();
        libros.forEach(System.out::println);
    }

    private void mostrarAutoresRegistrados(){
        autor = repositoryAutores.findAll();
        autor.forEach(System.out::println);
    }

    private void buscarLibrosPorIdioma(){
        System.out.println("""
        *****************
        Ingrese el número del idioma sobre el que desea buscar:
        
        1.- Español
        2.- Inglés
        3.- Portugués
        4.- Italiano
        ****************
        """);
        var  numero = teclado.nextInt();
        switch (numero) {
            case 1:
                buscarIdioma("es");
                break;
            case 2:
                buscarIdioma("en");
                break;
            case 3:
                buscarIdioma("pt");
                break;
            case 4:
                buscarIdioma("it");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    private void buscarIdioma(String idioma) {
        try {
            libros = repository.findByIdiomas(idioma);

            if (libros == null) {
                System.out.println("No se encontraron libros registrados");
            } else {
                libros.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    private void buscarAutorPorYear() {
        System.out.println("Ingrese el año que desea buscar: ");
        int year = teclado.nextInt();
        autor = repositoryAutores.autores(year);
        if (autor == null) {
            System.out.println("No hay autores registrados en ese año");
        } else {
            autor.forEach(System.out::println);
        }
    }
}
