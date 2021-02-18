package calculatorTest;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumTest {

    Calculator cal;

    @Before
    public void before() {
        cal = new Calculator();
    }

    @Test
    public void sumPairs() {
        int actualResult = cal.sum(4, 2);
        int expectedRsult = 6;
        Assert.assertEquals("ERROR! la suma es incorrecta", expectedRsult, actualResult);
    }

    @Test
    public void sumImpairs() {
        int actualResult = cal.sum(3, 5);
        int expectedRsult = 8;
        Assert.assertEquals("ERROR! la suma es incorrecta", expectedRsult, actualResult);
    }

    @Test
    public void sumPairsImpairs() {
        int actualResult = cal.sum(4, 7);
        int expectedRsult = 11;
        Assert.assertEquals("ERROR! la suma es incorrecta", expectedRsult, actualResult);
    }
}
