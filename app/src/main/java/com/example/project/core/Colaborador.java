package com.example.project.core;

import java.util.ArrayList;

public class Colaborador {

    private static String fullName;
    private static String userName;
    private static String password;
    private static ArrayList<String> idProject = new ArrayList<>();
    private static ArrayList<String> dedicacionesHistoricas = new ArrayList<>();
    private static Colaborador colaborador = null;

    private Colaborador(){}

    public static Colaborador getInstance(){
        if(colaborador == null){
            colaborador = new Colaborador();
            return colaborador;
        }
        return colaborador;
    }

    public static void setFullName(String fullName) {
        Colaborador.fullName = fullName;
    }

    public static void setUserName(String userName) {
        Colaborador.userName = userName;
    }

    public static void setPassword(String password) {
        Colaborador.password = password;
    }

    public static void setIdProject(ArrayList<String> idProject) {
        Colaborador.idProject = idProject;
    }

    public static void setDedicacionesHistoricas(ArrayList<String> dedicaciones){ Colaborador.dedicacionesHistoricas = dedicaciones;}

    public static ArrayList getIdProject() {
        return idProject;
    }

    public static String getUserName(){
        return Colaborador.userName;
    }

    public static String getPassword(){
        return Colaborador.password;
    }

    public static String getFullName(){
        return Colaborador.fullName;
    }

    public static ArrayList<String> getIdProyectos(){
        return Colaborador.idProject;
    }

    public static ArrayList<String> getDedicacionesHistoricas() { return  Colaborador.dedicacionesHistoricas;}
}
