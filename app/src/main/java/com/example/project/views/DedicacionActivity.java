package com.example.project.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.project.R;

public class DedicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        setContentView(R.layout.activity_dedicacion);
        TextView result = findViewById(R.id.colaboradorFullName);
        result.setText(bundle.getString("user"));
    }

}
