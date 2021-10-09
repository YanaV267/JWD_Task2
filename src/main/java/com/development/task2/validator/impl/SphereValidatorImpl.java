package com.development.task2.validator.impl;

import com.development.task2.validator.SphereValidator;

public class SphereValidatorImpl implements SphereValidator {
    private static final SphereValidatorImpl instance = new SphereValidatorImpl();

    private static final String PARAMETER_VALUE_REGEX = "\\d+\\.?\\d*";
    private static final int PARAMETER_AMOUNT_REGEX = 4;

    private SphereValidatorImpl() {

    }

    public static SphereValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public boolean checkParameterValue(String parameterValue) {
        return parameterValue.matches(PARAMETER_VALUE_REGEX) && Double.parseDouble(parameterValue) != 0;
    }

    @Override
    public boolean checkParameterAmount(double[] parameters) {
        return parameters.length == PARAMETER_AMOUNT_REGEX;
    }
}
