package com.example.project.helper;

public class Loader {

    /* Esto deberia ser consumido por medio de una API el cual te devuelva el histico por usuario */
    private String[] dedicacionesHistorica = {
            "2019 Junio,164,160",
            "2019 Mayo,152,152",
            "2019 Abril,160,160",
            "2019 Marzo,172,168",
            "2019 Febrero,160,160",

    };

    public String[] getDedicacionesHistoricas(){
        int cant = (int) ((Math.random() * (6 - 3)) + 3);
        int i = 0;
        String[] randomHistoric = new String[cant];
        while (i < cant){
            randomHistoric[i] = dedicacionesHistorica[i];
            i++;
        }
        return randomHistoric;
    }

}
