package com.alura_cursos.Literalura1.repository;

import com.alura_cursos.Literalura1.Model.Autores;
import com.alura_cursos.Literalura1.Model.DatosLibros;
import com.alura_cursos.Literalura1.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibrosR extends JpaRepository<Libros,Long> {

    Libros findByTituloContainsIgnoreCase(String nombreLibro);

    List<Libros> findByIdiomas(String idioma);


}
