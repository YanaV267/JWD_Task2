package com.development.task2.factory;

import com.development.task2.entity.Sphere;
import com.development.task2.entity.Point;
import com.development.task2.exception.SphereException;
import com.development.task2.validator.impl.SphereValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class SphereFactory {
    static final Logger LOGGER = LogManager.getLogger(Sphere.class.getSimpleName());
    private static final int FIRST_PARAMETER_AMOUNT_REGEX = 4;
    private static final int SECOND_PARAMETER_AMOUNT_REGEX = 6;

    private SphereFactory() {
    }

    public static List<Sphere> createSpheres(List<double[]> spheresParameters) throws SphereException {
        List<Sphere> spheres = new ArrayList<>();
        for (double[] sphereParameters : spheresParameters) {
            if (SphereValidatorImpl.getInstance().checkParameterAmount(sphereParameters)) {
                Sphere sphere = createSphere(sphereParameters);
                spheres.add(sphere);
            }
        }
        return spheres;
    }

    public static Sphere createSphere(double... parameters) throws SphereException {
        if (parameters.length == FIRST_PARAMETER_AMOUNT_REGEX) {
            return createSphere(new Point(parameters[0], parameters[1], parameters[2]), parameters[3]);
        }
        if (parameters.length == SECOND_PARAMETER_AMOUNT_REGEX) {
            return createFromTwoPoints(parameters);
        }
        return null;
    }

    public static Sphere createSphere(Point point, double radius) {
        return new Sphere(point, radius);
    }

    public static Sphere createFromTwoPoints(double[] array) throws SphereException {
        Point firstPoint = new Point(array[0], array[1], array[2]);
        Point secondPoint = new Point(array[3], array[4], array[5]);
        if (SphereValidatorImpl.getInstance().checkPointLocations(firstPoint, secondPoint)) {
            double diameter = sqrt(pow(secondPoint.getX() - firstPoint.getX(), 2) +
                    pow(secondPoint.getY() - firstPoint.getY(), 2) +
                    pow(secondPoint.getZ() - firstPoint.getZ(), 2));
            double centerX = abs(secondPoint.getX() - firstPoint.getX()) / 2;
            double centerY = abs(secondPoint.getY() - firstPoint.getY()) / 2;
            double centerZ = abs(secondPoint.getZ() - firstPoint.getZ()) / 2;
            return new Sphere(new Point(centerX, centerY, centerZ), diameter / 2);
        } else {
            LOGGER.error("The coordinates of points are similar (invalid data).");
            throw new SphereException("The coordinates of points are similar (invalid data).");
        }
    }
}