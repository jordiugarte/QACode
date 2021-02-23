package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)

public class ATMVerifier {
    private BDUtil dbMocked = Mockito.mock(BDUtil.class);
    private ClientDB clientMocked = Mockito.mock(ClientDB.class);
    private boolean expectedDBMock = false;
    private boolean expectedClientMock = false;
    private int quantity;
    private int ci;
    private int fund;
    private String message;
    private String type;

    public ATMVerifier(boolean expectedDBMock, boolean expectedClientMock, int ci, int fund, int quantity, String message, String type) {
        this.expectedDBMock = expectedDBMock;
        this.expectedClientMock = expectedClientMock;
        this.quantity = quantity;
        this.ci = ci;
        this.fund = fund;
        this.message = message;
        this.type = type;
    }

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
        Mockito.when(dbMocked.updateSaldo(this.ci, this.fund - this.quantity)).thenReturn(this.expectedDBMock);
        Mockito.when(clientMocked.isConnectionSuccessfully(this.type)).thenReturn(this.expectedClientMock);
        Cajero atm = new Cajero(this.dbMocked, this.clientMocked, this.fund);
        String actualResult = atm.getCash(this.ci, this.quantity);
        Assert.assertEquals("ERROR! ", this.message, actualResult);
    }
}