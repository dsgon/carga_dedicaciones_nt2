package com.example.project.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.project.R;
import com.example.project.helper.Adaptador;
import com.example.project.helper.Colaborador;
import com.example.project.helper.FileHandle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HistoricActivity extends AppCompatActivity {

    private ListView listView;
    private FileInputStream fileInputStream;
    String[][] dedicaciones;
    private final int MAX_ROWS = 6;
    private final int MAX_COLUMNS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);
        setDedicacionesCargadas();
        listView = (ListView) findViewById(R.id.listHistoric);
        listView.setAdapter(new Adaptador(this, dedicaciones));
    }

    private void setDedicacionesCargadas(){
        try{
            fileInputStream = openFileInput(String.format("%s%s",
                    Colaborador.getUserName(),
                    FileHandle.getFileExtension()));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            int i=0;
            int max = Colaborador.getDedicacionesHistoricas().size() + 1;
            if (max >= MAX_ROWS ) max = MAX_ROWS;
            dedicaciones = new String[max][MAX_COLUMNS];
            while(((line = bufferedReader.readLine()) != null )&& i<max){
                String[] row = line.split(",");
                dedicaciones[i] = row;
                i++;
            }
        } catch (FileNotFoundException notFile){
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
