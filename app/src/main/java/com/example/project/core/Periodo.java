package com.example.project.core;

public class Periodo {

    private static String mes;
    private static int numero;
    private static int year;
    private static int horas;
    private static Periodo periodo = null;

    private Periodo(){}

    public static Periodo getInstance(){
        if (periodo == null){
            periodo = new Periodo();
            return periodo;
        }
        return periodo;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHoras(int horas) {
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
