package org.treinamento.design_patterns.observer.exerc1;

public class TesteObserver {
    public static void main(String[] args) {
        StockData stockData = new StockData(16.9f);

        Buyer buyer = new Buyer(stockData);
        Seller seller = new Seller(stockData);
        Curioso curioso = new Curioso(stockData);

        stockData.setStockData(18.9f);

        System.out.println("----------------------------------------------------");
        stockData.setStockData(12.9f);
    }
}
