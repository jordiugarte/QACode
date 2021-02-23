package calculatorMockTest;

import calculatorMock.BasicCalculatorService;
import calculatorMock.CalculatorMock;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorMockTest {
    BasicCalculatorService serviceMockito = Mockito.mock(BasicCalculatorService.class);

    @Test
    public void verify_factorial_test() {
        Mockito.when(serviceMockito.multi(1, 1)).thenReturn(1);
        Mockito.when(serviceMockito.multi(1, 2)).thenReturn(2);
        Mockito.when(serviceMockito.multi(2, 3)).thenReturn(6);
        Mockito.when(serviceMockito.multi(6, 4)).thenReturn(24);

        CalculatorMock calculadora = new CalculatorMock(serviceMockito);
        int actualResult = calculadora.factorial(4);
        int expectedResult = 24;
        Assert.assertEquals("ERROR en factorial!", expectedResult, actualResult);

        Mockito.verify(serviceMockito).multi(1, 1);
        Mockito.verify(serviceMockito).multi(1, 2);
        Mockito.verify(serviceMockito).multi(2, 3);
        Mockito.verify(serviceMockito).multi(6, 4);
    }
}
