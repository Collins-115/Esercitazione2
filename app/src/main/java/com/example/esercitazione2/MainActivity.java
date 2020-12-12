package com.example.esercitazione2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    EditText nome,cognome,data,indirizzo,cap,email;
    TextView etaNumero,errorText;
    Button invia, pulisci;
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
        errorText = findViewById(R.id.errorText);
        cap = findViewById(R.id.cap);
        etaN=eta.getProgress();
        pulisci = findViewById(R.id.pulisci);
        email = findViewById(R.id.email);
        persona = new Persona();

        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDialog();
                }
            }
        });
        pulisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                cognome.setText("");
                data.setText("");
                indirizzo.setText("");
                cap.setText("");
                email.setText("");
            }
        });
        invia.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
                if(checkInput()) {
                    updatePerson();
                    showResult.putExtra(PERSONA_PATH, persona);
                    startActivity(showResult);
                }
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

        this.persona.setIndirizzo(this.indirizzo.getText().toString());
        this.persona.setEta(etaN);
        this.persona.setCap(this.cap.getText().toString());
    }

    public void updateNascita(Calendar date){

        this.persona.setNascita(date);
    }
    //true buon fine, false altrimenti
    @RequiresApi(api = Build.VERSION_CODES.O)
    private boolean checkInput(){
        int errors = 0;
        String regex = "^(.+)@(.+)\\.(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email.getText());
        if(!matcher.matches()){
            errors++;
            email.setError("Email non valida");
        }
        else{
            email.setError(null);
        }
        if(nome.getText() == null || nome.getText().length() == 0){
            errors++;
            nome.setError("Inserire nome");
        }
        else{
            nome.setError(null);
        }
        if(cognome.getText() == null || cognome.getText().length() == 0){
            errors++;
            cognome.setError("Inserire cognome");
        }
        else{
            cognome.setError(null);
        }
        LocalDate newDate = LocalDate.parse(data.getText().toString(), DateTimeFormatter.ofPattern("dd/mm/yyyy"));
        Period period = Period.between(newDate , LocalDate.now());
        Log.d(getClass().getName(), "value = " +period.getYears());

        if(period.getYears()<18 || data.getText().length() == 0){
            errors++;
            data.setError("Inserire data");
        }
        else{
            data.setError(null);
        }
        if(cap.getText() == null || cap.getText().length() != 5){
            errors++;
            cap.setError("Inserire cap di 5 cifre");
        }
        else{
            cap.setError(null);
        }
        switch(errors){
            case 0:
                errorText.setVisibility(View.GONE);
                errorText.setText("");
                break;
            case 1:
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Si e' verificato un errore");
                break;
            default:
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Si sono verificati "+errors+" errori");
                break;
        }
        return errors==0;
    }

    void showDialog(){
        DialogFragment newFragment = DatePickFragment.newIstance();
        newFragment.show(getSupportFragmentManager(), "dialog");

    }

    public void doPositiveClick(Calendar date){
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        data.setText(format.format(date.getTime()));
    }

    public void doNegativeClick(){

    }
}