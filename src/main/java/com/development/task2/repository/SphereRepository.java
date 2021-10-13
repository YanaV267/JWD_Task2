package com.development.task2.repository;

import com.development.task2.entity.Sphere;

import java.util.*;

public class SphereRepository {
    private static final SphereRepository instance = new SphereRepository();
    private List<Sphere> spheres;

    private SphereRepository() {
        spheres = new ArrayList<>();
    }

    public static SphereRepository getInstance() {
        return instance;
    }

    public List<Sphere> getSpheres() {
        return Collections.unmodifiableList(spheres);
    }

    public boolean add(Sphere sphere) {
        return spheres.add(sphere);
    }

    public boolean addAll(Collection<? extends Sphere> spheres) {
        return this.spheres.addAll(spheres);
    }

    public void remove(Sphere sphere) {
        spheres.remove(sphere);
    }

    public boolean removeAll(Collection<? extends Sphere> spheres) {
        return this.spheres.removeAll(spheres);
    }

    public Sphere get(int index) {
        return spheres.get(index);
    }

    public Sphere set(int index, Sphere sphere) {
        return spheres.set(index, sphere);
    }

    public List<Sphere> query(SphereSpecification specification) {
        return spheres.stream().filter(specification::specify).toList();
    }

    public List<Sphere> sort(Comparator<? super Sphere> comparator) {
        return spheres.stream().sorted(comparator).toList();
    }
}
