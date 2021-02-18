package calculator;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int res(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) throws InterruptedException{
        Thread.sleep(1500);
        return a * b;
    }

    public int div(int a, int b) {
        if (b == 0){
            throw new ArithmeticException("No es posible la division entre 0");
        } else {
            return a / b;
        }
    }
}
