package com.example.project.helper;

import java.util.ArrayList;

public class Colaborador {

    private String fullName;
    private String userName;
    private String password;
    private ArrayList idProject;

    public Colaborador(String fullName, String userName, String pass, ArrayList<String> projects){
        this.fullName = fullName;
        this.userName = userName;
        this.password = pass;
        this.idProject = projects;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFullName(){
        return this.fullName;
    }

    public ArrayList<String> getIdProyectos(){
        return this.idProject;
    }
}
