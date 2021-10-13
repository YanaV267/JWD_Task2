package com.development.task2.filler;

import com.development.task2.entity.Sphere;
import com.development.task2.service.impl.SphereOperationImpl;
import com.development.task2.warehouse.Warehouse;

import java.util.List;

public class WarehouseFiller {
    public void fillSphereWarehouse(Sphere sphere) {
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        double surfaceArea = sphereOperation.findSurfaceArea(sphere);
        double volume = sphereOperation.findVolume(sphere);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.putParameters(sphere.getSphereId(), surfaceArea, volume);
    }

    public void fillSphereWarehouse(List<Sphere> spheres) {
        for (Sphere sphere : spheres) {
            fillSphereWarehouse(sphere);
        }
    }
}
