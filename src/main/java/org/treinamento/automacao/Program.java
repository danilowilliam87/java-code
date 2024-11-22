package org.treinamento.automacao;

import org.treinamento.automacao.domain.Contrato;
import org.treinamento.automacao.impl.AutomacaoContratoImpl;
import org.treinamento.automacao.impl.PayPal;
import org.treinamento.automacao.service.AutomacaoContrato;
import org.treinamento.automacao.service.ServicoPagamento;
import org.treinamento.automacao.utils.LocalDateUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Entre os dados do contrato");
        System.out.print("Numero: ");
        String numeroContrato = teclado.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDateUtil.parse(teclado.nextLine());

        System.out.print("Valor do contrato: ");
        double valorContrato = teclado.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int numeroParcelas = teclado.nextInt();

        ServicoPagamento servicoPagamento = new PayPal();
        Contrato contrato = new Contrato(numeroContrato, data, valorContrato, numeroParcelas);
        AutomacaoContrato automacaoContrato = new AutomacaoContratoImpl();

        automacaoContrato.processar(contrato, servicoPagamento);

        System.out.println("PARCELAS");
        contrato.getParcelas().forEach(System.out::println);


        teclado.close();
    }
}
