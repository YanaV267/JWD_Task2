package com.development.task2.filler;

import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereRepository;

import java.util.List;

public class RepositoryFiller {
    public void fillSphereRepository(Sphere sphere) {
        SphereRepository sphereRepository = SphereRepository.getInstance();
        sphereRepository.add(sphere);
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        warehouseFiller.fillSphereWarehouse(sphere);
    }

    public void fillSphereRepository(List<Sphere> spheres) {
        SphereRepository sphereRepository = SphereRepository.getInstance();
        for (Sphere sphere : spheres) {
            sphereRepository.add(sphere);
        }
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        warehouseFiller.fillSphereWarehouse(spheres);
    }

    public void fillRepository(Sphere sphere) {
        SphereRepository sphereRepository = SphereRepository.getInstance();
        sphereRepository.add(sphere);
    }

    public void fillRepository(List<Sphere> spheres) {
        SphereRepository sphereRepository = SphereRepository.getInstance();
        for (Sphere sphere : spheres) {
            sphereRepository.add(sphere);
        }
    }

}
