package test.development.task2.filler;

import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.factory.SphereFactory;
import com.development.task2.filler.RepositoryFiller;
import com.development.task2.repository.SphereRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RepositoryFillerTest {
    private RepositoryFiller repositoryFiller;
    private SphereRepository sphereRepository;

    @BeforeTest
    public void init() {
        repositoryFiller = new RepositoryFiller();
        sphereRepository = SphereRepository.getInstance();
    }

    @Test
    public void fillSphereRepository() {
        Sphere sphere = new Sphere(new Point(3, 5, 6), 12);
        repositoryFiller.fillSphereRepository(sphere);

        double expected = 5;
        double actual = sphereRepository.size();
        Assert.assertEquals(actual, expected, "filling of repository is invalid");
    }

    @Test(dataProvider = "getParametersForSpheres")
    public void fillSphereRepository(double[][] parameters) {
        List<double[]> spheresParameters = Arrays.stream(parameters).toList();
        List<Sphere> spheres = SphereFactory.createSpheres(spheresParameters);
        repositoryFiller.fillSphereRepository(spheres);

        double expected = 7;
        double actual = sphereRepository.size();
        Assert.assertEquals(actual, expected, "filling of repository is invalid");
    }

    @Test
    public void fillRepository() {
        Sphere sphere = new Sphere(new Point(3, 5, 6), 12);
        repositoryFiller.fillRepository(sphere);

        double expected = 1;
        double actual = sphereRepository.size();
        Assert.assertEquals(actual, expected, "filling of repository is invalid");
    }

    @Test(dataProvider = "getParametersForSpheres")
    public void fillRepository(double[][] parameters) {
        List<double[]> spheresParameters = Arrays.stream(parameters).toList();
        List<Sphere> spheres = SphereFactory.createSpheres(spheresParameters);
        repositoryFiller.fillRepository(spheres);

        double expected = 4;
        double actual = sphereRepository.size();
        Assert.assertEquals(actual, expected, "filling of repository is invalid");
    }

    @DataProvider(name = "getParametersForSpheres")
    public Object[][] getParametersForSpheres() {
        return new Object[][]{{
                new double[]{4, 1, 6, 8},
                new double[]{3, 4, 1, 9, 3, 7},
                new double[]{7, 1, 2, 6}
        }};
    }
}
