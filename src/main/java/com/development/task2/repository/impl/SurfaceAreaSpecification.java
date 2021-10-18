package com.development.task2.repository.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereSpecification;
import com.development.task2.service.impl.SphereOperationImpl;

public class SurfaceAreaSpecification implements SphereSpecification {
    private final double maxSurfaceArea;

    public SurfaceAreaSpecification(double maxSurfaceArea) {
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Sphere sphere) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        double surfaceArea = sphereOperation.findSurfaceArea(sphere);
        return surfaceArea <= maxSurfaceArea;
    }
}
