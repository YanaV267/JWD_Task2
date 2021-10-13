package com.development.task2.parser;

import com.development.task2.exception.SphereException;

import java.util.List;
import java.util.Optional;

public interface SphereParser {
    List<double[]> parseParameters(String[] parameterValues) throws SphereException;
    Optional<double[]> parseParameters(String parameterValues);
}
