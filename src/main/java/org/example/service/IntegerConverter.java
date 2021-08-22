package org.example.service;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class IntegerConverter implements Converter {

    private final Pattern numberPattern = Pattern.compile("^\\d+$");

    public long convert(String stringNum) throws Exception {
        Matcher matcher = numberPattern.matcher(stringNum);
        if (matcher.find()) {
            return Long.parseLong(stringNum);
        } else {
            throw new Exception("Illegal number arguments");
        }
    }
}
