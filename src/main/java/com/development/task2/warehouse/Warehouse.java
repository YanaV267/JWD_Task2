package com.development.task2.warehouse;

import com.development.task2.exception.SphereException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger LOGGER = LogManager.getLogger(Warehouse.class);
    private static Warehouse instance;
    private final Map<Long, SphereParameter> shapeParameters;

    private Warehouse() {
        shapeParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putParameters(long sphereId, double surfaceSquare, double volume) {
        SphereParameter sphereParameter = new SphereParameter();
        sphereParameter.setSurfaceArea(surfaceSquare);
        sphereParameter.setVolume(volume);
        shapeParameters.put(sphereId, sphereParameter);
    }

    public void putParameters(long sphereId, SphereParameter sphereParameter) {
        shapeParameters.put(sphereId, sphereParameter);
    }

    public SphereParameter getParameters(long sphereId) {
        return shapeParameters.get(sphereId);
    }

    public void updateParameters(long sphereId, double surfaceSquare, double volume) throws SphereException {
        SphereParameter sphereParameter = shapeParameters.get(sphereId);
        if (sphereParameter == null) {
            LOGGER.error("There is no sphere with such ID.");
            throw new SphereException("There is no sphere with such ID.");
        }
        sphereParameter.setSurfaceArea(surfaceSquare);
        sphereParameter.setVolume(volume);
    }
}
