package com.development.task2.comparator;

import com.development.task2.entity.Sphere;

import java.util.Comparator;

public class SphereRadiusComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere s1, Sphere s2) {
        return Double.compare(s1.getRadius(), s2.getRadius());
    }
}
