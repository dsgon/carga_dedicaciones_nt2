package com.example.project.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.helper.Periodo;
import com.example.project.helper.Proyecto;
import com.example.project.helper.XmlParser;

import java.util.ArrayList;
import com.example.project.helper.Adaptador;

public class DedicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        setContentView(R.layout.activity_dedicacion);
        TextView fullName = findViewById(R.id.colaboradorFullName);
        //TextView projectName = findViewById(R.id.idProyecto);

        //ArrayList<Proyecto> projects = new XmlParser().getProyectos(getResources().openRawResource(R.raw.proyectos));
        Periodo periodo = new XmlParser().getPeriodo(getResources().openRawResource(R.raw.periodo));
        TextView textPeriodo = findViewById(R.id.infoYearMonth);
        TextView textHoras = findViewById(R.id.textHours);

        fullName.setText(bundle.getString("fullName"));
        textPeriodo.setText(String.format("%s/%d", periodo.getMes(), periodo.getYear()));
        textHoras.setText(String.format("%d",periodo.getHoras()));

    }

}
