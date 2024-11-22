package org.treinamento.automacao.impl;

import org.treinamento.automacao.abstractmodel.AbstractContrato;
import org.treinamento.automacao.service.AutomacaoContrato;
import org.treinamento.automacao.service.ServicoPagamento;

public class AutomacaoContratoImpl implements AutomacaoContrato {

    @Override
    public void processar(AbstractContrato abstractContrato, ServicoPagamento servicoPagamento) {
        servicoPagamento.calcularPagamento(abstractContrato);
    }
}
