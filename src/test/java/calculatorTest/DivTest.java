package calculatorTest;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivTest {

    Calculator cal;

    @Before
    public void before() {
        cal = new Calculator();
    }

    @Test
    public void divPairs() throws InterruptedException {
        int actualResult = cal.div(4, 2);
        int expectedResult = 2;
        Assert.assertEquals("ERROR! la division es incorrecta", expectedResult, actualResult);
    }

    @Test
    public void divImpairs() throws InterruptedException {
        int actualResult = cal.div(15, 3);
        int expectedResult = 5;
        Assert.assertEquals("ERROR! la division es incorrecta", expectedResult, actualResult);
    }

    @Test
    public void divPairsImpairs() throws InterruptedException {
        int actualResult = cal.div(28, 7);
        int expectedResult = 4;
        Assert.assertEquals("ERROR! la division es incorrecta", expectedResult, actualResult);
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void divImparesPares(){
        cal.div(10,0);
    }
}
