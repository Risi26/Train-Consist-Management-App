// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {

    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {

    private String shape;
    private String cargoType;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Cargo Assignment Method
    public void assignCargo(String cargoType) {

        try {

            // Safety Rule:
            // Petroleum cannot be assigned to Rectangular bogie
            if (shape.equalsIgnoreCase("Rectangular")
                    && cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Cargo: Petroleum cannot be loaded into Rectangular Bogie"
                );
            }

            // Safe Assignment
            this.cargoType = cargoType;

            System.out.println(
                    "Cargo Assigned Successfully: "
                            + cargoType
                            + " -> "
                            + shape + " Bogie"
            );

        }

        catch (CargoSafetyException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        finally {

            System.out.println(
                    "Cargo assignment process completed."
            );
        }
    }

    public String getCargoType() {
        return cargoType;
    }

    public String getShape() {
        return shape;
    }
}

// Main Application
public class Train_Consist_Management_App {

    public static void main(String[] args) {

        // Safe Case
        GoodsBogie cylindricalBogie =
                new GoodsBogie("Cylindrical");

        cylindricalBogie.assignCargo("Petroleum");

        System.out.println();

        // Unsafe Case
        GoodsBogie rectangularBogie =
                new GoodsBogie("Rectangular");

        rectangularBogie.assignCargo("Petroleum");

        System.out.println();

        // Program Continues
        GoodsBogie anotherBogie =
                new GoodsBogie("Rectangular");

        anotherBogie.assignCargo("Grain");

        System.out.println(
                "\nProgram continues safely after exception handling."
        );
    }
}