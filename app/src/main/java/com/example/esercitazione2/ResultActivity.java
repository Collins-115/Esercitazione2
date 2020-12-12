package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nomeT,cognomeT,dataT,indirizzoT,etaT,capT;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nomeT = findViewById(R.id.nomeConf);
        cognomeT = findViewById(R.id.cognomeConf);
        dataT = findViewById(R.id.nascitaConf);
        indirizzoT = findViewById(R.id.indirizzoConf);
        etaT = findViewById(R.id.etaConf);
        capT = findViewById(R.id.capConf);
        ok = findViewById(R.id.ok);

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
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        dataT.setText(format.format(persona.getNascita().getTime()));
        indirizzoT.setText(persona.getIndirizzo());
        etaT.setText(""+persona.getEta());
        capT.setText(persona.getCap());
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}