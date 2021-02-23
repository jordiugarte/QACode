package ejercicio3.creditVerifier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)

public class CreditVerifierTest {
    private int ci;
    private int credit;
    private String message;
    boolean expectedMock;
    private ASFI asfiMocked = Mockito.mock(ASFI.class);

    public CreditVerifierTest(int first, int second, String message, boolean expectedMock) {
        this.ci = first;
        this.credit = second;
        this.message = message;
        this.expectedMock = expectedMock;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{111111, 0, "Credito incorrecto", true});
        objects.add(new Object[]{727272, 5000, "El interes es del 15%", true});
        objects.add(new Object[]{727272, 1, "El interes es del 15%", true});
        objects.add(new Object[]{727272, 9999, "El interes es del 15%", true});
        objects.add(new Object[]{727272, 10000, "El interes es del 15%", true});
        objects.add(new Object[]{727272, 10001, "El interes es del 13%", true});
        objects.add(new Object[]{727272, 15000, "El interes es del 13%", true});
        objects.add(new Object[]{727272, 19999, "El interes es del 13%", true});
        objects.add(new Object[]{727272, 20000, "El interes es del 13%", true});
        objects.add(new Object[]{727272, 25000, "El interes es del 10%", true});
        objects.add(new Object[]{727272, 29999, "El interes es del 10%", true});
        objects.add(new Object[]{727272, 30000, "El interes es del 10%", true});
        objects.add(new Object[]{727272, 30001, "El interes es del 5%", true});
        objects.add(new Object[]{727272, 35000, "El interes es del 5%", true});
        objects.add(new Object[]{727272, 40000, "El interes es del 5%", true});
        objects.add(new Object[]{727272, Integer.MAX_VALUE, "El interes es del 5%", true});

        return objects;
    }

    @Test
    public void verify_credit_value() {
        Mockito.when(asfiMocked.userIsEnabled(this.ci)).thenReturn(this.expectedMock);
        CreditVerifier credito = new CreditVerifier(asfiMocked);
        String actualResult = credito.getInterest(this.ci, this.credit);
        Assert.assertEquals("ERROR! ", this.message, actualResult);
    }
}
