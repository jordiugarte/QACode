package dateTest;

import ejercicio2.nextDate.NextDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateTest {

    NextDate nextDate;

    @Before
    public void before() {
        nextDate = new NextDate();
    }

    @Test
    public void secondChange() throws Exception {
        String result = nextDate.nextDate(20, 30, 11, 5, "Julio", 1999);
        String expectedRsult = "5 de Julio de 1999 11:30:21";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void minuteChange() throws Exception {
        String result = nextDate.nextDate(59, 30, 11, 5, "Julio", 1999);
        String expectedRsult = "5 de Julio de 1999 11:31:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void hourChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 11, 5, "Julio", 1999);
        String expectedRsult = "5 de Julio de 1999 12:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void dayChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 23, 5, "Julio", 1999);
        String expectedRsult = "6 de Julio de 1999 00:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void monthChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 23, 31, "Julio", 1999);
        String expectedRsult = "1 de Agosto de 1999 00:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void yearChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 23, 31, "Diciembre", 1999);
        String expectedRsult = "1 de Enero de 2000 00:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void month30dayChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 23, 30, "Junio", 1999);
        String expectedRsult = "1 de Julio de 1999 00:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void februaryDayChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 23, 28, "Febrero", 1999);
        String expectedRsult = "1 de Marzo de 1999 00:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }

    @Test
    public void leapYearFebruaryDayChange() throws Exception {
        String result = nextDate.nextDate(59, 59, 23, 29, "Febrero", 2020);
        String expectedRsult = "1 de Marzo de 2020 00:00:00";
        Assert.assertEquals("ERROR! la fecha es incorrecta", result, expectedRsult);
    }
}