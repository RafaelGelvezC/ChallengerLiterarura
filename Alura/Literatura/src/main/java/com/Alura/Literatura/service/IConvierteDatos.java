package com.Alura.Literatura.service;

public interface IConvierteDatos {
    <T> T convertirDesdeJson(String json, Class<T> clase);
}
