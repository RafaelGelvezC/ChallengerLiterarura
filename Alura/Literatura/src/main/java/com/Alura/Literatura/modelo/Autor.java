package com.Alura.Literatura.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Autor {
    private String nombre;
    private int anoNacimiento;
    private int anoMuerte;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    @JsonAlias("name")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    @JsonAlias("birth_year")
    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public int getAnoMuerte() {
        return anoMuerte;
    }

    @JsonAlias("death_year")
    public void setAnoMuerte(int anoMuerte) {
        this.anoMuerte = anoMuerte;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", anoNacimiento=" + anoNacimiento +
                ", anoMuerte=" + anoMuerte +
                '}';
    }
}