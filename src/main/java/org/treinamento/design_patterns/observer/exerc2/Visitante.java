package org.treinamento.design_patterns.observer.exerc2;

import java.util.Observable;
import java.util.Observer;

public class Visitante implements Observer {

    private Time time;
    private int gols;
    private String nomeTime;



    public Visitante(Observable observable, String nomeTime){
        this.nomeTime = nomeTime;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Partida){
            this.setGols( ((Partida) o).getVisitante().getGols());
        }
    }

    public void golMarcado(){
        this.gols++;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }
}
