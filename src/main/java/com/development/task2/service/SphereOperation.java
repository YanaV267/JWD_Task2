package com.development.task2.service;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;

public interface SphereOperation {
    double findSurfaceArea(Sphere sphere);
    double findVolume(Sphere sphere);
    double findVolumeRatio(Sphere sphere, double y) throws SphereException;
    boolean isTouchingPlane(Sphere sphere);
}
