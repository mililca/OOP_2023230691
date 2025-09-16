// Stores data about the product identifier in the inventory of the store, and price
public abstract class Product {

    private final String productID; // Unique identifier for each product
    private double price; // The price of the product
    private String manufacturer; // The manufacturer of the product

    public Product(String productID, double price, String manufacturer) {
        this.productID = productID; // Assigning a unique product ID
        this.price = price; // Assigning a price to the product
        this.manufacturer = manufacturer; // Assigning the manufacturer to the product
    }

    // Getter methods to get the product ID, price, and manufacturer
    public String getProductID() { return productID; }
    public double getPrice() { return price; }
    public String getManufacturer() { return manufacturer; }

    // Abstract method that will be implemented in the extended classes
    public abstract double getSuitability();
}
