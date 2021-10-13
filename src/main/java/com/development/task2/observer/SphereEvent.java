package com.development.task2.observer;

import com.development.task2.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {
    public SphereEvent(Object source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}
