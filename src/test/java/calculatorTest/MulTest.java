package calculatorTest;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MulTest {

    Calculator cal;

    @Before
    public void before() {
        cal = new Calculator();
    }

    @Test
    public void mulPairs() throws InterruptedException {
        int actualResult = cal.mul(4, 2);
        int expectedRsult = 8;
        Assert.assertEquals("ERROR! la multiplicacion es incorrecta", expectedRsult, actualResult);
    }

    @Test
    public void mulImpairs() throws InterruptedException {
        int actualResult = cal.mul(3, 5);
        int expectedRsult = 15;
        Assert.assertEquals("ERROR! la multiplicacion es incorrecta", expectedRsult, actualResult);
    }

    @Test
    public void mulPairsImpairs() throws InterruptedException {
        int actualResult = cal.mul(4, 7);
        int expectedRsult = 28;
        Assert.assertEquals("ERROR! la multiplicacion es incorrecta", expectedRsult, actualResult);
    }

    @Test(timeout = 2000)
    public void mulTime() throws InterruptedException {
        int actualResult = cal.mul(4, 7);
        int expectedRsult = 28;
        Assert.assertEquals("ERROR! la multiplicacion es incorrecta", expectedRsult, actualResult);
    }
}
