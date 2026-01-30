
import java.time.LocalDate;
import java.util.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        // Sort events by date
        events.sort(Comparator.comparing(e -> e.date));

        // Print sorted events
        for (Event e : events) {
            System.out.print(e.name + " ");
        }
        System.out.println();

        // Earliest event
        System.out.println(events.get(0).name);

        // Latest event
        System.out.println(events.get(events.size() - 1).name);

        // Events in given month
        for (Event e : events) {
            if (e.date.getMonthValue() == month) {
                System.out.print(e.name + " ");
            }
        }
    }
}
