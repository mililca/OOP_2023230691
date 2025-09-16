// The Dictaphone class extends the Product class
// Implements Comparable to compare Dictaphones based on suitability
public class Dictaphone extends Product implements Comparable<Dictaphone> {
    
    // Private attributes of a Dictaphone
    private String manufacturerName;  // Dictaphone manufacturer
    private String model;             // Dictaphone model name
    private int yearOfManufacture;    // Dictaphone manufacture year
    private double batteryCapacity;   // Dictaphone battery capacity
    private MemoryCard memoryCard;    // Dictaphone memory card

    // Constructor is called when creating a new Dictaphone object
    public Dictaphone(String productID, double price, String manufacturerName, 
                      String model, int yearOfManufacture, 
                      double batteryCapacity, MemoryCard memoryCard) {
        super(productID, price, manufacturer); // Calling the constructor of the Product class
        this.manufacturerName = manufacturerName;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.batteryCapacity = batteryCapacity;
        this.memoryCard = memoryCard;
    }

    // Getter method to get the manufacturer name
    public String getManufacturerName() { 
        return manufacturerName; 
    }

        // Getter method to get the model
    public String getModel() { 
        return model; 
    }

      // Getter method to get the year the Dictaphone was made
    public int getYearOfManufacture() { 
        return yearOfManufacture; 
    }

    // The following method calculates the suitability of a Dictaphone based on battery and memory
    @Override
    public double getSuitability() {
        // If battery is zero or the year is >= 2025, return 0 (not suitable)
        if (batteryCapacity <= 0 || yearOfManufacture >= 2025) return 0;

        // Part 1: Battery factor (1 - 1 / Battery Capacity)
        double batteryFactor = 1 - (1.0 / batteryCapacity);
        
        // Part 2: Memory factor (Quality of Memory Card * Memory Capacity)
        double memoryFactor = memoryCard.getQuality() * memoryCard.getCapacity();
        
        // Part 3: Denominator (100 * sqrt(2025 - Year of Manufacture))
        double denominator = 100 * Math.sqrt(2025 - yearOfManufacture);

        // Final Suitability Score Calculation
        return batteryFactor * (memoryFactor / denominator); 
    }

    // This method allows Dictaphones to be compared based on their suitability
    @Override
    public int compareTo(Dictaphone other) {
        return Double.compare(this.getSuitability(), other.getSuitability()); 
    }

    // This method returns a string with the Dictaphone object details
    @Override
    public String toString() {
        return """
               Dictaphone Details:
               Product ID: """ + getProductID() + "\n" +
               "Manufacturer: " + getManufacturer() + "\n" +
               "Price: $" + getPrice() + "\n" +
               "Model: " + model + "\n" +
               "Year of Manufacture: " + yearOfManufacture + "\n" +
               "Battery Capacity: " + batteryCapacity + "mAh\n" +
               "Memory Card Info:\n" +
               "  - Manufacturer: " + memoryCard.getManufacturer() + "\n" +
               "  - Capacity: " + memoryCard.getCapacity() + "GB\n" +
               "  - Class: " + memoryCard.getCardClass(); 
    }
}
