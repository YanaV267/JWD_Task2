package test.development.task2.factory;


import com.development.task2.entity.Sphere;
import com.development.task2.factory.SphereFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SphereFactoryTest {

    @Test
    public void createSphere() {
        double[] parameters = {4, 1, 6, 8};
        double expected = parameters[3];
        Sphere sphere = SphereFactory.createSphere(parameters);
        Assert.assertEquals(sphere.getRadius(), expected, "sphere creating is invalid");
    }

}