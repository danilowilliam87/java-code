package org.treinamento.automacao.impl;

import org.treinamento.automacao.abstractmodel.AbstractContrato;
import org.treinamento.automacao.domain.Contrato;
import org.treinamento.automacao.domain.Parcela;
import org.treinamento.automacao.service.ServicoPagamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PayPal implements ServicoPagamento {

    private static final double TAXA_JUROS_SIMPLES = 0.01;
    private static final double TAXA_PAGAMENTO = 0.02;

    @Override
    public void calcularPagamento(AbstractContrato abstractContrato) {

        Contrato contrato = (Contrato) abstractContrato;

        if(Objects.isNull(contrato)){
            throw new RuntimeException("Contrato não pode ser nulo");
        }

        double valorContrato = (contrato.getValorContrato() / contrato.getNumeroParcelas());
        for (int i = 0; i < contrato.getNumeroParcelas(); i++){
            int contador = 1 + i;
            long diasParaVencimento = (long) Contrato.QTD_DIAS_UTEIS * contador;
            LocalDate dataVencimento = contrato.getDataContrato().plusDays(diasParaVencimento);
            double valorParcela = valorContrato;
            valorParcela += valorParcela * (TAXA_JUROS_SIMPLES * contador);
            valorParcela += valorParcela * TAXA_PAGAMENTO;
            Parcela parcela = new Parcela(valorParcela, dataVencimento);
            contrato.getParcelas().add(parcela);

        }
    }
}
