package ejercicio3.creditVerifier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ASFIUtils.class)

public class CreditVerifierTest2 {

    @Test
    public void verify_calculate_credit() {
        PowerMockito.mockStatic(ASFIUtils.class);
        Mockito.when(ASFIUtils.userIsEnabled(989898)).thenReturn(true);
        CreditVerifier2 creditVerifier2 = new CreditVerifier2();
        String actualResult = creditVerifier2.getInterest(989898, 1);
        Assert.assertEquals("ERROR! ", "El interes es del 15%", actualResult);
    }
}
