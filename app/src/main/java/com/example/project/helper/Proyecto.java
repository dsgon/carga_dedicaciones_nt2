package com.example.project.helper;

public class Proyecto {

    private String id;
    private String name;

    public Proyecto(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){ return id; }

    public String getName(){ return name; }
}
