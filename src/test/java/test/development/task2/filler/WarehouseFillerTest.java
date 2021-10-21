package test.development.task2.filler;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.factory.SphereFactory;
import com.development.task2.filler.WarehouseFiller;
import com.development.task2.service.impl.SphereOperationImpl;
import com.development.task2.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WarehouseFillerTest {
    private WarehouseFiller warehouseFiller;
    private SphereOperationImpl sphereOperation;

    @BeforeTest
    public void init() {
        warehouseFiller = new WarehouseFiller();
        sphereOperation = new SphereOperationImpl();
    }

    @Test
    public void fillSphereWarehouse() {
        Sphere sphere = new Sphere(new Point(3, 5, 6), 12);
        warehouseFiller.fillSphereWarehouse(sphere);

        double expected = sphereOperation.findSurfaceArea(sphere);
        double actual = Warehouse.getInstance().getParameters(sphere.getSphereId()).getSurfaceArea();
        Assert.assertEquals(actual, expected, "filling of warehouse is invalid");
    }

    @Test(dataProvider = "getParametersForSpheres")
    public void fillSphereWarehouse(double[][] parameters) {
        List<double[]> spheresParameters = Arrays.stream(parameters).toList();
        List<Sphere> spheres = SphereFactory.createSpheres(spheresParameters);
        warehouseFiller.fillSphereWarehouse(spheres);

        double expected = sphereOperation.findSurfaceArea(spheres.get(0));
        double actual = Warehouse.getInstance().getParameters(spheres.get(0).getSphereId()).getSurfaceArea();
        Assert.assertEquals(actual, expected, "filling of warehouse is invalid");
    }

    @DataProvider(name = "getParametersForSpheres")
    public Object[][] getParametersForSpheres() {
        return new Object[][]{{
                new double[]{4, 1, 6, 8},
                new double[]{3, 4, 1, 9},
                new double[]{7, 1, 2, 6, 2}
        }, {
                new double[]{6, 1, 5, 4},
                new double[]{2, 9, 10, 2, 8, 2},
                new double[]{7, 3, 6, 9}
        }};
    }
}
