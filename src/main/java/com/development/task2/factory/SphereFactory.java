package com.development.task2.factory;

import com.development.task2.entity.Sphere;
import com.development.task2.entity.Point;

public class SphereFactory{

    private SphereFactory(){
    }

    public static Sphere createSphere(double[] array) {
        Point point = new Point(array[0], array[1], array[2]);
        return new Sphere(point, array[3]);
    }

    public static Sphere createSphere(Point point, double radius) {
        return new Sphere(point, radius);
    }
}