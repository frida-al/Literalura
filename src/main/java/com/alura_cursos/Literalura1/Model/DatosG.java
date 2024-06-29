package com.alura_cursos.Literalura1.Model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosG(

        @JsonAlias("results") List<DatosLibros> resultado){

}