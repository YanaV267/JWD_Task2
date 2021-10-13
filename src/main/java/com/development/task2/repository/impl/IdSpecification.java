package com.development.task2.repository.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereSpecification;

public class IdSpecification implements SphereSpecification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return id == sphere.getSphereId();
    }
}
