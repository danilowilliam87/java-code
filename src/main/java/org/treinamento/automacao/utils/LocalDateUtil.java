package org.treinamento.automacao.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LocalDateUtil {

    public static LocalDate parse(String data){
        if(Objects.isNull(data) || data.isEmpty()){
            throw new RuntimeException("Data inválida");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    public static String parse(LocalDate localDate){
        if(Objects.isNull(localDate)){
            throw new RuntimeException("Data inválida");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(localDate);
    }

    public static LocalDateTime parseWithTimeZone(String data){
        if(Objects.isNull(data) || data.isEmpty()){
            throw new RuntimeException("Data inválida");
        }

        if(data.contains("Z")){
            data = data.replace("Z", "");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(data, formatter);
    }


}
