package com.development.task2.repository.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereSpecification;

public class RadiusSpecification implements SphereSpecification {
    private final double minRadius;
    private final double maxRadius;

    public RadiusSpecification(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Sphere sphere) {
        double radius = sphere.getRadius();
        return minRadius <= radius && radius <= maxRadius;
    }
}
