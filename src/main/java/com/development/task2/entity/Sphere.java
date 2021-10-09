package com.development.task2.entity;

import com.development.task2.util.SphereIdGenerator;

import java.io.Serializable;

public class Sphere implements Serializable {
    private Point center;
    private double radius;
    private long sphereId;

    public Sphere() {
        center = new Point();
        sphereId = SphereIdGenerator.getCounter();
    }

    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        sphereId = SphereIdGenerator.getCounter();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sphere sphere = (Sphere) o;
        if (Double.compare(sphere.radius, radius) != 0) {
            return false;
        }
        return center == null ? sphere.center != null : center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + center.hashCode();
        result = (int) (result * 31 + radius);
        return result;
    }

    @Override
    public String toString() {
        Class<?> currentClass = getClass();
        return currentClass.getSimpleName() + "{" +
                "center=" + center +
                ", radius=" + radius +
                ", sphereId=" + sphereId +
                '}';
    }
}
