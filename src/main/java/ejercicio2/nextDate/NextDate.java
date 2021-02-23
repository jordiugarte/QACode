package ejercicio2.nextDate;

import static ejercicio2.nextDate.Constants.*;

public class NextDate {
    private int currentSecond;
    private int currentMinute;
    private int currentHour;
    private int currentDay;
    private String currentMonth;
    private int currentYear;

    public String nextDate(int second, int minute, int hour, int day, String month, int year) throws Exception {
        currentSecond = second + 1;
        currentMinute = minute;
        currentHour = hour;
        currentDay = day;
        currentMonth = month;
        currentYear = year;
        if (currentSecond > MINUTE_LIMIT) {
            currentSecond = 0;
            currentMinute++;
        }
        if (currentMinute > HOUR_LIMIT) {
            currentMinute = 0;
            currentHour++;
        }
        if (currentHour > DAY_LIMIT) {
            currentHour = 0;
            currentDay++;
        }
        if (currentDay > getDaysQuantity(currentMonth) - 1) {
            currentDay = 1;
            int currentMonthIndex = getMonthInt(currentMonth);
            if (currentMonthIndex == MONTH_LIMIT) {
                currentMonth = getMonthString(0);
                currentYear++;
            } else {
                currentMonth = getMonthString(currentMonthIndex + 1);
            }
        }

        return currentDay + " de " + currentMonth + " de " + currentYear + " " + ceroStamp(currentHour) + ":" + ceroStamp(currentMinute) + ":" + ceroStamp(currentSecond);
    }

    private String ceroStamp(int time) {
        if (time < 10) {
            return "0" + time;
        } else {
            return time + "";
        }
    }

    private String getMonthString(int month) {
        return (String) MONTHS(currentYear)[month][0];
    }

    private int getDaysQuantity(String month) throws Exception {
        try {
            boolean go = true;
            for (int i = 0; i < MONTHS(currentYear).length && go; i++) {
                if (MONTHS(currentYear)[i][0].equals(month)) {
                    go = false;
                    return (Integer) MONTHS(currentYear)[i][1];
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private int getMonthInt(String month) throws Exception {
        try {
            boolean go = true;
            for (int i = 0; i < MONTHS(currentYear).length && go; i++) {
                if (MONTHS(currentYear)[i][0].equals(month)) {
                    go = false;
                    return i;
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }
}
