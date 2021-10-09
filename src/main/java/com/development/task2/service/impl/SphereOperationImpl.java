package com.development.task2.service.impl;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.service.SphereOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Math.*;

public class SphereOperationImpl implements SphereOperation {
    static final Logger LOGGER = LogManager.getLogger(Point.class.getSimpleName());

    @Override
    public double findSurfaceSquare(Sphere sphere) {
        return 4 * PI * pow(sphere.getRadius(), 2);
    }

    @Override
    public double findVolume(Sphere sphere) {
        return 4d / 3 * PI * pow(sphere.getRadius(), 3);
    }

    @Override
    public boolean isSphere(Sphere sphere) {
        return false;
    }

    @Override
    public double findVolumeRatio(Sphere sphere) {//добавить ещё параметр для разреза (координаты и плоскость?) + return(?)
        return 0;
    }

    @Override
    public boolean isTouchingPlane(Sphere sphere) {
        Point center = sphere.getCenter();
        return center.getX() == 0 || center.getY() == 0 || center.getZ() == 0;
    }
}
