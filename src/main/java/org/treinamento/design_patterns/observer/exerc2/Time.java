package org.treinamento.design_patterns.observer.exerc2;

import org.treinamento.design_patterns.observer.exerc1.StockData;

import java.util.Observable;
import java.util.Observer;

public class Time  {

    private String nome;

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
