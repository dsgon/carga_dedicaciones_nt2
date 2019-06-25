package com.example.project.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        TextView textPeriodo = findViewById(R.id.infoYearMonth);
        TextView textHoras = findViewById(R.id.textHours);
        Button buttonCargar = findViewById(R.id.buttonCargar);

        //TextView projectName = findViewById(R.id.idProyecto);

        //ArrayList<Proyecto> projects = new XmlParser().getProyectos(getResources().openRawResource(R.raw.proyectos));
        final Periodo periodo = new XmlParser().getPeriodo(getResources().openRawResource(R.raw.periodo));

        fullName.setText(bundle.getString("fullName"));
        textPeriodo.setText(String.format("%s/%d", periodo.getMes(), periodo.getYear()));
        textHoras.setText(String.format("%d",periodo.getHoras()));

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputDedicacion = findViewById(R.id.inputHoras);
                int horasCargadas = Integer.parseInt(inputDedicacion.getText().toString());
                if (horasCargadas < periodo.getHoras()){
                    new ErrorCarga().show(getSupportFragmentManager(),"Error en Carga");
                }

            }
        });

    }

}
