package com.example.project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;
import com.example.project.core.Colaborador;
import com.example.project.core.Periodo;
import com.example.project.helper.FileHandle;
import com.example.project.helper.XmlParser;
import com.example.project.helper.Login;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private FileInputStream fileInputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText user = findViewById(R.id.inputUser);
                EditText pass = findViewById(R.id.inputPass);

                if (new Login().validateAccess(user.getText().toString(),pass.getText().toString(),
                        getResources().openRawResource(R.raw.colaboradores))){
                    XmlParser.crearPeriodo(getResources().openRawResource(R.raw.periodo));
                    if(!dedicacionCargada()){
                        Intent intent = new Intent(getApplicationContext(), DedicacionActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), CargaExitosaActivity.class);
                        startActivity(intent);
                    }

                } else {
                    /*Muestra mensaje de Error */
                    new ErrorLogin().show(getSupportFragmentManager(),"Error Login");
                }

            }
        });
    }

    private boolean dedicacionCargada(){
        try{
            fileInputStream = openFileInput(String.format("%s%s",
                    Colaborador.getUserName(),
                    FileHandle.getFileExtension()));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
                System.out.println(line);
                if(line.startsWith(String.format("%s %s",
                        Periodo.getInstance().getYear(),
                        Periodo.getInstance().getMes()))){
                    return true;
                }
            }
        } catch (FileNotFoundException notFile){
            return false;
        } catch (IOException io){
            io.printStackTrace();
            return false;
        }
        return false;
    }
}
