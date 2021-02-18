package calculatorParams;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class TestSumParams {

    private int first;
    private int second;
    private int expected;

    public TestSumParams(int first, int second, int expected) {
        this.first = first;
        this.second = second;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{1, 1, 2});
        objects.add(new Object[]{-1, -1, -2});
        objects.add(new Object[]{100, 400, 500});
        objects.add(new Object[]{2, 2, 4});
        objects.add(new Object[]{3, 5, 8});
        objects.add(new Object[]{3, 0, 3});
        objects.add(new Object[]{0, 0, 0});
        objects.add(new Object[]{10, 3, 13});
        objects.add(new Object[]{3, 3, 6});
        objects.add(new Object[]{-5, -4, -9});
        objects.add(new Object[]{1, 1, 2});

        return objects;
    }

    @Test
    public void verify_sum_all_values() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.sum(this.first, this.second);
        Assert.assertEquals("ERROR: La suma es incorrecta", this.expected, actualResult);
    }
}
