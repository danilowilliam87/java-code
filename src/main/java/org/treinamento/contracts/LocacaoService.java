package org.treinamento.contracts;

import java.time.LocalDateTime;


public interface LocacaoService {
     double calcular(LocalDateTime retirada,
                     LocalDateTime retorno,
                     Double valorDiaria,
                     Double valorHora);

     double calcularImposto(Double pagamento);
}
