package org.treinamento.automacao.service;

import org.treinamento.automacao.abstractmodel.AbstractContrato;
import org.treinamento.automacao.domain.Contrato;
import org.treinamento.automacao.domain.Parcela;


public interface ServicoPagamento {

   void calcularPagamento(AbstractContrato abstractContrato);
}
