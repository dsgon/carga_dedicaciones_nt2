package com.example.project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;
import com.example.project.helper.Colaborador;
import com.example.project.login.Login;

public class MainActivity extends AppCompatActivity {

    private Colaborador colaborador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se crea el Intent con DedicacionActivity como opcion por default
                Intent intent = new Intent(getApplicationContext(), DedicacionActivity.class);
                EditText user = findViewById(R.id.inputUser);
                EditText pass = findViewById(R.id.inputPass);
                colaborador = new Login().validateAccess(user.getText().toString(),pass.getText().toString(),
                        getResources().openRawResource(R.raw.colaboradores));
                if (colaborador != null){
                    /* Envia a la vista Dedicaciones
                    intent.setClass(MainActivity.this,DedicacionActivity.class);*/
                    intent.putExtra("fullName", colaborador.getFullName());
                    intent.putExtra("cantProjects",colaborador.getIdProyectos().size());
                    for(int i=0; i<colaborador.getIdProyectos().size();i++){
                        intent.putExtra(String.format("project%s",i),colaborador.getIdProyectos().get(i));
                    }
                    startActivity(intent);
                } else {
                    /* Envia a page de error.
                    Se setea la vista ErrorLogin para el manejo del error */
                    intent.setClass(MainActivity.this,ErrorLogin.class);
                    startActivity(intent);
                }

            }
        });
    }
}
