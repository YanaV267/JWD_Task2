package test.development.task2.service;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.service.impl.SphereOperationImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SphereOperationTest {
    private SphereOperationImpl sphereOperation;
    private Sphere sphere;

    @BeforeTest
    public void init(){
        sphereOperation = new SphereOperationImpl();
        Point center = new Point(4, 3, 7);
        sphere = new Sphere(center, 10);
    }

    @Test
    public void findSurfaceArea() {
        double expected = 10;
        double actual = sphereOperation.findSurfaceArea(sphere);
        Assert.assertEquals(actual, expected, "surface area value is invalid");
    }

    @Test
    public void findVolume() {
        double expected = 15;
        double actual = sphereOperation.findVolume(sphere);
        Assert.assertEquals(actual, expected, "volume value is invalid");
    }

    @Test
    public void findVolumeRatio() throws SphereException {
        double expected = 3.5;
        double actual = sphereOperation.findVolumeRatio(sphere, 2);
        Assert.assertEquals(actual, expected, "volume ratio value is invalid");
    }

    @Test
    public void isTouchingPlane() {
        boolean actual = sphereOperation.isTouchingPlane(sphere);
        Assert.assertTrue(actual, "sphere isn't touching coordinate plane");
    }
}
