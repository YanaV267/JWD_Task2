package com.development.task2.reader.impl;

import com.development.task2.exception.SphereException;
import com.development.task2.reader.SphereReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SphereReaderImpl implements SphereReader {
    private static final String DELIMITER_REGEX = "/";

    @Override
    public String[] readParameters(String path) throws SphereException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new SphereException("file " + path + " doesn't exits in this directory");
        }
        String[] arrayOfParameters;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            arrayOfParameters = reader.lines()
                    .findFirst()
                    .map(line -> line.split(DELIMITER_REGEX)).orElse(null);
        } catch (IOException exception) {
            throw new SphereException("error was found while reading file " + path, exception);
        }
        return arrayOfParameters;
    }
}
