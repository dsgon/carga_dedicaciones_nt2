package com.example.project.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.project.R;
import com.example.project.helper.Adaptador;

public class HistoricActivity extends AppCompatActivity {

    ListView listView;
    //TODO: esto debe ser tomado del archivo Colaborador.txt
    String[][] dedicaciones = {
        {"201904","152","152"},
        {"201905","160","160"},
        {"201906","160","164"},
            {"201907","152","164"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);
        listView = (ListView) findViewById(R.id.listHistoric);
        listView.setAdapter(new Adaptador(this, dedicaciones));
    }
}
