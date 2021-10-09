package com.development.task2.service;

import com.development.task2.entity.Sphere;

public interface SphereOperation {
    double findSurfaceSquare(Sphere sphere);
    double findVolume(Sphere sphere);
    boolean isSphere(Sphere sphere);
    double findVolumeRatio(Sphere sphere);
    boolean isTouchingPlane(Sphere sphere);
}
