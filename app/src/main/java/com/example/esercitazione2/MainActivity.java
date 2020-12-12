package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText nome,cognome,data,indirizzo;
    TextView etaNumero;
    Button invia;
    Persona persona;
    SeekBar eta;
    public static final String PERSONA_PATH = "com.example.esercitazione2.Persona";
    int etaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        data = findViewById(R.id.nascita);
        indirizzo = findViewById(R.id.indirizzo);
        invia = findViewById(R.id.invia);
        eta = (SeekBar) findViewById(R.id.eta);
        etaNumero = findViewById(R.id.etaNumero);
        etaN=eta.getProgress();

        persona = new Persona();

        invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
                updatePerson();
                showResult.putExtra(PERSONA_PATH, persona);
                startActivity(showResult);
            }
        });
        eta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                etaN = progress;
                etaNumero.setText(""+etaN);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                etaNumero.setText(""+etaN);
            }
        });

    }

    public void updatePerson(){
        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setNascita(this.data.getText().toString());
        this.persona.setIndirizzo(this.indirizzo.getText().toString());
        this.persona.setEta(etaN);
    }

}