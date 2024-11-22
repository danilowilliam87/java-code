package org.treinamento.automacao.domain;

import org.treinamento.automacao.utils.LocalDateUtil;

import java.time.LocalDate;

public class Parcela {
    private double valorParcela;
    private LocalDate dataVencimento;

    public Parcela(double valorParcela, LocalDate dataVencimento) {
        this.valorParcela = valorParcela;
        this.dataVencimento = dataVencimento;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    @Override
    public String toString() {
        return LocalDateUtil.parse(this.dataVencimento) + " - " + this.valorParcela;
    }
}
