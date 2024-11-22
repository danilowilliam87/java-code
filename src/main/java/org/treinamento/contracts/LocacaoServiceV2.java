package org.treinamento.contracts;

import java.time.LocalDateTime;

public interface LocacaoServiceV2 {

    double calcularPagamentoBasico(LocalDateTime retirada, LocalDateTime retorno, double valor);
    double calcularImposto();
    double calcularPagamentoTotal();

}
