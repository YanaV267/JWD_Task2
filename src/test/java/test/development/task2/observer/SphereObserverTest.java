package test.development.task2.observer;

import com.development.task2.entity.Sphere;
import com.development.task2.factory.SphereFactory;
import com.development.task2.service.impl.SphereOperationImpl;
import com.development.task2.warehouse.SphereParameter;
import com.development.task2.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SphereObserverTest {
    private Warehouse warehouse;
    private Sphere sphere;

    @BeforeTest
    public void init() {
        warehouse = Warehouse.getInstance();
        sphere = SphereFactory.createSphere(4, 8, 1, 11);

        SphereOperationImpl sphereOperation = new SphereOperationImpl();
        SphereParameter sphereParameters = new SphereParameter();
        double surfaceArea = sphereOperation.findSurfaceArea(sphere);
        double volume = sphereOperation.findVolume(sphere);
        sphereParameters.setSurfaceArea(surfaceArea);
        sphereParameters.setVolume(volume);
        warehouse.putParameters(sphere.getSphereId(), sphereParameters);
    }

    @Test
    public void parametersChange() {
        double expected = warehouse.getParameters(sphere.getSphereId()).getSurfaceArea();
        sphere.setRadius(10);
        double actual = warehouse.getParameters(sphere.getSphereId()).getSurfaceArea();
        Assert.assertEquals(actual, expected, "change of sphere parameters is invalid");
    }

}
