package com.development.task2.parser.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.factory.SphereFactory;
import com.development.task2.parser.SphereParser;
import com.development.task2.validator.impl.SphereValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereParserImpl implements SphereParser {
    static final Logger LOGGER = LogManager.getLogger(SphereParserImpl.class);

    @Override
    public Sphere parseParameters(String[] parameterValues) throws SphereException {
        if (parameterValues == null) {
            LOGGER.error("File is empty. No data was found in it.");
            throw new SphereException("File is empty. No data was found in it.");
        }
        double[] tempArray = new double[parameterValues.length];
        int index = 0;
        for (String numberValue : parameterValues) {
            if (SphereValidatorImpl.getInstance().checkParameterValue(numberValue)) {
                tempArray[index++] = Double.parseDouble(numberValue);
            }
        }
        if(!SphereValidatorImpl.getInstance().checkParameterAmount(tempArray)){
            LOGGER.error("The amount of received parameters is invalid.");
            throw new SphereException("The amount of received parameters is invalid.");
        }
        return SphereFactory.createSphere(tempArray);
    }
}
