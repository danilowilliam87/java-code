import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.treinamento.contracts.impl.LocacaoPorDiariaService;

import java.time.LocalDateTime;

public class LocacaoPorDiariaServiceTest {

    static LocacaoPorDiariaService locacaoPorDiariaService;

    @BeforeAll
    public static void carregar(){
        locacaoPorDiariaService = new LocacaoPorDiariaService();
    }

    @Test
    public void dadoValores_calcularValorDiaria(){
        LocalDateTime retirada = LocalDateTime.of(2018,6, 25, 10,30,0);
        LocalDateTime retorno = LocalDateTime.of(2018,6, 27, 11,40,0);
        Double valorHora = 10.00;
        Double valorDiaria = 130.00;
        double total = locacaoPorDiariaService.calcular(retirada,retorno, valorDiaria, valorHora);
        Assertions.assertEquals(448.50, total);
    }
}
