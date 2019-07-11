package com.example.project.helper;

import com.example.project.core.Colaborador;

import java.io.InputStream;

public class Login {

    public boolean validateAccess(String user, String pass, InputStream xml){
        XmlParser.createColaborador(xml, user);
        if(Colaborador.getInstance()!= null && Colaborador.getInstance().getPassword().equals(pass))
                return true;
        return false;
    }
}
