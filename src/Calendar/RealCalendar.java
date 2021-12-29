package Calendar;

public class RealCalendar {

    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0))
            return true;
        return false;
    }

    public static int getMaxDaysOfMonth(int year, int month) {
        if(isLeapYear(year))
            return LEAP_MAX_DAYS[month-1];
        return MAX_DAYS[month-1];
    }

    public static int getFirstDay(int year, int month) {
        final int START_YEAR = 1970;
        final int START_DAY_OF_THE_WEEK = 4;
        int yearFirstDay = 0;
        int firstDay = 0;
        int daySum = 0;

        daySum += START_DAY_OF_THE_WEEK + year - START_YEAR;

        for(int i = START_YEAR; i < year; i++)
            if(isLeapYear(i))
                daySum++;

        yearFirstDay = daySum % 7;

        for(int i = 1; i < month; i++)
            yearFirstDay += getMaxDaysOfMonth(year, i);

        firstDay = yearFirstDay % 7;

        return firstDay;
    }

    public static void printCalendar(int year, int month) {
        int firstDay = getFirstDay(year, month);
        int lastDay = getMaxDaysOfMonth(year, month);
        int count = 0;

        System.out.printf("     <%d년 %d월>    \n", year, month);
        System.out.println("SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        for(int i = 0; i < firstDay; i++) {
            System.out.printf("   ");
            count++;
        }

        for(int i = 1; i <= lastDay; i++) {
            System.out.printf("%2d ", i);
            count++;
            if(count % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }
}
