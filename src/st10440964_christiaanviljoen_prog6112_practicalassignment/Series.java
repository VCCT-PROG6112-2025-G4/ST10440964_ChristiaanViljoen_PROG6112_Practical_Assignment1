package st10440964_christiaanviljoen_prog6112_practicalassignment;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Series {
    private final ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public boolean isValidAge(int age) {
        return age >= 2 && age <= 18;
    }

    public boolean addSeries(String id, String name, int age, int episodes) {
        if (!isValidAge(age)) return false;
        seriesList.add(new SeriesModel(id, name, age, episodes));
        return true;
    }

    public SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean updateSeriesById(String id, String name, 
            int age, int episodes) {
        SeriesModel s = findSeriesById(id);
        if (s == null) return false;
        if (!isValidAge(age)) return false;
        s.setSeriesName(name);
        s.setSeriesAge(age);
        s.setNumberOfEpisodes(episodes);
        return true;
    }

    public boolean deleteSeriesById(String id) {
        Iterator<SeriesModel> it = seriesList.iterator();
        while (it.hasNext()) {
            SeriesModel s = it.next();
            if (s.getSeriesId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<SeriesModel> getAllSeries() {
        return new ArrayList<>(seriesList);
    }

    // 1. Capture series
    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");

        System.out.print("Enter the series id: ");
        String id = input.nextLine();

        System.out.print("Enter the series name: ");
        String name = input.nextLine();

        int age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String ageInput = input.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                if (isValidAge(age)) break;
                System.out.println("You have entered an incorrect series age!");
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series ag!");
            }
        }

        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = Integer.parseInt(input.nextLine());

        addSeries(id, name, age, episodes);
        System.out.println("Series processed successfully!");
    }

    // 2. Search for series
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String searchId = input.nextLine();

        SeriesModel s = findSeriesById(searchId);
        if (s != null) {
            System.out.println(s.toString());
        } else {
            System.out.println("Series with Series Id: " + searchId +
                    " was not found!");
        }
    }

    // 3. Update series
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String updateId = input.nextLine();

        SeriesModel s = findSeriesById(updateId);
        if (s == null) {
            System.out.println("Series with Series Id: " + updateId + 
                    " was not found!");
            return;
        }

        System.out.print("Enter the series name: ");
        String newName = input.nextLine();

        int age;
        while (true) {
            System.out.print("Enter the age restriction: ");
            String ageInput = input.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                if (isValidAge(age)) break;
                System.out.println("You have entered an incorrect series age!");
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!");
            }
        }

        System.out.print("Enter the number of episodes: ");
        int newEpisodes = Integer.parseInt(input.nextLine());

        updateSeriesById(updateId, newName, age, newEpisodes);
        System.out.println("Series updated successfully!");
    }

    // 4. Delete series
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String deleteId = input.nextLine();

        SeriesModel s = findSeriesById(deleteId);
        if (s == null) {
            System.out.println("Series with Series Id: " + deleteId + 
                    " was not found!");
            return;
        }

        System.out.print("Are you sure you want to delete series " + deleteId + 
                " from the system? Yes (y) to delete: ");
        String confirm = input.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            deleteSeriesById(deleteId);
            System.out.println("Series with Series Id: " + deleteId + 
                    " Was deleted!");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    // 5. Print series report
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series found!");
        } else {
            int count = 1;
            for (SeriesModel s : seriesList) {
                System.out.println("Series " + count);
                System.out.println(s.toString());
                count++;
            }
        }
    }

    // 6. Exit application
    public void ExitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
}
