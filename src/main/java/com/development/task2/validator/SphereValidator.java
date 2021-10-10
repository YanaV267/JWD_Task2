package com.development.task2.validator;

import com.development.task2.entity.Sphere;

public interface SphereValidator {
    boolean checkParameterValue(String numberValue);
    boolean checkParameterAmount(double[] parameters);
    boolean checkPlaneCoordinate(Sphere sphere, double y);
}
