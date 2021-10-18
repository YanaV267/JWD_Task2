package com.development.task2.validator;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;

public interface SphereValidator {
    boolean checkFile(String path);
    boolean checkReadParameters(String[] parametersValues);
    boolean checkParameterValue(String numberValue);
    boolean checkParameterAmount(double[] parameters);
    boolean checkPlaneCoordinate(Sphere sphere, double y);
    boolean checkPointLocations(Point firstPoint, Point secondPoint);
}
