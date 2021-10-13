package com.development.task2.entity;

import com.development.task2.observer.Observable;
import com.development.task2.observer.SphereEvent;
import com.development.task2.observer.SphereObserver;
import com.development.task2.util.SphereIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Sphere implements Observable {
    private final long sphereId;
    private Point center;
    private double radius;
    private final List<SphereObserver> observers = new ArrayList<>();

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
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    public long getSphereId() {
        return sphereId;
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
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{");
        sb.append("sphereId=").append(sphereId);
        sb.append(", center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(SphereObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(SphereObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if(observers.isEmpty()){
            return;
        }
        SphereEvent event = new SphereEvent(this);
        observers.forEach(o -> o.parametersChange(event));
    }
}
