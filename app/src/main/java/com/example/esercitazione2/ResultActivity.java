package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nomeT,cognomeT,dataT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nomeT = findViewById(R.id.nomeConf);
        cognomeT = findViewById(R.id.cognomeConf);
        dataT = findViewById(R.id.nascitaConf);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof  Persona){
            this.persona = (Persona) object;
        }
        else{
            persona = new Persona();
        }

        nomeT.setText(persona.getNome());
        cognomeT.setText(persona.getCognome());
        dataT.setText(persona.getNascita());
    }
}