package ejercicio1.calculateDegreesTest;

public class CalculateDegrees {
    public String finalDegree(int first, int second, int third) {
        if (first < 0 || first > 100 || second < 0 || second > 100 || third < 0 || third > 100) {
            return "*** INGRESE DATOS CORRECTOS ***";
        } else {
            int result = (first + second + third) / 3;
            if (result >= 90 && result <= 100) {
                return "Excelente, su nota es " + result;
            } else if (result >= 80 && result < 90) {
                return "Muy bien, su nota es " + result;
            } else if (result >= 70 && result < 80) {
                return "Bien, su nota es " + result;
            } else {
                return "Esfuerzate mas, su nota es " + result;
            }
        }
    }
}
