package Calendar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Command {
    HashMap<Date, PlanItem> plan;

    public Command() {
        plan = new HashMap<>();
        File f = new File("plan.dat");
        if(!f.exists())
            return;
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] words = line.split(",");

                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-mm-dd").parse(words[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String event = words[1];
                String location = words[2];
                String[] strGuests = Arrays.copyOfRange(words, 3, words.length);
                ArrayList<String> allGuests = toStringFromArrayList(strGuests);
                PlanItem p = new PlanItem(event, location, allGuests);
                plan.put(date, p);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cmdRegister(Scanner sc) {
        System.out.println("\n[Register]");
        System.out.println("날짜를 입력해주세요. (yyyy-mm-dd)");
        System.out.print("DATE > ");
        Date date = null;
        String strDate = sc.nextLine();

        try {
            date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println();
        PlanItem newPlan = new PlanItem();
        newPlan.planEvent(sc, date);
        newPlan.planLocation(sc);
        newPlan.planGuests(sc);

        plan.put(date, newPlan);

        try {
            FileWriter fw = new FileWriter("plan.dat", true);
            fw.write(newPlan.format + "," + newPlan.event + "," + newPlan.location + "," + newPlan.guests + "\n");
            fw.close();
        } catch(IOException e) {
            System.out.println("IO error occured!");
            e.printStackTrace();
        }
    }

    public void cmdSearch(Scanner sc) {
        Date sdate = null;
        System.out.println("\n[Search]");
        System.out.println("날짜를 입력해주세요. (yyyy-mm-dd)");
        System.out.print("DATE > ");
        String strSearchDate = sc.nextLine();

        try {
            sdate = new SimpleDateFormat("yyyy-mm-dd").parse(strSearchDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PlanItem result = plan.get(sdate);
        System.out.println("EVENT : " + result.event);
        System.out.println("LOCATION : " + result.location);
        for(String guest : result.guests)
            System.out.println("GUEST : " + guest);
        System.out.println();
    }

    public void cmdPrintCalendar(Scanner sc) {
        int year, month;

        System.out.println("연도를 입력하세요.");
        System.out.print("YEAR> ");
        year = sc.nextInt();
        System.out.println("월을 입력하세요.");
        System.out.print("MONTH> ");
        month = sc.nextInt();

        if (year < 0 || month > 12 || month < 1) {
            System.out.println("유효한 값이 아닙니다.");
            year = sc.nextInt();
            month = sc.nextInt();
        }

        RealCalendar.printCalendar(year, month);
    }

    public ArrayList<String> toStringFromArrayList(String[] strGuests) {
        ArrayList<String> allGuests = new ArrayList<>();
        for(String a : strGuests) {
            String temp = a.replace("[", "").replace("]", "").replace(" ", "");
            allGuests.add(temp);
        }
        return allGuests;
    }
}
