package com.development.task2.repository.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereSpecification;
import com.development.task2.service.impl.SphereOperationImpl;

public class VolumeSpecification implements SphereSpecification {
    private final double minVolume;
    private final double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Sphere sphere) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        double volume = sphereOperation.findVolume(sphere);
        return minVolume <= volume && volume <= maxVolume;
    }
}
