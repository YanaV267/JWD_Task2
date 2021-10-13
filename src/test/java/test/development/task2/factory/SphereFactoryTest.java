package test.development.task2.factory;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.factory.SphereFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class SphereFactoryTest {

    @Test
    public void createSphere() throws SphereException {
        double[] parameters = {4, 1, 6, 8};
        Sphere sphere = SphereFactory.createSphere(parameters);
        Assert.assertNotEquals(sphere, null, "sphere creating is invalid");
    }

    @Test(dataProvider = "getParametersForSpheres")
    public void createSpheres(double[][] parameters) throws SphereException {
        List<double[]> spheresParameters = Arrays.stream(parameters).toList();
        List<Sphere> spheres = SphereFactory.createSpheres(spheresParameters);
        Assert.assertNotEquals(spheres.size(), 0, "creating of spheres is invalid");
    }

    @DataProvider(name = "getParametersForSpheres")
    public Object[][] getParametersForSpheres() {
        return new Object[][]{{
                new double[]{4, 1, 6, 8},
                new double[]{3, 4, 1, 9, 7},
                new double[]{7, 1, 2, 6, 2}
        }, {
                new double[]{6, 1, 5, 4},
                new double[]{2, 9, 10, 2, 8, 2},
                new double[]{7, 3, 2, 6, 9}
        }
        };
    }
}