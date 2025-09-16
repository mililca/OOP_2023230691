import java.time.LocalDate; // Importing to get today's date
import java.util.Arrays; // Importing Arrays class

public class Main {
    public static void main(String[] args) {
        printDetails(); // Printing out the details at the beginning
        Dictaphone[] dictaphones = demonstrateDictaphones(); // Creating an array of Dictaphones
        displayOldDictaphones(dictaphones); // Showing Dictaphones made before 2015
        displayMostSuitableDictaphone(dictaphones); // Showing the most suitable Dictaphone
    }

    // The following method will print my details (name, index number, today's date)
    private static void printDetails() {
        String name = "Natalia Shelepova";
        String indexNumber = "2023230691";
        String today = LocalDate.now().toString(); // Getting today's date in YYYY-MM-DD format

        System.out.println(name + ", " + indexNumber + ", " + today); // Printing out the retrieved info
    }

    // The following method will create and return an array of Dictaphones
    private static Dictaphone[] demonstrateDictaphones() { 
        // Creating five different Dictaphones
        Dictaphone[] dictaphones = { 
            new Dictaphone("D01", 129.99, "Vista", "VS129", 2009, 2400, new MemoryCard("Miele", 512, CardClass.CLASS_6)),
            new Dictaphone("D02", 569.99, "Sony", "SN569", 2018, 1200, new MemoryCard("Sony", 256, CardClass.CLASS_10)),
            new Dictaphone("D03", 89.99, "Olympus", "OMP89", 2014, 1800, new MemoryCard("Hyundai", 128, CardClass.CLASS_10)),
            new Dictaphone("D04", 179.99, "Toshiba", "TSB179", 2013, 2500, new MemoryCard("Samsung", 64, CardClass.CLASS_4)),
            new Dictaphone("D05", 229.99, "Philips", "PHS229", 2021, 1100, new MemoryCard("Barracuda", 32, CardClass.CLASS_6))
        };
        return dictaphones; // Returning the array of Dictaphones
    }

    // The following method will display Dictaphones manufactured before 2015
    private static void displayOldDictaphones(Dictaphone[] dictaphones) {
        System.out.println("\nDictaphones manufactured before 2015:");
        for (Dictaphone d : dictaphones) { // Looping through each Dictaphone
            if (d.getYearOfManufacture() < 2015) // Checking if the year is before 2015
                System.out.println("\n" + d); // Printing out the Dictaphone details
        }
    }

    // The following method will display the most suitable Dictaphone
    private static void displayMostSuitableDictaphone(Dictaphone[] dictaphones) {
        Arrays.sort(dictaphones); // Sorting the Dictaphones by their suitability
        System.out.println("\nMost Suitable Dictaphone:\n" + dictaphones[dictaphones.length - 1]); // Printing out the last Dictaphone (highest suitability)
    }
}
