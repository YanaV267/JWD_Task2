package com.development.task2.parser.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.parser.SphereParser;
import com.development.task2.validator.SphereValidator;
import com.development.task2.validator.impl.SphereValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Stream;

public class SphereParserImpl implements SphereParser {
    static final Logger LOGGER = LogManager.getLogger(Sphere.class.getSimpleName());
    private static final String DELIMITER_REGEX = "/";

    @Override
    public List<double[]> parseParameters(String[] parametersValues) throws SphereException {
        if (parametersValues == null) {
            LOGGER.error("File is empty. No data was found in it.");
            throw new SphereException("File is empty. No data was found in it.");
        }
        SphereValidator sphereValidator = SphereValidatorImpl.getInstance();
        List<double[]> spheresParameters = Arrays.stream(parametersValues)
                .filter(p -> p.split(DELIMITER_REGEX).length == Arrays.stream(p.split(DELIMITER_REGEX))
                        .filter(sphereValidator::checkParameterValue)
                        .mapToDouble(Double::parseDouble)
                        .count())
                .map(p -> Stream.of(p.split(DELIMITER_REGEX))
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .toList();
        if (spheresParameters.isEmpty()) {
            LOGGER.error("There is no string with valid parameters.");
            throw new SphereException("There is no string with valid parameters.");
        }
        return spheresParameters;
    }

    @Override
    public Optional<double[]> parseParameters(String parametersValues) {
        SphereValidator sphereValidator = SphereValidatorImpl.getInstance();
        String[] parameters = parametersValues.split(DELIMITER_REGEX);
        double[] spheresParameters = Arrays.stream(parameters)
                .filter(sphereValidator::checkParameterValue)
                .mapToDouble(Double::parseDouble)
                .toArray();

        if (spheresParameters.length != parameters.length) {
            LOGGER.error("String is invalid.");
            spheresParameters = null;
        }
        return Optional.ofNullable(spheresParameters);
    }
}
