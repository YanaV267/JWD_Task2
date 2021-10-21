package test.development.task2.warehouse;

import com.development.task2.entity.Sphere;
import com.development.task2.factory.SphereFactory;
import com.development.task2.service.impl.SphereOperationImpl;
import com.development.task2.warehouse.SphereParameter;
import com.development.task2.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WarehouseTest {
    private Warehouse warehouse;
    private double surfaceArea;
    private double volume;
    private long sphereId;

    @BeforeTest
    public void init() {
        warehouse = Warehouse.getInstance();
        Sphere sphere = SphereFactory.createSphere(8, 3, 1, 2);
        sphereId = sphere.getSphereId();
        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        surfaceArea = sphereOperation.findSurfaceArea(sphere);
        volume = sphereOperation.findVolume(sphere);
    }

    @Test
    public void putNewParameters() {
        double expected = 10;
        warehouse.putParameters(sphereId, surfaceArea, volume);
        double actual = warehouse.getParameters(sphereId).getSurfaceArea();
        Assert.assertEquals(actual, expected, "putting parameters in warehouse is invalid");
    }

    @Test
    public void putParameters() {
        double expected = 39;
        SphereParameter sphereParameter = new SphereParameter();
        sphereParameter.setSurfaceArea(surfaceArea);
        sphereParameter.setVolume(volume);
        warehouse.putParameters(sphereId, sphereParameter);
        double actual = warehouse.getParameters(sphereId).getVolume();
        Assert.assertEquals(actual, expected, "putting parameters in warehouse is invalid");
    }

    @Test
    public void updateParameters() {
        double expected = 27;
        warehouse.putParameters(sphereId, surfaceArea, volume);
        warehouse.updateParameters(sphereId, 27, volume);
        double actual = warehouse.getParameters(sphereId).getVolume();
        Assert.assertEquals(actual, expected, "putting parameters in warehouse is invalid");
    }

}
