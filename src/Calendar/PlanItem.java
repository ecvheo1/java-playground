package Calendar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PlanItem {
    String format;
    String event;
    String location;
    ArrayList<String> guests;

    public PlanItem() {
        guests = new ArrayList<>();
    }

    public PlanItem(String event, String location, ArrayList<String> guests) {
        this.event = event;
        this.location = location;
        this.guests = guests;
    }

    public void planEvent(Scanner sc, Date date) {
        System.out.println("일정 이름을 입력하세요.");
        System.out.print("EVENT> ");
        event  = sc.nextLine();

        format = new SimpleDateFormat("yyyy-mm-dd").format(date);
        System.out.printf("%s : %s\n", format, event);
        System.out.println("Successfully Registered!\n");
    }

    public void planLocation(Scanner sc) {
        System.out.println("장소를 입력하세요.");
        System.out.print("LOCATION> ");
        location  = sc.nextLine();
    }

    public void planGuests(Scanner sc) {
        System.out.println("게스트를 입력하세요. (press q to quit)");

        while(true) {
            System.out.print("GUEST> ");
            String guest = sc.nextLine();
            if(guest.equals("q")) {
                System.out.println("GUESTS : " + guests);
                System.out.println();
                break;
            }
            guests.add(guest);
        }
    }
}
