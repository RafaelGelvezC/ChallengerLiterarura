package com.Alura.Literatura.modelo;

import java.util.List;

public class DatosLibros {
    private int count;
    private String next;
    private String previous;
    private List<Libros> results;

    // Getters y Setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Libros> getResults() {
        return results;
    }

    public void setResults(List<Libros> results) {
        this.results = results;
    }
}