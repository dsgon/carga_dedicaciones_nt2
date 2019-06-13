package com.example.project.views;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Start a event that required a Intent object that receive two parameters:
                 Actual Page (getApplicationContext()) and the class of the Next Page*/
                Intent intent = new Intent(getApplicationContext(), DedicacionActivity.class);
                EditText user = findViewById(R.id.inputUser);
                EditText pass = findViewById(R.id.inputPass);
                intent.putExtra("user",user.getText().toString());
                intent.putExtra("pass",pass.getText().toString());
                startActivity(intent);
            }
        });
    }
}
