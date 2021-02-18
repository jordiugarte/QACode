package ejercicio1.calculateDegreesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CalculateDegreesParams {

    private int first;
    private int second;
    private int third;
    private String expected;

    public CalculateDegreesParams(int first, int second, int third, String expected) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{50, 60, 70, "Esfuerzate mas, su nota es 60"});
        objects.add(new Object[]{85, 85, 85, "Muy bien, su nota es 85"});
        objects.add(new Object[]{75, 75, 75, "Bien, su nota es 75"});
        objects.add(new Object[]{100, 100, 100, "Excelente, su nota es 100"});
        objects.add(new Object[]{-1, 20, 101, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{50, 60, 101, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{-200, 60, 101, "*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{100, 100, 100, "Excelente, su nota es 60"});

        return objects;
    }

    @Test
    public void verify_sum_all_values() {
        CalculateDegrees calculateDegrees = new CalculateDegrees();
        String actualResult = calculateDegrees.finalDegree(this.first, this.second, this.third);
        Assert.assertEquals("ERROR!", this.expected, actualResult);
    }
}
