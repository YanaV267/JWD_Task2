package com.development.task2.observer.impl;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.observer.SphereEvent;
import com.development.task2.observer.SphereObserver;
import com.development.task2.service.impl.SphereOperationImpl;
import com.development.task2.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserverImpl implements SphereObserver {
    private static final Logger LOGGER = LogManager.getLogger(SphereObserverImpl.class);

    @Override
    public void parametersChange(SphereEvent event) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        Sphere sphere = event.getSource();

        double surfaceArea = sphereOperation.findSurfaceArea(sphere);
        double volume = sphereOperation.findVolume(sphere);

        Warehouse warehouse = Warehouse.getInstance();
        try {
            warehouse.updateParameters(sphere.getSphereId(), surfaceArea, volume);
        } catch (SphereException exception) {
            LOGGER.error("exception {} in update parameters value" + exception.getMessage());
        }
    }
}
