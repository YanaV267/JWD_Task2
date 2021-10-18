package com.development.task2.service.impl;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.service.SphereOperation;
import com.development.task2.validator.impl.SphereValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

public class SphereOperationImpl implements SphereOperation {
    static final Logger LOGGER = LogManager.getLogger(SphereOperationImpl.class);

    @Override
    public double findSurfaceArea(Sphere sphere) {
        return 4 * PI * pow(sphere.getRadius(), 2);
    }

    @Override
    public double findVolume(Sphere sphere) {
        return 4d / 3 * PI * pow(sphere.getRadius(), 3);
    }

    @Override
    public double findVolumeRatio(Sphere sphere, double y) throws SphereException {
        if (!SphereValidatorImpl.getInstance().checkPlaneCoordinate(sphere, y)) {
            LOGGER.error("Plane doesn't cross this sphere.");
            throw new SphereException("Plane doesn't cross this sphere.");
        }
        double smallerHeight;
        if (sphere.getCenter().getY() > y) {
            smallerHeight = y - (sphere.getCenter().getY() - sphere.getRadius());
        } else {
            smallerHeight = sphere.getCenter().getY() + sphere.getRadius() - y;
        }
        double smallerVolume = PI * pow(smallerHeight, 2) * (sphere.getRadius() - 1d / 3 * smallerHeight);
        double biggerVolume = findVolume(sphere) - smallerVolume;
        return smallerVolume / biggerVolume;
    }

    @Override
    public boolean isTouchingPlane(Sphere sphere) {
        Point center = sphere.getCenter();
        return center.getX() == 0 || center.getY() == 0 || center.getZ() == 0;
    }
}
