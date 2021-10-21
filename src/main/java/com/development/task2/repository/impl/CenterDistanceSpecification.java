package com.development.task2.repository.impl;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereSpecification;

import static java.lang.Math.*;

public class CenterDistanceSpecification implements SphereSpecification {
    private final double distance;
    private final Point point;

    public CenterDistanceSpecification(Point point, double distance) {
        this.point = point;
        this.distance = distance;
    }

    @Override
    public boolean specify(Sphere sphere) {
        Point center = sphere.getCenter();
        double currentDistance = sqrt(pow(center.getX() - point.getX(), 2) + pow(center.getY() - point.getY(), 2) +
                pow(center.getZ() - point.getZ(), 2));
        return Double.valueOf(currentDistance).equals(distance);
    }
}
