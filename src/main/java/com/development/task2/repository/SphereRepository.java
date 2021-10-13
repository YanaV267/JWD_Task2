package com.development.task2.repository;

import com.development.task2.entity.Sphere;

import java.util.*;

public class SphereRepository {
    private static final SphereRepository instance = new SphereRepository();
    private final List<Sphere> spheres;

    private SphereRepository() {
        spheres = new ArrayList<>();
    }

    public static SphereRepository getInstance() {
        return instance;
    }

    public List<Sphere> getSpheres() {
        return Collections.unmodifiableList(spheres);
    }

    public int size() {
        return spheres.size();
    }

    public boolean isEmpty() {
        return spheres.isEmpty();
    }

    public boolean add(Sphere sphere) {
        return spheres.add(sphere);
    }

    public boolean remove(Sphere sphere) {
        return spheres.remove(sphere);
    }

    public Sphere remove(int index) {
        return spheres.remove(index);
    }

    public boolean addAll(Collection<? extends Sphere> collection) {
        return spheres.addAll(collection);
    }

    public boolean removeAll(Collection<? extends Sphere> collection) {
        return spheres.removeAll(collection);
    }

    public Sphere get(int index) {
        return spheres.get(index);
    }

    public Sphere set(int index, Sphere element) {
        return spheres.set(index, element);
    }

    public List<Sphere> query(SphereSpecification specification) {
        return spheres.stream().filter(specification::specify).toList();
    }

    public List<Sphere> sort(Comparator<? super Sphere> comparator) {
        return spheres.stream().sorted(comparator).toList();
    }
}
