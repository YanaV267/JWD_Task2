package com.development.task2.repository;

import com.development.task2.entity.Sphere;

@FunctionalInterface
public interface SphereSpecification {
    boolean specify(Sphere sphere);
}
