package com.example.project.login;

import android.content.Context;

import com.example.project.helper.Colaborador;
import com.example.project.helper.XmlParser;

import java.io.InputStream;
import java.util.ArrayList;

public class Login {

    private XmlParser xmlParser = new XmlParser();

    public Colaborador validateAccess(String user, String pass, InputStream xml){
        ArrayList<Colaborador> collaborators = xmlParser.getColaboradores(xml);
        int i = 0;
        while (i < collaborators.size()){
            if (user.equals(collaborators.get(i).getUserName()) &&
                pass.equals(collaborators.get(i).getPassword()))
                return collaborators.get(i);
            i++;
        }
        return null;
    }
}
