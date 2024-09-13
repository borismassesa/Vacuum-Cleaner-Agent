import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char current_location;
        boolean A_status, B_status, C_status, D_status;

        if (args.length == 5) {
            // Use command-line arguments if provided
            current_location = validateLocation(args[0]);
            A_status = validateBoolean(args[1]);
            B_status = validateBoolean(args[2]);
            C_status = validateBoolean(args[3]);
            D_status = validateBoolean(args[4]);
        } else {
            // If no arguments provided, ask for user input
            current_location = getValidLocation();
            A_status = getValidBoolean("A");
            B_status = getValidBoolean("B");
            C_status = getValidBoolean("C");
            D_status = getValidBoolean("D");
        }


        System.out.println("\nCurrent Location = " + current_location);
        System.out.println("Square A status = " + A_status);
        System.out.println("Square B status = " + B_status);
        System.out.println("Square C status = " + C_status);
        System.out.println("Square D status = " + D_status);

        char nextLocation = determineNextAction(current_location, A_status, B_status, C_status, D_status);
        System.out.println("\nAction - Next Location = " + nextLocation);

        System.out.println("\nit was nice to clean the room.Welcome again!!!");
    }

    private static char getValidLocation() {
        while (true) {
            System.out.println("\nStarting the cleaning robot simulation...");
            System.out.println("\nEnter current location (A, B, C, or D):");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && "ABCD".contains(input)) {
                return input.charAt(0);
            }
            System.out.println("Invalid input. Please enter A, B, C, or D.");
        }
    }

    private static boolean getValidBoolean(String square) {
        while (true) {
            System.out.println("Enter status for " + square + " (true for clean, false for dirty):");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Invalid input. Please enter true or false.");
        }
    }

    private static char validateLocation(String location) {
        if (location.length() == 1 && "ABCD".contains(location.toUpperCase())) {
            return location.toUpperCase().charAt(0);
        }
        throw new IllegalArgumentException("Invalid location. Must be A, B, C, or D.");
    }

    private static boolean validateBoolean(String value) {
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(value);
        }
        throw new IllegalArgumentException("Invalid boolean value. Must be true or false.");
    }

    private static char determineNextAction(char currentLocation, boolean A_status, boolean B_status, boolean C_status, boolean D_status) {
        // If all squares are clean, stay in the current location
        if (A_status && B_status && C_status && D_status) {
            return currentLocation;
        }

        // If the current location is not clean, stay to clean it
        if (!isClean(currentLocation, A_status, B_status, C_status, D_status)) {
            return currentLocation;
        }

        // Check horizontal moves (highest priority)
        char horizontalMove = checkHorizontalMove(currentLocation, A_status, B_status);
        if (horizontalMove != currentLocation) {
            return horizontalMove;
        }

        // Check vertical moves
        return checkVerticalMove(currentLocation, A_status, B_status, C_status, D_status);
    }

    private static boolean isClean(char location, boolean A_status, boolean B_status, boolean C_status, boolean D_status) {
        return switch (location) {
            case 'A' -> A_status;
            case 'B' -> B_status;
            case 'C' -> C_status;
            case 'D' -> D_status;
            default -> true; // Default to clean for invalid input
        };
    }

    private static char checkHorizontalMove(char currentLocation, boolean A_status, boolean B_status) {
        return switch (currentLocation) {
            case 'A', 'C' -> B_status ? currentLocation : 'B';
            case 'B', 'D' -> A_status ? currentLocation : 'A';
            default -> currentLocation;
        };
    }

    private static char checkVerticalMove(char currentLocation, boolean A_status, boolean B_status, boolean C_status, boolean D_status) {
        return switch (currentLocation) {
            case 'A', 'B' -> C_status ? (D_status ? currentLocation : 'D') : 'C';
            case 'C', 'D' -> A_status ? (B_status ? currentLocation : 'B') : 'A';
            default -> currentLocation;
        };
    }
}