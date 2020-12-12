package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nomeT,cognomeT,dataT,indirizzoT,etaT;
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
        dataT.setText(persona.getNascita());
        indirizzoT.setText(persona.getIndirizzo());
        etaT.setText(""+persona.getEta());
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
}