package com.example.project.helper;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class XmlParser {

    public ArrayList<Colaborador> getColaboradores(InputStream xml){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document document = builder.parse(xml);
            document.getDocumentElement().normalize();
            //Obtiene una lista de todos los elementos XML llamados "colaborador"
            NodeList colaboradores = document.getElementsByTagName("colaborador");
            ArrayList<Colaborador> listColaboradores = new ArrayList<Colaborador>();

            for (int i = 0; i < colaboradores.getLength(); i++) {
                Node colaborador = colaboradores.item(i);

                //Se cargan los elementos dentro de la lista que se llenará en el Adaptador
                if (colaborador.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) colaborador;
                    String fullName = element.getElementsByTagName("fullName").item(0).getTextContent();
                    String userName = element.getElementsByTagName("userName").item(0).getTextContent();
                    String password = element.getElementsByTagName("pass").item(0).getTextContent();
                    ArrayList<String> projects = new ArrayList<>();
                    for (int j=0; j< element.getElementsByTagName("proyecto").getLength(); j++){
                        projects.add(element.getElementsByTagName("proyecto").item(j).getTextContent());
                    }
                    listColaboradores.add(new Colaborador(fullName,userName, password, projects));

                }
            }
            return listColaboradores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Proyecto> getProyectos(InputStream xml){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document document = builder.parse(xml);
            document.getDocumentElement().normalize();
            //Obtiene una lista de todos los elementos XML llamados "proyecto"
            NodeList projects = document.getElementsByTagName("proyecto");
            ArrayList<Proyecto> listProject = new ArrayList<>();

            for (int i = 0; i < projects.getLength(); i++) {
                Node project = projects.item(i);

                //Se cargan los elementos dentro de la lista que se llenará en el Adaptador
                if (project.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) project;
                    String idProject = element.getElementsByTagName("id").item(0).getTextContent();
                    String nameProject = element.getElementsByTagName("nombreProyecto").item(0).getTextContent();
                    listProject.add(new Proyecto(idProject,nameProject));
                }
            }
            return listProject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Periodo getPeriodo(InputStream xml){
        Periodo periodo = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document document = builder.parse(xml);
            document.getDocumentElement().normalize();
            //Obtiene una lista de todos los elementos XML llamados "perido"
            NodeList periodoXml = document.getElementsByTagName("periodo");
            // Deberia existir un unico perido para cargar
            if (periodoXml.getLength() > 1) throw new Exception("InvalidPeriodo");

            if(periodoXml.item(0).getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) periodoXml.item(0);
                String mes = element.getElementsByTagName("month").item(0).getTextContent();
                int numero = Integer.parseInt(element.getElementsByTagName("number").item(0).getTextContent());
                int year = Integer.parseInt(element.getElementsByTagName("year").item(0).getTextContent());
                int hours = Integer.parseInt(element.getElementsByTagName("horasHabiles").item(0).getTextContent());
                periodo =  new Periodo(mes,numero,year,hours);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return periodo;
        }
    }

}
