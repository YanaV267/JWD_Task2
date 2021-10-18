package com.development.task2.comparator;

import com.development.task2.entity.Sphere;

import java.util.Comparator;

public class SphereYComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere s1, Sphere s2) {
        double firstY = s1.getCenter().getY();
        double secondY = s2.getCenter().getY();
        return Double.compare(firstY, secondY);
    }
}
