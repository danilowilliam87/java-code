import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.treinamento.contracts.impl.LocacaoPorHoraService;

import java.time.LocalDateTime;


public class LocacaoPorHoraServiceTest {

    static LocacaoPorHoraService locacaoPorHoraService;

    @BeforeAll
    public static void carregar(){
        locacaoPorHoraService = new LocacaoPorHoraService();
    }

    @Test
    public void dadoLocacaoMenorQue12Horas_retornarValor(){
        LocalDateTime retirada = LocalDateTime.of(2018, 6, 25, 10, 30, 0);
        LocalDateTime retorno = LocalDateTime.of(2018, 6, 25, 14, 40, 0);
        Double precoHora = 10.00;
        Double precoDiaria = 130.00;
        Double total = locacaoPorHoraService.calcular(retirada,retorno,precoDiaria, precoHora);
        Assertions.assertEquals(60.00, total);
    }
}
