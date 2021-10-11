package test.development.task2.reader;

import com.development.task2.exception.SphereException;
import com.development.task2.reader.impl.SphereReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SphereReaderTest {

    @Test
    public void readParameters() throws SphereException {
        String expected = "8/3/10";
        SphereReaderImpl sphereReader = new SphereReaderImpl();
        String[] readParameters = sphereReader.readParameters("data/values.txt");
        Arrays.stream(readParameters).forEach(System.out::println);
        Assert.assertEquals(readParameters[0], expected, "reading of parameters is invalid");
    }
}
