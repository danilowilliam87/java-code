package org.treinamento.design_patterns.observer.exerc1;

import java.util.Observable;

public class StockData extends Observable {

    private float price;

    public StockData(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStockData(float price){
        this.price = price;
        setChanged();
        notifyObservers();
    }
}
