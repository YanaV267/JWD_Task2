package test.development.task2.repository;

import com.development.task2.comparator.*;
import com.development.task2.entity.Point;
import com.development.task2.entity.Sphere;
import com.development.task2.repository.SphereRepository;
import com.development.task2.repository.SphereSpecification;
import com.development.task2.repository.impl.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class SphereRepositoryTest {
    private SphereRepository sphereRepository;

    @BeforeTest
    public void init() {
        sphereRepository = SphereRepository.getInstance();
        sphereRepository.add(new Sphere(new Point(4, 3, 7), 7));
        sphereRepository.add(new Sphere(new Point(10, 9, 4), 3));
        sphereRepository.add(new Sphere(new Point(4, 2, 6), 8));
        sphereRepository.add(new Sphere(new Point(1, 3, 8.5), 14));
    }

    @Test(dataProvider = "queryData")
    public void query(SphereSpecification specification) {
        int expected = 1;
        List<Sphere> spheres = sphereRepository.query(specification);
        Assert.assertEquals(spheres.size(), expected, "invalid result of specification");
    }

    @Test(dataProvider = "sortData")
    public void sort(Comparator<Sphere> comparator) {
        double expected = 1;
        List<Sphere> spheres = sphereRepository.sort(comparator);
        Assert.assertEquals(spheres.get(0).getSphereId(), expected, "invalid result of sorting");
    }

    @DataProvider(name = "queryData")
    public Object[][] getQueryData() {
        return new Object[][]{
                {new IdSpecification(1)},
                {new RadiusSpecification(3, 7)},
                {new SurfaceAreaSpecification(210)},
                {new VolumeSpecification(870)},
                {new CenterDistanceSpecification(new Point(4,9,2), 50)}
        };
    }

    @DataProvider(name = "sortData")
    public Object[][] getSortData() {
        return new Object[][]{
                {new SphereIdComparator()},
                {new SphereRadiusComparator()},
                {new SphereXComparator()},
                {new SphereYComparator()},
                {new SphereZComparator()}
        };
    }
}
