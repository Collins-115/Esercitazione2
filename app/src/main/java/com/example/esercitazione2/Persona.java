package com.example.esercitazione2;


import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String cap;
    private String email;
    private Calendar nascita;
    private int eta;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.indirizzo="";
        this.eta=0;
        this.cap="";
        this.email="";
    };

    public Persona(String nome, String cognome, String nascita, String indirizzo, int eta, String cap, String email){
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo= indirizzo;
        this.eta=eta;
        this.cap=cap;
        this.email=email;
    };

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Calendar getNascita() {
        return nascita;
    }
    public String getIndirizzo(){
        return indirizzo;
    }
    public int getEta(){
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNascita(Calendar nascita) {
        this.nascita = nascita;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
