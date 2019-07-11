package com.example.project.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.helper.Colaborador;
import com.example.project.helper.FileHandle;
import com.example.project.helper.Periodo;
import com.example.project.helper.Proyecto;
import com.example.project.helper.XmlParser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DedicacionActivity extends AppCompatActivity {

    private FileOutputStream fileOutputStream;

    private ArrayList<TextView> projectsNames = new ArrayList<>();
    private ArrayList<TextView> inputsHours = new ArrayList<>();

    private String fileName = String.format("%s%s",
            Colaborador.getUserName(),
            FileHandle.getFileExtension());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dedicacion);
        TextView fullName = findViewById(R.id.colaboradorFullName);
        TextView textPeriodo = findViewById(R.id.infoYearMonth);
        TextView textHoras = findViewById(R.id.textHours);
        final EditText comments = findViewById(R.id.input_comments);
        Button buttonCargar = findViewById(R.id.buttonCargar);

        fullName.setText(Colaborador.getInstance().getFullName());
        textPeriodo.setText(String.format("%s/%d",
                Periodo.getInstance().getMes(),
                Periodo.getInstance().getYear()));
        textHoras.setText(String.format("%d Horas",Periodo.getInstance().getHoras()));
        showProjects();

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horasCargadas = getHorasCargadas();
                if (horasCargadas< Periodo.getInstance().getHoras()){
                    new ErrorCarga().show(getSupportFragmentManager(),"Error en Carga");
                } else{
                    Intent intent = new Intent(getApplicationContext(), CargaExitosaActivity.class);
                    saveDedicacion(horasCargadas, comments.getText().toString());
                    cargarHistorico();
                    startActivity(intent);
                }
            }
        });

    }

    private void showProjects(){
        ArrayList<Proyecto> projects = XmlParser.getProyectos(getResources().openRawResource(R.raw.proyectos));

        loadProjectsAndHoursElements();

        for (int i=0; i<Colaborador.getInstance().getIdProyectos().size();i++){
            String userIdProject = Colaborador.getInstance().getIdProyectos().get(i);
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

    public void saveDedicacion(int horasCargadas, String comments){
        String stringDedicacion = String.format("%s %s|%s|%s|%s",
                Periodo.getInstance().getYear(),
                Periodo.getInstance().getMes(),
                Periodo.getInstance().getHoras(),
                horasCargadas,
                comments);
        writeFile(stringDedicacion+"\n");
    }

    private void cargarHistorico(){
        String[] dedicacionesHistoricas = Colaborador.getDedicacionesHistoricas().toArray(new String[0]);
        for(int i=0; i<dedicacionesHistoricas.length;i++){
            writeFile(dedicacionesHistoricas[i]+"\n");
        }
    }

    private void writeFile(String dedicacion){
        try {
            fileOutputStream = openFileOutput(fileName, MODE_APPEND);
            fileOutputStream.write(dedicacion.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
