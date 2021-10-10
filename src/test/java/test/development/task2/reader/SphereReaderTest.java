package test.development.task2.reader;

import com.development.task2.exception.SphereException;
import com.development.task2.reader.impl.SphereReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SphereReaderTest {

    @Test
    public void readParameters() throws SphereException {
        String expected = "8";
        SphereReaderImpl sphereReader = new SphereReaderImpl();
        String[] readParameters = sphereReader.readParameters("data/values.txt");
        Assert.assertEquals(readParameters[0], expected, "reading of parameters is invalid");
    }
}
