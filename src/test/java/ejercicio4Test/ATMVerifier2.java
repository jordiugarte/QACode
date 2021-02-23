package ejercicio4Test;

import ejercicio4.BDUtil2;
import ejercicio4.Cajero2;
import ejercicio4.ClientDB2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Parameterized.class)
@PrepareForTest({BDUtil2.class, ClientDB2.class})

public class ATMVerifier2 {

    @Parameterized.Parameter(0)
    public boolean expectedDBMock = false;
    @Parameterized.Parameter(1)
    public boolean expectedClientMock = false;
    @Parameterized.Parameter(2)
    public int ci;
    @Parameterized.Parameter(3)
    public int fund;
    @Parameterized.Parameter(4)
    public int quantity;
    @Parameterized.Parameter(5)
    public String message;
    @Parameterized.Parameter(6)
    public String type;

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{true, true, 787878, 5000, 100, "Usted esta sacando la cantidad de 100 y tiene en saldo 4900", "mysql"});
        objects.add(new Object[]{true, true, 787878, 5000, 100, "Conexion a BD no fue satisfactoria", "nosql"});
        objects.add(new Object[]{true, true, 787878, 5000, 5001, "Usted no tiene suficiente saldo", "mysql"});
        objects.add(new Object[]{true, true, 787878, 0, 0, "Amount No Valido", "mysql"});
        objects.add(new Object[]{false, true, 787878, 100, 100, "Actualizacion Incorrecta, Intente Nuevamente", "mysql"});
        objects.add(new Object[]{false, false, 787878, 100, 100, "Conexion a BD no fue satisfactoria", "mysql"});
        objects.add(new Object[]{true, false, 787878, 100, 100, "Conexion a BD no fue satisfactoria", "mysql"});
        objects.add(new Object[]{true, false, 787878, 100, 100, "Conexion a BD no fue satisfactoria", "mysql"});

        return objects;
    }

    @Test
    public void verify_atm_value() {
        PowerMockito.mockStatic(BDUtil2.class);
        Mockito.when(BDUtil2.updateSaldo(this.ci, this.fund - this.quantity)).thenReturn(this.expectedDBMock);
        PowerMockito.mockStatic(ClientDB2.class);
        Mockito.when(ClientDB2.isConnectionSuccessfully(this.type)).thenReturn(this.expectedClientMock);
        Cajero2 atm = new Cajero2(this.fund);
        String actualResult = atm.getCash(this.ci, this.quantity);
        Assert.assertEquals("ERROR! ", this.message, actualResult);
    }
}