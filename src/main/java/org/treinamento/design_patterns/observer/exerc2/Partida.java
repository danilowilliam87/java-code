package org.treinamento.design_patterns.observer.exerc2;

import java.util.Observable;

public class Partida extends Observable {
    private Mandante mandante;
    private Visitante visitante;

    private int golsMandante = 0;
    private int golsVisitante = 0;

    public static final String GOL_MANDANTE = "GOL_MANDANTE";
    public static final String GOL_VISITANTE = "GOL_VISITANTE";

    public Partida() {

    }

    public Partida(String nomeMandante, String nomeVisitante){
        this.mandante.setNomeTime(nomeMandante);
        this.visitante.setNomeTime(nomeVisitante);
    }

    public Mandante getMandante() {
        return mandante;
    }

    public void setMandante(Mandante mandante) {
        this.mandante = mandante;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public void atualizarPlacar(String time){
        if(GOL_MANDANTE.equalsIgnoreCase(time)){
            this.golsMandante++;
            this.mandante.setGols(this.golsMandante);
            setChanged();
            notifyObservers();
        }

        if(GOL_VISITANTE.equalsIgnoreCase(time)){
           this.golsVisitante++;
           this.visitante.setGols(this.golsVisitante);
            setChanged();
            notifyObservers();
        }



        System.out.printf("%s %d X %d %s\n",
                this.getMandante().getNomeTime(),
                this.getMandante().getGols(),
                this.getVisitante().getGols(),
                this.getVisitante().getNomeTime());
    }

    public int getGolsMandante() {
        return golsMandante;
    }

    public void setGolsMandante(int golsMandante) {
        this.golsMandante = golsMandante;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(int golsVisitante) {
        this.golsVisitante = golsVisitante;
    }
}
