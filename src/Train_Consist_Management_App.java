import java.util.ArrayList;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class Train_Consist_Management_App {

    // Static method for reuse in test
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)   // safer method reference
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        int totalSeats = calculateTotalSeats(bogies);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);
    }
}