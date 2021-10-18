package com.development.task2.observer.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.observer.SphereEvent;
import com.development.task2.observer.SphereObserver;
import com.development.task2.service.impl.SphereOperationImpl;
import com.development.task2.warehouse.SphereParameter;
import com.development.task2.warehouse.Warehouse;

public class SphereObserverImpl implements SphereObserver {

    @Override
    public void parametersChange(SphereEvent event) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        Sphere sphere = event.getSource();

        double surfaceArea = sphereOperation.findSurfaceArea(sphere);
        double volume = sphereOperation.findVolume(sphere);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.updateParameters(sphere.getSphereId(), surfaceArea, volume);
    }

    @Override
    public void changeSurfaceArea(SphereEvent event) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        Warehouse warehouse = Warehouse.getInstance();
        Sphere sphere = event.getSource();

        long sphereId = sphere.getSphereId();
        SphereParameter sphereParameter = warehouse.getParameters(sphereId);

        double surfaceArea = sphereOperation.findSurfaceArea(sphere);
        sphereParameter.setSurfaceArea(surfaceArea);
        warehouse.putParameters(sphereId, sphereParameter);
    }

    @Override
    public void changeVolume(SphereEvent event) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        Warehouse warehouse = Warehouse.getInstance();
        Sphere sphere = event.getSource();

        long sphereId = sphere.getSphereId();
        SphereParameter sphereParameter = warehouse.getParameters(sphereId);

        double volume = sphereOperation.findVolume(sphere);
        sphereParameter.setVolume(volume);
        warehouse.putParameters(sphereId, sphereParameter);
    }
}
