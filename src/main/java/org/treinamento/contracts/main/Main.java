package org.treinamento.contracts.main;

import org.treinamento.contracts.AluguelVeiculoService;
import org.treinamento.contracts.domain.AluguelVeiculo;
import org.treinamento.contracts.impl.AluguelVeiculoServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        AluguelVeiculoServiceImpl aluguelVeiculoService = new AluguelVeiculoServiceImpl();

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro:");
        String nomeVeiculo = teclado.nextLine();

        System.out.print("Retirada (dd/MM/yyyy hh:mm):");
        String dataRetirada = teclado.nextLine();

        System.out.print("Retorno (dd/MM/yyyy hh:mm):");
        String dataRetorno = teclado.nextLine();

        System.out.print("Entre com o preço por hora:");
        double precoPorHora = teclado.nextDouble();

        System.out.print("Entre com o preço por dia:");
        double precoPorDia = teclado.nextDouble();

        AluguelVeiculo aluguelVeiculo = new AluguelVeiculo(nomeVeiculo,dataRetirada, dataRetorno, precoPorHora, precoPorDia);
        System.out.println("DADOS DO VEÍCULO ALUGADO : " + aluguelVeiculo);
        System.out.println(aluguelVeiculoService.calcularAluguel(aluguelVeiculo));

        teclado.close();
    }
}
