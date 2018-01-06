package pl.kostrowski.mtga.MakeTasksGreatAgain.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    public LocalDateTime convert(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(source, formatter);
    }
}