package org.treinamento.design_patterns.observer.exerc2;

public class Jogo {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Time bahia  = new Time("BAHIA");
        Time vitoria = new Time("VITORIA");


        Mandante mandante = new Mandante(partida, "BAHIA");
        Visitante visitante = new Visitante(partida, "VITORIA");

        partida.setMandante(mandante);
        partida.setVisitante(visitante);


        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_VISITANTE);
        partida.atualizarPlacar(Partida.GOL_VISITANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
        partida.atualizarPlacar(Partida.GOL_MANDANTE);
    }
}
