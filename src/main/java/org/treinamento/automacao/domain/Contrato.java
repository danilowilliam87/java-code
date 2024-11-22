package org.treinamento.automacao.domain;

import org.treinamento.automacao.abstractmodel.AbstractContrato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato extends AbstractContrato {


    public static final int QTD_DIAS_UTEIS = 30;

    public Contrato() {
        super.numeroContrato = "";
        super.dataContrato = LocalDate.now();
        super.valorContrato = 0.0;
        super.numeroParcelas = 0;
        super.parcelas = new ArrayList<>();
    }

    public Contrato(String numeroContrato, LocalDate dataContrato, double valorContrato, int numeroParcelas) {
        super(numeroContrato, dataContrato, valorContrato, numeroParcelas);
    }

    public String getNumeroContrato() {
        return super.numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        super.numeroContrato = numeroContrato;
    }

    public LocalDate getDataContrato() {
        return super.dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        super.dataContrato = dataContrato;
    }

    public double getValorContrato() {
        return super.valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        super.valorContrato = valorContrato;
    }

    public int getNumeroParcelas() {
        return super.numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        super.numeroParcelas = numeroParcelas;
    }

    public List<Parcela> getParcelas() {
        return  super.parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        super.parcelas = parcelas;
    }
}
