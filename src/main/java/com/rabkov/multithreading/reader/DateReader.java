package com.rabkov.multithreading.reader;

import com.rabkov.multithreading.exception.MultiException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateReader {
    private static final Logger logger = LogManager.getLogger();
    public static List<String> fileReading(String path) throws MultiException {
        if (path == null) {
            throw new MultiException("Path is null");
        }
        Path filePath = Paths.get(path);
        List<String> lines;
        try (Stream<String> streamLines = Files.lines(filePath)) {
            lines = streamLines.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("File in " + path + " not found", e);
            throw new MultiException("File in " + path + " not found", e);
        }
        return lines;
    }
}
