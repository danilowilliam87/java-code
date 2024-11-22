import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.treinamento.contracts.impl.LocacaoServiceImplPorDiariaV2;

import java.time.LocalDateTime;

public class LocacaoServiceImplPorDiariaV2Test {

    @Test
    public void dadoValores_calcularValorDiaria(){
        LocacaoServiceImplPorDiariaV2 locacaoServiceImplPorDiariaV2 = new LocacaoServiceImplPorDiariaV2();
        LocalDateTime retirada = LocalDateTime.of(2018,6, 25, 10,30,0);
        LocalDateTime retorno = LocalDateTime.of(2018,6, 27, 11,40,0);
        double valorDiaria = 130.00;
        double pagamentoBasico = locacaoServiceImplPorDiariaV2.calcularPagamentoBasico(retirada, retorno, valorDiaria);
        double imposto = locacaoServiceImplPorDiariaV2.calcularImposto();
        double total = locacaoServiceImplPorDiariaV2.calcularPagamentoTotal();

        Assertions.assertEquals(390.00, pagamentoBasico);
        Assertions.assertEquals(58.50, imposto);
        Assertions.assertEquals(448.50, total);
    }
}
