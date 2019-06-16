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
                Intent intent = new Intent(getApplicationContext(), DedicacionActivity.class);
                EditText user = findViewById(R.id.inputUser);
                EditText pass = findViewById(R.id.inputPass);
                colaborador = new Login().validateAccess(user.getText().toString(),pass.getText().toString(),
                        getResources().openRawResource(R.raw.colaboradores));
                if (colaborador != null){
                    /* Envia a la vista Dedicaciones */
                    intent.putExtra("fullName", colaborador.getFullName());
                    int c = colaborador.getIdProyectos().size();
                    intent.putExtra("cantProjects", c);
                    for(int i=0; i<colaborador.getIdProyectos().size();i++){
                        intent.putExtra(String.format("project%s",i),colaborador.getIdProyectos().get(i));
                    }
                    startActivity(intent);
                } else {
                    /*Muestra mensaje de Error */
                    new ErrorLogin().show(getSupportFragmentManager(),"Error Login");
                }

            }
        });
    }
}
