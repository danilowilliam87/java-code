package org.treinamento.generics;

import java.util.ArrayList;
import java.util.List;

public class Lista<T> {

    private List<T> lista;

    public Lista() {
        this.lista = new ArrayList<T>();
    }

    public void adicionar(T t){
        lista.add(t);
    }

    public boolean remover(T t){
        if (lista.contains(t)){
            lista.remove(t);
            return true;
        }
        return false;
    }

    public void mostrarTodos(){
        System.out.println("##################################");
        this.lista.forEach(System.out::println);
    }

    public boolean substituir(T in, T out){
        if (this.lista.contains(out)){
            int index = this.lista.indexOf(out);
            this.lista.set(index, in);
            return true;
        }
        return false;
    }
}
