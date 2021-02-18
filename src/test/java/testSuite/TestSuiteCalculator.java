package testSuite;

import calculatorTest.DivTest;
import calculatorTest.MulTest;
import calculatorTest.ResTest;
import calculatorTest.SumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(
        {
                DivTest.class,
                MulTest.class,
                ResTest.class,
                SumTest.class
        }
)

public class TestSuiteCalculator {

}