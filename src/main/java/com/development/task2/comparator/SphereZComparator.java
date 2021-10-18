package com.development.task2.comparator;

import com.development.task2.entity.Sphere;

import java.util.Comparator;

public class SphereZComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere s1, Sphere s2) {
        double firstZ = s1.getCenter().getZ();
        double secondZ = s2.getCenter().getZ();
        return Double.compare(firstZ, secondZ);
    }
}
