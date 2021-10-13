package test.development.task2.parser;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.parser.impl.SphereParserImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SphereParserTest {

    @Test(dataProvider = "getActualParameters")
    public void parseParameters(String[] actualParameters) throws SphereException {
        double expected = 1;
        SphereParserImpl sphereParser = new SphereParserImpl();
        Sphere sphere = sphereParser.parseParameters(actualParameters);
        Assert.assertEquals(sphere.getRadius(), expected, "invalid parameters parsing");
    }

    @DataProvider(name = "getActualParameters")
    public static Object[][] getActualParameters() {
        return new Object[][]{
                {"6d1/9/4/-3/2"},
                {"8/3/6/1", "10/5.1/6/7", "2/9/3/4"},
                {"9/1/4/3/2", "8/3/6", "10/5/6/7"},
                {"6/0..5/3/4/-3/2"},
                {"8/3/6", "6.e1/0.5/-3.2/4/-2", "6/5/3/4"}
        };
    }
}
