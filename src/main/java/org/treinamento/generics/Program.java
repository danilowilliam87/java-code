package org.treinamento.generics;

public class Program {
    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();
        lista.adicionar("Danilo");
        lista.adicionar("Daniele");
        lista.adicionar("Iris");
        lista.adicionar("Geovana");
        lista.adicionar("mila");
        lista.mostrarTodos();

        lista.substituir("Danilo William", "Danilo");
        lista.mostrarTodos();
    }
}
