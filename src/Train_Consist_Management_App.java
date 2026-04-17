import java.util.*;
import java.util.stream.Collectors;

// Bogie Class
class Bogie {

    private String bogieId;
    private int capacity;

    public Bogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return bogieId + " (Capacity: " + capacity + ")";
    }
}

public class Train_Consist_Management_App {

    // Create Large Dataset
    public static List<Bogie> createBogies(int count) {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            int capacity = (int) (Math.random() * 100) + 20;

            bogies.add(
                    new Bogie("BG-" + i, capacity)
            );
        }

        return bogies;
    }

    // Loop-Based Filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {

        List<Bogie> filtered = new ArrayList<>();

        for (Bogie bogie : bogies) {

            if (bogie.getCapacity() > 60) {
                filtered.add(bogie);
            }
        }

        return filtered;
    }

    // Stream-Based Filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {

        return bogies
                .stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Create dataset
        List<Bogie> bogies = createBogies(10000);

        // LOOP PERFORMANCE
        long loopStart = System.nanoTime();

        List<Bogie> loopResult =
                filterUsingLoop(bogies);

        long loopEnd = System.nanoTime();

        long loopTime =
                loopEnd - loopStart;

        // STREAM PERFORMANCE
        long streamStart = System.nanoTime();

        List<Bogie> streamResult =
                filterUsingStream(bogies);

        long streamEnd = System.nanoTime();

        long streamTime =
                streamEnd - streamStart;

        // OUTPUT RESULTS
        System.out.println("Loop Filtered Bogies: "
                + loopResult.size());

        System.out.println("Stream Filtered Bogies: "
                + streamResult.size());

        System.out.println();

        System.out.println("Loop Execution Time: "
                + loopTime + " ns");

        System.out.println("Stream Execution Time: "
                + streamTime + " ns");

        // Verify Result Consistency
        if (loopResult.size() == streamResult.size()) {

            System.out.println(
                    "Results Match: Both methods returned same count."
            );

        } else {

            System.out.println(
                    "Results Mismatch!"
            );
        }
    }
}