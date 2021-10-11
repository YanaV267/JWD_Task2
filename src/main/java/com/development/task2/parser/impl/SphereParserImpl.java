package com.development.task2.parser.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.factory.SphereFactory;
import com.development.task2.parser.SphereParser;
import com.development.task2.validator.impl.SphereValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SphereParserImpl implements SphereParser {
    static final Logger LOGGER = LogManager.getLogger(Sphere.class.getSimpleName());
    private static final String DELIMITER_REGEX = "/";

    @Override
    public Sphere parseParameters(String[] parameterStrings) throws SphereException {
        if (parameterStrings == null) {
            LOGGER.error("File is empty. No data was found in it.");
            throw new SphereException("File is empty. No data was found in it.");
        }
        double[] parametersArray = null;
        int index = 0;
        while (parametersArray == null && index != parameterStrings.length) {
            parametersArray = Arrays.stream(parameterStrings[index++].split(DELIMITER_REGEX))
                    .filter(value -> SphereValidatorImpl.getInstance().checkParameterValue(value))
                    .mapToDouble(Double::parseDouble).toArray();
            if (parametersArray.length != parameterStrings.length ||
                    !SphereValidatorImpl.getInstance().checkParameterAmount(parametersArray)) {
                parametersArray = null;
            }
        }
        if (parametersArray == null) {
            LOGGER.error("There is no string with necessary amount of parameters.");
            throw new SphereException("There is no string with necessary amount of parameters.");
        }
        return SphereFactory.createSphere(parametersArray);
    }
}
