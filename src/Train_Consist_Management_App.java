// Custom Exception Class
class InvalidCapacityException extends Exception {

    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {

    private String bogieType;
    private int capacity;

    // Constructor with validation
    public PassengerBogie(String bogieType, int capacity)
            throws InvalidCapacityException {

        // Fail-Fast Validation
        if (capacity <= 0) {
            throw new InvalidCapacityException(
                    "Capacity must be greater than zero"
            );
        }

        this.bogieType = bogieType;
        this.capacity = capacity;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayBogie() {
        System.out.println(
                "Passenger Bogie Created: "
                        + bogieType
                        + " | Capacity: "
                        + capacity
        );
    }
}

// Main Application
public class Train_Consist_Management_App {

    public static void main(String[] args) {

        try {

            // Valid Bogie
            PassengerBogie bogie1 =
                    new PassengerBogie("Sleeper", 72);

            bogie1.displayBogie();

            // Invalid Bogie (Zero Capacity)
            PassengerBogie bogie2 =
                    new PassengerBogie("AC Chair", 0);

            bogie2.displayBogie();

        }

        catch (InvalidCapacityException e) {

            System.out.println(
                    "Exception Occurred: "
                            + e.getMessage()
            );
        }

        System.out.println(
                "Program continues safely..."
        );
    }
}