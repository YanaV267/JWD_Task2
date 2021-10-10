package test.development.task2.parser;

import com.development.task2.entity.Sphere;
import com.development.task2.exception.SphereException;
import com.development.task2.parser.impl.SphereParserImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SphereParserTest {

    @Test
    public void parseParameters() throws SphereException {
        double expected = 2;
        String[] actualParameters = {"6", "0..5", "3", "4", "-3", "2"};
        SphereParserImpl sphereParser = new SphereParserImpl();
        Sphere sphere = sphereParser.parseParameters(actualParameters);
        Assert.assertEquals(sphere.getRadius(), expected, "invalid parameters parsing");
    }
}
