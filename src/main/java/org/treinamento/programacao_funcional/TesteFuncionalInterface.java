package org.treinamento.programacao_funcional;

public class TesteFuncionalInterface {
    public static void main(String[] args) {
        Double v1 = 100.0;
        Double v2 = 102.0;
        OperacaoMatematica operacaoMatematica = (num1, num2) -> {
            return num1 + num2;
        };
        System.out.println("Somar com a Interface Funcional : ");
        System.out.println(operacaoMatematica.calcular(v1, v2));

        operacaoMatematica = (num1, num2)->{
          return num1 - num2;
        };

        System.out.println("Subtrair com a Interface Funcional : ");
        System.out.println(operacaoMatematica.calcular(v1, v2));

    }
}
