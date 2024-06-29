package com.alura_cursos.Literalura1.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutores(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String nacimientoYear,
        @JsonAlias("death_year") String muerteYear,
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear){}