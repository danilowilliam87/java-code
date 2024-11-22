package org.treinamento.programacao_funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FuncaoComoParametro {
    public static void main(String[] args) {

        Empregado empregado = new Empregado("Danilo", 5000.00);
        Empregado empregado1 = new Empregado("Daniele", 6000.00);
        Empregado empregado2 = new Empregado("Geovana", 3000.00);
        Empregado empregado3 = new Empregado("Miloca", 100000.00);

        List<Empregado> empregados = new ArrayList<>();
        empregados.addAll(Arrays.asList(empregado, empregado1, empregado2, empregado3));

        System.out.println("Filtrar por salário");
        List<Empregado> filtrarPorSalario = filtrarPor(empregados, emp -> emp.getSalario() < 7000.00);
        filtrarPorSalario.forEach(System.out::println);

        System.out.println("Filtrar Pela primeira letra do nome");

        List<Empregado> filtrarPorNome = filtrarPor(empregados, e -> e.getNome().startsWith("D"));
        filtrarPorNome.forEach(System.out::println);

    }


    public static List<Empregado> filtrarPor(List<Empregado> lista, Predicate<Empregado> predicado){
        return lista.
                stream()
                .filter(predicado)
                .sorted(Empregado::compareTo)
                .collect(Collectors.toList());
    }
}
