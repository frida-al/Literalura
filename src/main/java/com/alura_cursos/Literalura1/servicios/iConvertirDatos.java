package com.alura_cursos.Literalura1.servicios;

public interface iConvertirDatos {

    <T> T obtenerDatos (String json, Class<T> clase);
}