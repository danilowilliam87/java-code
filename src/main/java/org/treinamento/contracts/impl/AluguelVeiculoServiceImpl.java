package org.treinamento.contracts.impl;

import org.treinamento.contracts.AluguelVeiculoService;
import org.treinamento.contracts.LocacaoService;
import org.treinamento.contracts.LocacaoServiceV2;
import org.treinamento.contracts.domain.AluguelVeiculo;
import org.treinamento.contracts.utils.ConsoleUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class AluguelVeiculoServiceImpl implements AluguelVeiculoService {


    private double pagamentoBasico;
    private double imposto;
    private double total;

    public AluguelVeiculoServiceImpl() {
        this.pagamentoBasico = 0.0;
        this.imposto = 0.0;
        this.total = 0.0;
    }

    @Override
    public String calcularAluguel(AluguelVeiculo aluguelVeiculo) {

        StringBuilder mensagemRetorno = new StringBuilder();
        LocacaoServiceV2 locacaoServiceV2;

        if(Objects.isNull(aluguelVeiculo)
                || Objects.isNull(aluguelVeiculo.getDataRetirada())
                || Objects.isNull(aluguelVeiculo.getDataRetorno())){
            throw new RuntimeException("Objeto veiculo e data não podem ser null");
        }
        LocalDateTime retirada = ConsoleUtils.obterData(aluguelVeiculo.getDataRetirada());
        LocalDateTime retorno = ConsoleUtils.obterData(aluguelVeiculo.getDataRetorno());

        if (definirCobrancaAluguel(retirada, retorno)){
            locacaoServiceV2 = new LocacaoServiceImplPorDiariaV2();
            this.pagamentoBasico = locacaoServiceV2.calcularPagamentoBasico(retirada, retorno, aluguelVeiculo.getPrecoDiaria());
            this.imposto = locacaoServiceV2.calcularImposto();
            this.total = locacaoServiceV2.calcularPagamentoTotal();

        }else{
            locacaoServiceV2 = new LocacaoServiceImplPorHoraV2();
            this.pagamentoBasico = locacaoServiceV2.calcularPagamentoBasico(retirada, retorno, aluguelVeiculo.getPrecoHora());
            this.imposto = locacaoServiceV2.calcularImposto();
            this.total = locacaoServiceV2.calcularPagamentoTotal();
        }


        mensagemRetorno.append("FATURA:");
        mensagemRetorno.append("\n");
        mensagemRetorno.append("Pagamento basico: ");
        mensagemRetorno.append(this.pagamentoBasico);
        mensagemRetorno.append("\n");
        mensagemRetorno.append("Imposto: ");
        mensagemRetorno.append(this.imposto);
        mensagemRetorno.append("\n");
        mensagemRetorno.append("Pagamento total: ");
        mensagemRetorno.append(this.total);

        return mensagemRetorno.toString();
    }

    private boolean definirCobrancaAluguel(LocalDateTime retirada, LocalDateTime retorno){
        return Duration.between(retirada, retorno).toHours() > 12;
    }
}
