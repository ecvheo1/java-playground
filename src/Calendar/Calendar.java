package Calendar;

import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getMaxDaysOfMonth(int year, int month) {
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0))
            return LEAP_MAX_DAYS[month-1];
        return MAX_DAYS[month-1];
    }

    public void printCalendar(int year, int month, String weekday) {
        int lastDay = getMaxDaysOfMonth(year, month);
        int count = 0;
        HashMap<String, Integer> day = new HashMap<>();
        day.put("SU", 0);
        day.put("MO", 1);
        day.put("TU", 2);
        day.put("WE", 3);
        day.put("TH", 4);
        day.put("FR", 5);
        day.put("SA", 6);

        System.out.printf("     <%d년 %d월>    \n", year, month);
        System.out.println("SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        for(int i = 0; i < day.get(weekday); i++) {
            System.out.print("   ");
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

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();

        int year, month;
        String weekday;
        while(true) {
            System.out.println("연도를 입력하세요.");
            System.out.print("YEAR> ");
            year = sc.nextInt();
            System.out.println("월을 입력하세요.");
            System.out.print("MONTH> ");
            month = sc.nextInt();
            System.out.println("첫 번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
            System.out.print("WEEKDAY> ");
            weekday = sc.next();

            if(year == -1) {
                System.out.println("The End.");
                break;
            }

            if(month > 12) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            printCalendar(year, month, weekday);

        }
        sc.close();
    }


    public static void main(String[] args) {

        Calendar cal = new Calendar();
        cal.runPrompt();

    }
}