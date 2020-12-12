package com.example.esercitazione2;


import java.io.Serializable;

public class Persona implements Serializable {

    private String nome,cognome, nascita, indirizzo;
    private int eta;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.nascita="";
        this.indirizzo="";
        this.eta=0;

    };

    public Persona(String nome, String cognome, String nascita, String indirizzo, int eta){
        this.nome=nome;
        this.cognome=cognome;
        this.nascita=nascita;
        this.indirizzo= indirizzo;
        this.eta=eta;

    };

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNascita() {
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

    public void setNascita(String nascita) {
        this.nascita = nascita;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

}
