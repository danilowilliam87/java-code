package org.treinamento.programacao_funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TesteEmpregado {
    public static void main(String[] args) {
        Empregado empregado = new Empregado("Danilo", 5000.00);
        Empregado empregado1 = new Empregado("Daniele", 6000.00);
        Empregado empregado2 = new Empregado("Geovana", 3000.00);
        Empregado empregado3 = new Empregado("Miloca", 100000.00);

        List<Empregado> empregados = new ArrayList<>();
        empregados.addAll(Arrays.asList(empregado, empregado1, empregado2, empregado3));

        System.out.println("Ordenação por nome : ");
        empregados.sort((emp1, emp2) -> {
            return emp1.getNome().compareTo(emp2.getNome());
        });

        empregados.forEach(System.out::println);
        System.out.println("Ordenação por salario : ");
        empregados.sort((emp1, emp2) -> {
            return -emp1.getSalario().compareTo(emp2.getSalario());
        });

        empregados.forEach(System.out::println);

        Predicate<Empregado> removeByName = emp -> emp.getNome().equalsIgnoreCase("Miloca");
        empregados.removeIf(Empregado::nonStaticRemoveByName);

        System.out.println("lista após remoção");
        empregados.forEach(System.out::println);

        System.out.println("Aumento de 10%");
        empregados.forEach(emp -> {
            double aumento = emp.getSalario() * (10.0/100.0);
            double novoSalario = emp.getSalario() + aumento;
            emp.setSalario(novoSalario);
        });

        empregados.forEach(System.out::println);

        System.out.println("Nome em caixa alta");
        List<Empregado> novosNomes = empregados
                .stream()
                .map(new CaixaAltaFunction())
                .map(new AumentoSalarioFunction())
                .collect(Collectors.toList());

        novosNomes.forEach(System.out::println);

        Function<Empregado, String> caixaAlta = emp -> emp.getNome().toUpperCase();

        List<String> nomes = empregados
                .stream()
                .map(caixaAlta)
                .collect(Collectors.toList());

        nomes.forEach(System.out::println);


    }



    public static boolean staticRemoveByNome(Empregado empregado){
        return empregado.getNome().equalsIgnoreCase("Miloca");
    }
}
