package calculatorPowerMockito;

public class CalculatorPowerMock {

    public CalculatorPowerMock() {
    }

    public int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = HelperCalculatorService.multi(fact, i);
        }
        return fact;
    }

}
