package com.development.task2.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger LOGGER = LogManager.getLogger(Warehouse.class);
    private static Warehouse instance;
    private final Map<Long, SphereParameter> sphereParameters;

    private Warehouse() {
        sphereParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(long sphereId, double surfaceArea, double volume) {
        SphereParameter sphereParameter = new SphereParameter();
        sphereParameter.setSurfaceArea(surfaceArea);
        sphereParameter.setVolume(volume);
        sphereParameters.put(sphereId, sphereParameter);
    }

    public void putParameters(long sphereId, SphereParameter sphereParameter) {
        sphereParameters.put(sphereId, sphereParameter);
    }

    public SphereParameter getParameters(long sphereId) {
        return sphereParameters.get(sphereId);
    }

    public boolean updateParameters(long sphereId, double surfaceArea, double volume) {
        SphereParameter sphereParameter = sphereParameters.get(sphereId);
        if (sphereParameter == null) {
            LOGGER.error("There is no sphere with such ID.");
            return false;
        }
        sphereParameter.setSurfaceArea(surfaceArea);
        sphereParameter.setVolume(volume);
        return true;
    }

    public boolean updateSurfaceArea(long sphereId, double surfaceArea) {
        SphereParameter sphereParameter = sphereParameters.get(sphereId);
        if (sphereParameter == null) {
            LOGGER.error("There is no sphere with such ID.");
            return false;
        }
        sphereParameter.setSurfaceArea(surfaceArea);
        return true;
    }

    public boolean updateVolume(long sphereId, double volume) {
        SphereParameter sphereParameter = sphereParameters.get(sphereId);
        if (sphereParameter == null) {
            LOGGER.error("There is no sphere with such ID.");
            return false;
        }
        sphereParameter.setVolume(volume);
        return true;
    }
}
