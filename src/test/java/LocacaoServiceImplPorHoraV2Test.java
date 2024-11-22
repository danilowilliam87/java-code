import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.treinamento.contracts.impl.LocacaoServiceImplPorHoraV2;

import java.time.LocalDateTime;

public class LocacaoServiceImplPorHoraV2Test {

    @Test
    public void dadoLocacaoMenorQue12Horas_retornarValor(){
        LocacaoServiceImplPorHoraV2 serviceImplPorHoraV2 = new LocacaoServiceImplPorHoraV2();
        LocalDateTime retirada = LocalDateTime.of(2018, 6, 25, 10, 30, 0);
        LocalDateTime retorno = LocalDateTime.of(2018, 6, 25, 14, 40, 0);
        double precoHora = 10.00;
        double pagamentoBasico = serviceImplPorHoraV2.calcularPagamentoBasico(retirada, retorno,precoHora);
        double imposto = serviceImplPorHoraV2.calcularImposto();
        double total = serviceImplPorHoraV2.calcularPagamentoTotal();

        Assertions.assertEquals(50.00, pagamentoBasico);
        Assertions.assertEquals(10.00, imposto);
        Assertions.assertEquals(60.00, total);
    }
}
