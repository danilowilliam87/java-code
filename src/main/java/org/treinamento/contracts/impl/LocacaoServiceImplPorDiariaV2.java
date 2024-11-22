package org.treinamento.contracts.impl;

import org.treinamento.contracts.LocacaoServiceV2;
import org.treinamento.contracts.utils.DataUtils;
import org.treinamento.contracts.utils.TaxaUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class LocacaoServiceImplPorDiariaV2 implements LocacaoServiceV2 {

    private double pagamentoBasico;
    private double imposto;

    public LocacaoServiceImplPorDiariaV2() {
        this.pagamentoBasico = 0.0;
        this.imposto = 0.0;
    }

    @Override
    public double calcularPagamentoBasico(LocalDateTime retirada, LocalDateTime retorno, double valor) {
        this.pagamentoBasico = calcularTotalDiaria(retirada, retorno) * valor;
        return this.pagamentoBasico;
    }

    @Override
    public double calcularImposto() {
        this.imposto = TaxaUtil.definirTaxa(this.pagamentoBasico) * this.pagamentoBasico;
        return this.imposto;
    }

    @Override
    public double calcularPagamentoTotal() {
        return this.pagamentoBasico + this.imposto;
    }

    private long calcularTotalDiaria(LocalDateTime retirada, LocalDateTime retorno){
        if(Objects.isNull(retirada) || Objects.isNull(retorno)){
            throw new RuntimeException("Obrigatório informar hora de retirada e retorno");
        }

        return DataUtils.calcular(retirada, retorno, DataUtils.CALCULAR_ALUGUEL_POR_DIARIA);
    }

    public double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public double getImposto() {
        return imposto;
    }
}
