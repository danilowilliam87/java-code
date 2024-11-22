package org.treinamento.contracts.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class DataUtils {

    private static final int HORAS = 24;
    private static final int MINUTOS = 60;
    public static String CALCULAR_ALUGUEL_POR_DIARIA = "DIARIA";
    public static String CALCULAR_ALUGUEL_POR_HORAS = "HORAS";

    public static long calcular(LocalDateTime retirada,
                                LocalDateTime retorno,
                                String parametroCalculo){
        long tempo = 0L;
        Duration duracao = Duration.between(retirada, retorno);

        if(CALCULAR_ALUGUEL_POR_DIARIA.equalsIgnoreCase(parametroCalculo)){
           tempo = duracao.toDays();
           long horas = duracao.toHours() % HORAS;

           if(horas > 0){
               tempo++;
           }
        }

        if(CALCULAR_ALUGUEL_POR_HORAS.equalsIgnoreCase(parametroCalculo)){
            tempo = duracao.toHours();
            long minutos = duracao.toMinutes() % MINUTOS;

            if(minutos > 0){
                tempo++;
            }
        }

        return tempo;
    }
}
