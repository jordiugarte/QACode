package calculatorTest;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResTest {

    Calculator cal;

    @Before
    public void before() {
        cal = new Calculator();
    }

    @Test
    public void resPairs() {
        int actualResult = cal.res(4, 2);
        int expectedRsult = 2;
        Assert.assertEquals("ERROR! la resta es incorrecta", expectedRsult, actualResult);
    }

    @Test
    public void resImpairs() {
        int actualResult = cal.res(3, 5);
        int expectedRsult = -2;
        Assert.assertEquals("ERROR! la resta es incorrecta", expectedRsult, actualResult);
    }

    @Test
    public void resPairsImpairs() {
        int actualResult = cal.res(4, 7);
        int expectedRsult = -3;
        Assert.assertEquals("ERROR! la resta es incorrecta", expectedRsult, actualResult);
    }
}
