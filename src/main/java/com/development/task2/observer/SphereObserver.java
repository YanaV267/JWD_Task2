package com.development.task2.observer;

public interface SphereObserver {
    void parametersChange(SphereEvent event);
    void changeSurfaceArea(SphereEvent event);
    void changeVolume(SphereEvent event);
}
