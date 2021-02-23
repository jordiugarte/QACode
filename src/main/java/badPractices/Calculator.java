package badPractices;

public class Calculator {

    public Calculator() {

    }

    public int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] argssss) {
        Calculator calculadora = new Calculator();

        int actualResult = calculadora.sumar(5, 6);
        int expectedResult = 10;

        if (actualResult == expectedResult) {
            System.out.println("Works");
        } else {
            System.out.println("Doesnt works");
        }
    }
}
