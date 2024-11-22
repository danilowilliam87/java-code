package org.treinamento.contracts.controller;

import org.treinamento.contracts.LocacaoService;
import org.treinamento.contracts.impl.LocacaoPorDiariaService;
import org.treinamento.contracts.impl.LocacaoPorHoraService;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalcularLocacaoController {

    private Double pagamento;
    private Double valorImposto;
    private Double total;
    private String modeloCarro;

    public void calcularLocacao(LocalDateTime retirada, LocalDateTime retorno, Double valorDiaria, Double valorHora){
        LocacaoService locacaoService = null;

        if(verificarDuracaoDoAluguel(retirada, retorno)){
            locacaoService = new LocacaoPorDiariaService();

        }else{
            locacaoService = new LocacaoPorHoraService();

        }

        total = locacaoService.calcular(retirada, retorno, valorDiaria, valorHora);


    }

    public boolean verificarDuracaoDoAluguel(LocalDateTime retirada, LocalDateTime retorno){
        Duration duration = Duration.between(retirada, retorno);
        return duration.toHours() > 12L;
    }


}
