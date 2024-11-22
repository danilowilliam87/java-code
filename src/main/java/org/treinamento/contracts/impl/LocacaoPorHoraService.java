package org.treinamento.contracts.impl;

import org.treinamento.contracts.LocacaoService;
import org.treinamento.contracts.utils.TaxaUtil;

import java.time.Duration;
import java.time.LocalDateTime;

public class LocacaoPorHoraService implements LocacaoService {

    private Double pagamentoBasico;
    private Double valorImposto;
    private Double pagamentoTotal;

    @Override
    public double calcular(LocalDateTime retirada, LocalDateTime retorno, Double valorDiaria, Double valorHora) {
        long horas = calcularHoras(retirada, retorno);
        this.pagamentoBasico = calcularTotal(valorHora, horas);
        this.pagamentoTotal = calcularImposto(this.pagamentoBasico);
        return this.pagamentoTotal;
    }

    @Override
    public double calcularImposto(Double pagamento) {
        this.valorImposto = pagamento * TaxaUtil.definirTaxa(pagamento);
        return this.valorImposto;
    }

    private long calcularHoras(LocalDateTime retirada, LocalDateTime retorno){
        Duration duration = Duration.between(retirada, retorno);
        long horas = duration.toHours();
        long minutos = duration.toMinutes() % 60;

        if(minutos > 0){
            horas++;
        }

        return horas;
    }

    private Double calcularTotal(Double diaria, long horas){
        return diaria * horas;
    }

    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public Double getValorImposto() {
        return valorImposto;
    }

    public Double getPagamentoTotal() {
        return pagamentoTotal;
    }
}
