package org.treinamento.contracts.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ConsoleUtils {

    public static LocalDateTime obterData(String data){
        if(Objects.isNull(data)){
            throw new RuntimeException("Erro : dado invalido ->" + data);
        }
        data = data.replace(" ", "T");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss");
        return LocalDateTime.parse(data, format);
    }


}
