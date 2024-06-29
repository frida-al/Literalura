package com.alura_cursos.Literalura1.Model;

import jakarta.persistence.*;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    @Column(columnDefinition = "integer")
    private int birthYear;

    @Column(columnDefinition = "integer")
    private int deathYear;

    private String nacimientoYear;
    private String muerteYear;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Libros> libros = new HashSet<>();

    public Autores() {}

    public Autores(DatosAutores datosAutor) {
        this.nombre = datosAutor.nombre();
        this.nacimientoYear = datosAutor.nacimientoYear();
        this.muerteYear = datosAutor.muerteYear();
        this.deathYear = datosAutor.deathYear();
        this.birthYear = datosAutor.birthYear();

    }

    public Autores(String nombre, int birthYear, int deathYear){
        this.nombre = nombre;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return
                "Autor: " + nombre + '\n' +
                        "Año de nacimiento: " + birthYear + '\n' +
                        "Año de defuncion: " + deathYear+ '\n' +
                        "Libros: " + (libros != null ?libros.stream()
                        .map(Libros::getTitulo)
                        .collect(Collectors.joining(", ")) : "N/A") +'\n' +
                        '\n';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimientoYear() {
        return nacimientoYear;
    }

    public void setNacimientoYear(String nacimientoYear) {
        this.nacimientoYear = nacimientoYear;
    }

    public String getMuerteYear() {
        return muerteYear;
    }

    public void setMuerteYear(String muerteYear) {
        this.muerteYear = muerteYear;
    }

    public Set<Libros> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libros> libros) {
        this.libros = libros;
        for (Libros libro : libros) {
            libro.setAutor(this);
        }
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}