package org.treinamento.automacao.service;

import org.treinamento.automacao.abstractmodel.AbstractContrato;

public interface AutomacaoContrato {

    void processar(AbstractContrato abstractContrato, ServicoPagamento servicoPagamento);
}
