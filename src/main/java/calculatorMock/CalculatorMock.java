package calculatorMock;

public class CalculatorMock {

    BasicCalculatorService service = new BasicCalculatorService();

    public CalculatorMock() {

    }

    public CalculatorMock(BasicCalculatorService mockService) {
        this.service = mockService;
    }


    public int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = this.service.multi(fact, i);
        }
        return fact;
    }

}
