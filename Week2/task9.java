import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

public static boolean isOlderThan(Person p, int ageLimit) {
        return p.age > ageLimit;
    }

    // Instance method to convert name to uppercase
    public String getUpperCaseName() {
        return this.name.toUpperCase();
    }
}

public class PersonTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        List<Person> persons = new ArrayList<>();

        // Input persons
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();

        
        List<String> sortedNames = persons.stream()
                                          .map(p -> p.name)
                                          .sorted(String::compareTo)
                                          .collect(Collectors.toList());
        System.out.println(String.join(" ", sortedNames));

   
        List<String> filteredNames = persons.stream()
                                            .filter(p -> Person.isOlderThan(p, ageLimit))
                                            .map(p -> p.name)
                                            .collect(Collectors.toList());
        System.out.println(String.join(" ", filteredNames));

        
        List<String> upperCaseNames = persons.stream()
                                             .map(Person::getUpperCaseName)
                                             .collect(Collectors.toList());
        System.out.println(String.join(" ", upperCaseNames));

        sc.close();
    }
}
