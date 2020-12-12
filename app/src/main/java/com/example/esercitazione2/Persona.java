package com.example.esercitazione2;


import java.io.Serializable;

public class Persona implements Serializable {

    private String nome,cognome, nascita;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.nascita="";

    };

    public Persona(String nome, String cognome, String nascita){
        this.nome=nome;
        this.cognome=cognome;
        this.nascita=nascita;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNascita(String nascita) {
        this.nascita = nascita;
    }

}
