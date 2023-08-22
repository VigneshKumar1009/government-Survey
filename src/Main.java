import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        System.out.print("Enter the number of people: ");
        int numberOfPeople = scanner.nextInt();

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("\nPerson " + (i + 1));
            scanner.nextLine();  // Consume the newline left by nextInt()

            System.out.print("Name: ");
            String name = scanner.nextLine();

            int age;
            do {
                System.out.print("Age: ");
                age = scanner.nextInt();
                if (age < 0) {
                    System.out.println("Age cannot be negative. Enter again.");
                }
            } while (age < 0);

            double salary;
            do {
                System.out.print("Salary: ");
                salary = scanner.nextDouble();
                if (salary < 0) {
                    System.out.println("Salary cannot be negative. Enter again.");
                }
            } while (salary < 0);

            Person person = new Person(name, age, salary);
            people.add(person);
        }

        // Perform further analytics using the collected information
        double totalSalary = 0;
        int totalAge = 0;

        for (Person person : people) {
            totalSalary += person.getSalary();
            totalAge += person.getAge();
        }

        double averageSalary = totalSalary / numberOfPeople;
        double averageAge = (double) totalAge / numberOfPeople;

        System.out.println("\nAverage Salary: " + averageSalary);
        System.out.println("Average Age: " + averageAge);

        scanner.close();
    }
}
