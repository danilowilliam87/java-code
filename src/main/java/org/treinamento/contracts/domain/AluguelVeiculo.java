package org.treinamento.contracts.domain;

public class AluguelVeiculo {

    private String modeloCarro;
    private String dataRetirada;
    private String dataRetorno;
    private double precoHora;
    private double precoDiaria;

    public AluguelVeiculo() {
        this.modeloCarro = "";
        this.dataRetirada = "";
        this.dataRetorno = "";
        this.precoHora = 0.0;
        this.precoDiaria = 0.0;
    }

    public AluguelVeiculo(String modeloCarro, String dataRetirada, String dataRetorno, double precoHora, double precoDiaria) {
        this.modeloCarro = modeloCarro;
        this.dataRetirada = dataRetirada;
        this.dataRetorno = dataRetorno;
        this.precoHora = precoHora;
        this.precoDiaria = precoDiaria;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    @Override
    public String toString() {
        return "AluguelVeiculo{" +
                "modeloCarro='" + modeloCarro + '\'' +
                ", dataRetirada='" + dataRetirada + '\'' +
                ", dataRetorno='" + dataRetorno + '\'' +
                ", precoHora=" + precoHora +
                ", precoDiaria=" + precoDiaria +
                '}';
    }
}
