package com.example.project.login;

import com.example.project.helper.Colaborador;
import com.example.project.helper.XmlParser;

import java.io.InputStream;

public class Login {

    public boolean validateAccess(String user, String pass, InputStream xml){
        XmlParser.createColaborador(xml, user);
        if(Colaborador.getInstance()!= null && Colaborador.getInstance().getPassword().equals(pass))
                return true;
        return false;
    }
}
