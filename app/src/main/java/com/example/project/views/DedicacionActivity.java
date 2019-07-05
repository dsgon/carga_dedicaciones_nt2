package com.example.project.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.helper.Periodo;
import com.example.project.helper.Proyecto;
import com.example.project.helper.XmlParser;

import java.util.ArrayList;

public class DedicacionActivity extends AppCompatActivity {

    private Bundle bundle;

    private ArrayList<TextView> projectsNames = new ArrayList<>();
    private ArrayList<TextView> inputsHours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getIntent().getExtras();
        setContentView(R.layout.activity_dedicacion);
        TextView fullName = findViewById(R.id.colaboradorFullName);
        TextView textPeriodo = findViewById(R.id.infoYearMonth);
        TextView textHoras = findViewById(R.id.textHours);
        Button buttonCargar = findViewById(R.id.buttonCargar);
        final String userFullName = bundle.getString("fullName");

        final Periodo periodo = new XmlParser().getPeriodo(getResources().openRawResource(R.raw.periodo));

        fullName.setText(userFullName);
        textPeriodo.setText(String.format("%s/%d", periodo.getMes(), periodo.getYear()));
        textHoras.setText(String.format("%d",periodo.getHoras()));
        showProjects();

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getHorasCargadas()< periodo.getHoras()){
                    new ErrorCarga().show(getSupportFragmentManager(),"Error en Carga");
                } else{
                    Intent intent = new Intent(getApplicationContext(), CargaExitosaActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private void showProjects(){
        ArrayList<Proyecto> projects = new XmlParser().getProyectos(getResources().openRawResource(R.raw.proyectos));

        loadProjectsAndHoursElements();

        int userProjectsSize = bundle.getInt("cantProjects");

        for (int i=0; i<userProjectsSize;i++){
            String userIdProject = bundle.getString(String.format("project%s",i));
            Proyecto project = null;
            int j=0;
            while (j<projects.size()){
                if(projects.get(j).getId().equals(userIdProject)){
                    project = projects.get(j);
                    break;
                }
                j++;
            }
            if (project != null){
                projectsNames.get(i).setText(project.getName());
                projectsNames.get(i).setVisibility(View.VISIBLE);
                inputsHours.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    private void loadProjectsAndHoursElements() {
        projectsNames.add((TextView) findViewById(R.id.idProyecto));
        projectsNames.add((TextView) findViewById(R.id.idProyecto2));
        projectsNames.add((TextView) findViewById(R.id.idProyecto3));

        inputsHours.add((TextView) findViewById(R.id.inputHoras));
        inputsHours.add((TextView) findViewById(R.id.inputHoras2));
        inputsHours.add((TextView) findViewById(R.id.inputHoras3));
    }

    private int getHorasCargadas(){
        int hours = 0;
        for (TextView input : inputsHours) {
            hours += Integer.parseInt(input.getText().toString());
        }
        return hours;
    }

}
