package org.treinamento.contracts.impl;

import org.treinamento.contracts.LocacaoService;
import org.treinamento.contracts.utils.TaxaUtil;

import java.time.Duration;
import java.time.LocalDateTime;

public class LocacaoPorDiariaService implements LocacaoService {

    private Double pagamentoBasico;
    private Double valorImposto;
    private Double pagamentoTotal;

    @Override
    public double calcular(LocalDateTime retirada, LocalDateTime retorno, Double valorDiaria, Double valorHora) {
        long dias = calcularDiaria(retirada, retorno);
        this.pagamentoBasico = calcularTotal(valorDiaria, dias);
        this.pagamentoTotal += calcularImposto(this.pagamentoBasico);
        return this.pagamentoTotal;
    }

    @Override
    public double calcularImposto(Double pagamento) {
        this.valorImposto = pagamento * TaxaUtil.definirTaxa(pagamento);
        return this.valorImposto;
    }

    private long calcularDiaria(LocalDateTime retirada, LocalDateTime retorno){
        Duration duration = Duration.between(retirada, retorno);
        long dias = duration.toDays();
        long horas = duration.toHours() % 24;

        if(horas > 0){
            dias++;
        }

        return dias;
    }

    private double calcularTotal(Double valorDiaria, long dias){
        return valorDiaria * dias;
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
