package org.treinamento.design_patterns.observer.exerc1;

import java.util.Observable;
import java.util.Observer;

public class Curioso implements Observer {

    public Curioso(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("stock data na promoção galera");
    }
}
