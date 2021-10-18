package com.development.task2.validator.impl;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.validator.SphereValidator;

public class SphereValidatorImpl implements SphereValidator {
    private static final SphereValidatorImpl instance = new SphereValidatorImpl();

    private static final String NUMBER_REGEX = "\\d+\\.?\\d*";
    private static final int MIN_PARAMETER_AMOUNT = 4;
    private static final int MAX_PARAMETER_AMOUNT = 6;

    private SphereValidatorImpl() {

    }

    public static SphereValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public boolean checkReadParameters(String[] parametersValues) {
        return parametersValues != null && parametersValues.length != 0;
    }

    @Override
    public boolean checkFile(String path){
        return getClass().getClassLoader().getResource(path) == null;
    }

    @Override
    public boolean checkParameterValue(String parameterValue) {
        return parameterValue.matches(NUMBER_REGEX) && Double.parseDouble(parameterValue) != 0;
    }

    @Override
    public boolean checkParameterAmount(double[] parameters) {
        return parameters.length == MIN_PARAMETER_AMOUNT || parameters.length == MAX_PARAMETER_AMOUNT;
    }

    @Override
    public boolean checkPlaneCoordinate(Sphere sphere, double y) {
        if (y > sphere.getCenter().getY() + sphere.getRadius()) {
            return false;
        }
        return y >= sphere.getCenter().getY() - sphere.getRadius();
    }

    @Override
    public boolean checkPointLocations(Point firstPoint, Point secondPoint){
        return !firstPoint.equals(secondPoint);
    }
}
