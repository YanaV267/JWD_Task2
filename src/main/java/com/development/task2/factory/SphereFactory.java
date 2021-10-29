package com.development.task2.factory;

import com.development.task2.entity.Sphere;
import com.development.task2.entity.Point;
import com.development.task2.exception.SphereException;
import com.development.task2.observer.impl.SphereObserverImpl;
import com.development.task2.validator.impl.SphereValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static java.lang.Math.*;

public class SphereFactory {
    static final Logger LOGGER = LogManager.getLogger(SphereFactory.class);
    private static final int FIRST_PARAMETER_AMOUNT = 4;
    private static final int SECOND_PARAMETER_AMOUNT = 6;

    private SphereFactory() {
    }

    public static List<Sphere> createSpheres(List<double[]> spheresParameters) {
        return spheresParameters.stream()
                .filter(p -> SphereValidatorImpl.getInstance().checkParameterAmount(p))
                .map(SphereFactory::createSphere)
                .toList();
    }

    public static Sphere createSphere(double... parameters) {
        if (parameters.length == FIRST_PARAMETER_AMOUNT) {
            return createSphere(parameters[0], parameters[1], parameters[2], parameters[3]);
        }
        if (parameters.length == SECOND_PARAMETER_AMOUNT) {
            try {
                return createFromTwoPoints(parameters);
            } catch (SphereException exception) {
                LOGGER.error("Error of creating sphere object." + exception);
            }
        }
        LOGGER.error("Error of creating sphere object: invalid parameter amount.");
        return null;
    }

    public static Sphere createSphere(Point center, double radius) {
        Sphere sphere = new Sphere(center, radius);
        sphere.attach(new SphereObserverImpl());
        return sphere;
    }

    public static Sphere createSphere(double x, double y, double z, double radius) {
        Point center = new Point(x, y, z);
        Sphere sphere = new Sphere(center, radius);
        sphere.attach(new SphereObserverImpl());
        return sphere;
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
            Point center = new Point(centerX, centerY, centerZ);
            Sphere sphere = new Sphere(center, diameter / 2);
            sphere.attach(new SphereObserverImpl());
            return sphere;
        } else {
            LOGGER.error("The coordinates of points are similar (invalid data).");
            throw new SphereException("The coordinates of points are similar (invalid data).");
        }
    }
}