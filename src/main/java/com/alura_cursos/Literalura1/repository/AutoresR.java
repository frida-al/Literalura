package com.alura_cursos.Literalura1.repository;

import com.alura_cursos.Literalura1.Model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoresR extends JpaRepository<Autores,Long>  {
    Autores findByNombre(String nombre);
    Autores findByBirthYear(int birthYear);
    Autores findByDeathYear(int deathYear);

    @Query(value = "SELECT a.id, a.birth_year, a.death_year, a.muerte_year, a.nacimiento_year, a.nombre, a FROM Autor a WHERE a.birth_year <= :year AND a.death_year >= :year ", nativeQuery = true)
    List<Autores> autores(int year);

}
