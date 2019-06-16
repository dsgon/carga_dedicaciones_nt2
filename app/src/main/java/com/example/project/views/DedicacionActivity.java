package com.example.project.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.helper.Proyecto;
import com.example.project.helper.XmlParser;

import java.util.ArrayList;

public class DedicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        setContentView(R.layout.activity_dedicacion);
        TextView fullName = findViewById(R.id.colaboradorFullName);
        TextView projectName = findViewById(R.id.idProyecto);
        ArrayList<Proyecto> projects = new XmlParser().getProyectos(getResources().openRawResource(R.raw.proyectos));
        int i=0;
        while(i < projects.size()){
            if(projects.get(i).getId().equals(bundle.getString("project1"))){
                projectName.setText(projects.get(i).getName());
                break;
            }
            i++;
        }
        fullName.setText(bundle.getString("fullName"));
    }

}
