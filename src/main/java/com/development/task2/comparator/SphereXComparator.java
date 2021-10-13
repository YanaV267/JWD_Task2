package com.development.task2.comparator;

import com.development.task2.entity.Sphere;

import java.util.Comparator;

public class SphereXComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere s1, Sphere s2) {
        double firstX = s1.getCenter().getX();
        double secondX = s2.getCenter().getX();
        return (int) (firstX - secondX);
    }
}
