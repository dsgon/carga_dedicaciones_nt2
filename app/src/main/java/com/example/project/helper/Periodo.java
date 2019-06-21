package com.example.project.helper;

public class Periodo {

    private String mes;
    private int numero;
    private int year;
    private int horas;

    public Periodo(String mes, int numero, int year, int horas){
        this.mes = mes;
        this.numero = numero;
        this.year = year;
        this.horas = horas;
    }

    public int getNumero() {
        return numero;
    }

    public int getYear() {
        return year;
    }

    public int getHoras() {
        return horas;
    }

    public String getMes() {
        return mes;
    }
}
