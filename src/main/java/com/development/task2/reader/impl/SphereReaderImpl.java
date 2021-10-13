package com.development.task2.reader.impl;

import com.development.task2.exception.SphereException;
import com.development.task2.reader.SphereReader;
import com.development.task2.validator.impl.SphereValidatorImpl;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

public class SphereReaderImpl implements SphereReader {

    @Override
    public String[] readParameters(String path) throws SphereException {
        if (SphereValidatorImpl.getInstance().checkFile(path)) {
            throw new SphereException("file " + path + " doesn't exits in this directory");
        }
        String filePath = URLDecoder.decode(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getPath(),
                StandardCharsets.UTF_8);
        filePath = filePath.replace("/", "\\\\").substring(2);

        String[] arrayOfParameters;
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            arrayOfParameters = lines.toArray(String[]::new);
        } catch (IOException exception) {
            throw new SphereException("error was found while reading file " + path, exception);
        }
        return arrayOfParameters;
    }
}
