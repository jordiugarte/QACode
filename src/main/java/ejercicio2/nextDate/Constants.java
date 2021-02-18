package ejercicio2.nextDate;

import java.util.ArrayList;

public class Constants {
    public static int MINUTE_LIMIT = 59;
    public static int HOUR_LIMIT = 59;
    public static int DAY_LIMIT = 23;
    public static int MONTH_LIMIT = 11;

    public static Object[][] MONTHS(int year) {
        Object[][] months = {{"Enero", 31}, {"Febrero", leapYearFebruary(year)}, {"Marzo", 31}, {"Abril", 30}, {"Mayo", 31}, {"Junio", 30}, {"Julio", 31}, {"Agosto", 31}, {"Septiembre", 30}, {"Octubre", 31}, {"Noviembre", 30}, {"Diciembre", 31}};
        return months;
    }

    ;

    private static int leapYearFebruary(int year) {
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))
            return 29;
        else
            return 28;
    }
}
