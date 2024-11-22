package org.treinamento.automacao.abstractmodel;

import org.treinamento.automacao.domain.Parcela;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public  class AbstractContrato {
    protected String numeroContrato;
    protected LocalDate dataContrato;
    protected double valorContrato;
    protected int numeroParcelas;
    protected List<Parcela> parcelas;

    public AbstractContrato() {
    }

    public AbstractContrato(String numeroContrato, LocalDate dataContrato, double valorContrato, int numeroParcelas) {
        this.numeroContrato = numeroContrato;
        this.dataContrato = dataContrato;
        this.valorContrato = valorContrato;
        this.numeroParcelas = numeroParcelas;
        this.parcelas = new ArrayList<>();
    }
}
