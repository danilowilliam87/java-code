package org.treinamento.design_patterns.observer.exerc1;

import java.util.Observable;
import java.util.Observer;

public class Buyer implements Observer {

    public Buyer(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof StockData){
            StockData data = (StockData) o;
            System.out.println("buyer price: " + data.getPrice());
         }
    }
}
