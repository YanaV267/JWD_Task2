package test.development.task2.parser;

import com.development.task2.exception.SphereException;
import com.development.task2.parser.impl.SphereParserImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class SphereParserTest {

    @Test(dataProvider = "getFirstParameters")
    public void parseParameters(String[] actualParameters) throws SphereException {
        double expected = 1;
        SphereParserImpl sphereParser = new SphereParserImpl();
        List<double[]> parameters = sphereParser.parseParameters(actualParameters);
        Assert.assertEquals(parameters.size(), expected, "invalid parameters parsing");
    }

    @Test(dataProvider = "getSecondParameters")
    public void parseParameters(String actualParameters) {
        SphereParserImpl sphereParser = new SphereParserImpl();
        Optional<double[]> parameters = sphereParser.parseParameters(actualParameters);
        Assert.assertTrue(parameters.isPresent(), "invalid parameters parsing");
    }

    @DataProvider(name = "getFirstParameters")
    public static Object[][] getFirstParameters() {
        return new Object[][]{
                {"6d1/9/4/-3/2"},
                {"8/3/6/1", "10/5.1/6/7"},
                {"5/6/3/1","6/0..5/3/4/-3/2"},
                {"8/3/6", "6.e1/0.5/-3.2/4/-2", "6/5/3/4"}
        };
    }

    @DataProvider(name = "getSecondParameters")
    public static Object[][] getSecondParameters() {
        return new Object[][]{
                {"6d1/9/4/-3/2"},
                {"10/5.1/6/7"},
                {"5/6/3/1"},
                {"8/3/6"}
        };
    }
}
