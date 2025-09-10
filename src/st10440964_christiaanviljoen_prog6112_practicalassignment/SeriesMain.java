package st10440964_christiaanviljoen_prog6112_practicalassignment;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

import java.util.Scanner;

public class SeriesMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Series seriesApp = new Series();

        while (true) {
            System.out.println("LATEST SERIES 2025");
            System.out.print("Enter (1) to launch menu or any "
                    + "other key to exit: ");
            String choice = input.nextLine();

            if (!choice.equals("1")) {
                System.out.println("Exiting application. Goodbye!");
                break;
            }

            // Menu options
            System.out.println("\nPlease select one of "
                    + "the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report 2025.");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");

            String menuChoice = input.nextLine();

            switch (menuChoice) {
                case "1":
                    seriesApp.CaptureSeries();
                    break;
                case "2":
                    seriesApp.SearchSeries();
                    break;
                case "3":
                    seriesApp.UpdateSeries();
                    break;
                case "4":
                    seriesApp.DeleteSeries();
                    break;
                case "5":
                    seriesApp.SeriesReport();
                    break;
                case "6":
                    seriesApp.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Enter (1) to launch menu or "
                    + "any other key to exit: ");
            String backToMenu = input.nextLine();
            if (!backToMenu.equals("1")) {
                System.out.println("Exiting application. Goodbye!");
                break;
            }
        }

        input.close();
    }
}
