package com.rabkov.multithreading.parser;

import com.rabkov.multithreading.exception.MultiException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SEPARATORS = "[ ,;]";
    public List<Integer> parse(String line) throws MultiException {
        String[] elements = line.split(SEPARATORS);
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < elements.length - 1; i++){
            Integer number = Integer.parseInt(elements[i]);
            numbers.add(number);
        }
        String targetString = elements[elements.length - 1].toUpperCase();
        int targetInt;
        if(targetString.equals("LOADING")) {
            targetInt = 1;
        } else if(targetString.equals("UNLOADING")) {
            targetInt = 2;
        } else if(targetString.equals("LOADING_UNLOADING")) {
            targetInt = 0;
        } else {
            logger.error("Ship target incorrect: " + targetString);
            throw new MultiException("Ship target incorrect: " + targetString);
        }
        numbers.add(targetInt);
        return numbers;
    }
}
