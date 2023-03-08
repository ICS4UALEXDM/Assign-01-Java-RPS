import java.util.Random;
import java.util.Scanner;
/**
* This program calculates amount of Energy released when mass is converted to
* energy.
*
* @author  Alex De Meo
* @version 1.0
* @since   2023/02/08
*/

public final class Assign01 {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private Assign01() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    */

    public static void main(String[] args) {
        // Creating the random generator
        final Random rand = new Random();
        // Creating the scanner.
        final Scanner scanner = new Scanner(System.in);
        // Initializing variables
        boolean continueProgram = true;
        boolean answerLoop = true;
        boolean inputLoop = true;
        boolean noErrors = false;
        String choice;
        String answer;
        int choiceInt;
        final int pMax = 100;
        final int pMin = 0;
        final double kMin = -273.15;
        // While loop allows for the program to continue running if an error is
        // caught when asking what problem to run. Also allows for the user to
        // choose another problem
        do {
            inputLoop = true;
            noErrors = false;
            answerLoop = true;
            // This is where the user chooses what problem to run
            System.out.print("You have two options, to choose an option, enter"
                + " the corresponding number. \n1 - Celsius to Fahrenheit and"
                + " Kelvin conversion.\n2 - Final Exam permitter\nChoice: ");
            choice = scanner.nextLine();
            // Try catch is used to ensure the user entered a valid option
            try {
                // Parsing to an int
                choiceInt = Integer.parseInt(choice);
                // If the user chooses the temperature program
                if (choiceInt == 1) {
                    // This loop allows the user to fix any input errors
                    do {
                        // getting temperature
                        System.out.print("Enter the temperature in celsius: ");
                        final String celsiusStr = scanner.nextLine();
                        // ensuring valid input
                        try {
                            final double celsiusDegrees = Double.parseDouble(
                                celsiusStr
                            );
                            // Ensuring that temperature inputted can exist.
                            // As at absolute 0, there is no kinetic energy and
                            // temperature is the average kinetic energy. There
                            // can't be negative kinetic energy
                            if (celsiusDegrees >= kMin) {
                                // Calls function that converts celsius to
                                // fahrenheit
                                final double fahrenheitDegrees = fahrenheitDeg(
                                    celsiusDegrees);
                                // calls function that converts celsius to
                                // kelvin
                                final double kelvinDegrees = kelvinDeg(
                                    celsiusDegrees);
                                System.out.format(
                                    "The temperature in fahrenheit is %.2f°F"
                                    + " and the temperature in "
                                    + " kelvin is %.2f°K.",
                                    fahrenheitDegrees, kelvinDegrees);
                                // Breaks the loop that gets user input. Allows
                                // the code that asks user to run program again
                                // to be run.
                                inputLoop = false;
                                noErrors = true;
                            } else {
                                System.out.println(
                                    "That temperature is below absolute 0"
                                    + ". That also means it doesn't exist");
                            }
                        } catch (NumberFormatException error) {
                            System.out.println("That input is invalid.");
                        }
                    } while (inputLoop);
                // If the user chooses the attendance program
                } else if (choiceInt == 2) {
                    do {
                        System.out.print("Enter your attendance record as a "
                            + "percentage: ");
                        final String attendanceStr = scanner.nextLine();
                        try {
                            // Converting to Int
                            final int attInt = Integer.parseInt(
                                attendanceStr);
                            if (attInt >= pMin && attInt <= pMax) {
                                // Calling the function that determines if the
                                // final exam can be run. Returns boolean value.
                                final boolean canWriteExam = canWrite(attInt);
                                // Depending on what the function returned,
                                // These are the possible outputs
                                if (canWriteExam) {
                                    System.out.println(
                                        "You can write the exam!");
                                } else {
                                    System.out.println(
                                        "Your attendance was insufficient "
                                        + "so you cannot write the exam.");
                                }
                                // Breaks the loop that gets user input. Allows
                                // the code that asks user to run program again
                                // to be run.
                                inputLoop = false;
                                noErrors = true;
                            } else {
                                // Telling user that input must be in a range
                                System.out.println("Please ensure percentage"
                                    + " is in acceptable range: 1-100");
                            }
                        } catch (NumberFormatException error) {
                            System.out.println("That input is invalid");
                        }
                    } while (inputLoop);
                } else {
                    System.out.println("Please enter a valid option");
                }
                if (noErrors) {
                    do {
                        // Asking the user if they'd like to run it again
                        System.out.print(
                            "Would you like to run another problem? (y/n): ");
                        answer = scanner.nextLine();
                        // choosing whether or not to allow the "game" loop
                        // to run again
                        if ("y".equals(answer)) {
                            // Closes the loop that asks user if they'd like to
                            // run program again. But still allows the program
                            // to be run again.
                            answerLoop = false;
                        } else if ("n".equals(answer)) {
                            // These booleans close loops that continue running
                            // the program.
                            answerLoop = false;
                            continueProgram = false;
                        } else {
                            System.out.println(
                                "That was not an option, try again");
                        }
                    // Will loop again if there was invalid input
                    } while (answerLoop);
                }
            // What to do if an error is caught
            } catch (NumberFormatException error) {
                System.out.println(
                    "Please ensure you enter one of the options.");
            }
        // Will run again if user answered 'y'
        } while (continueProgram);
    }
    /**
    * This function calculates the degrees in fahrenheit given a celsius value.
    *
    * @author  Alex De Meo
    * @version 1.0
    * @param celsius Necessary for the fahrenheit calculations
    * @return The temperature in fahrenheit that was calculated
    * @since   2023/02/08
    */

    public static double fahrenheitDeg(double celsius) {
        // This is the formula to convert celsius to fahrenheit
        final double fahrenheit = ((9.0 / 5.0) * celsius) + 32;
        // returning results back to main
        return fahrenheit;
    }
    /**
    * This function calculates the degrees in kelvin given a celsius value.
    *
    * @author  Alex De Meo
    * @version 1.0
    * @param celsius Necessary for the kelvin calculations
    * @return The temperature in kelvin that was calculated
    * @since   2023/02/08
    */

    public static double kelvinDeg(double celsius) {
        // This is the formula to convert kelvin to celsius
        final double kelvin = celsius + 273.15;
        // returning results back to main
        return kelvin;
    }
    /**
    * This function calculates the degrees in kelvin given a celsius value.
    *
    * @author  Alex De Meo
    * @version 1.0
    * @param attendance Used to check if they can write the exam
    * @return Whether or not they can write the exam
    * @since   2023/02/08
    */

    public static boolean canWrite(int attendance) {
        final int passMark = 75;
        // I could just return true or false in the if statement, however by
        // creating the boolean variable, it makes the code a little more
        // readable and easier to understand what it is meant to do.
        final boolean canWrite;
        // Checks to see if the attendance is enough to write the exam (75%+)
        if (attendance < passMark) {
            canWrite = false;
        } else {
            canWrite = true;
        }
        // returning results back to main
        return canWrite;
    }
}
