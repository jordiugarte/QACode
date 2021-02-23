package calculatorPowerMockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//Paso 1 para metodos estaticos
@RunWith(PowerMockRunner.class)
//Paso 2 para metodos estaticos
@PrepareForTest(HelperCalculatorService.class)
public class CalculadoraPowerMockTest {

    @Test
    public void verify_calculadora_power_mock() {
        //Paso 3 utilizat el powermock sobre la clase que tiene el metodo estatico
        PowerMockito.mockStatic(HelperCalculatorService.class);
        //Paso 4 darle logica al metodo estatico mocked
        Mockito.when(HelperCalculatorService.multi(1, 1)).thenReturn(1);
        Mockito.when(HelperCalculatorService.multi(1, 2)).thenReturn(2);
        Mockito.when(HelperCalculatorService.multi(2, 3)).thenReturn(6);

        CalculatorPowerMock calculadora = new CalculatorPowerMock();

        int expectedResult = 6;
        int actualResult = calculadora.factorial(3);
        Assert.assertEquals("ERROR en factorial!", expectedResult, actualResult);

    }

}
