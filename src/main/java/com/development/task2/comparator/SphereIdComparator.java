package com.development.task2.comparator;

import com.development.task2.entity.Sphere;

import java.util.Comparator;

public class SphereIdComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere s1, Sphere s2) {
        return Long.compare(s1.getSphereId(), s2.getSphereId());
    }
}
