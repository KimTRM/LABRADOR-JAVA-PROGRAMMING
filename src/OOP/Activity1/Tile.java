package OOP.Activity1;

public class Tile {
    // Encapsulated fields
    private String brand;
    private double lengthCm;
    private double widthCm;
    private double price;

    // Constructor
    public Tile(String brand, double length, double width, double price) {
        this.brand = brand;
        this.lengthCm = length;
        this.widthCm = width;
        this.price = price;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public double getLengthCm() {
        return lengthCm;
    }

    public double getWidthCm() {
        return widthCm;
    }

    public double getCostPerTile() {
        return price;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLengthCm(double lengthCm) {
        this.lengthCm = lengthCm;
    }

    public void setWidthCm(double widthCm) {
        this.widthCm = widthCm;
    }

    public void setCostPerTile(double costPerTile) {
        this.price = costPerTile;
    }


    // Calculates the number of tiles needed for a given floor area
    public int computeTilesNeeded(double floorArea) {
        double tileArea = (lengthCm / 100) * (widthCm / 100);
        return (int) Math.ceil(floorArea / tileArea);
    }

    // Calculates the total cost for a given floor area
    public double computeCost(double floorArea) {
        int tilesNeeded = computeTilesNeeded(floorArea);
        return tilesNeeded * price;
    }

    // Calculates the total estimated budget
    public double getTotalBudget(double floorArea) {
        return computeTilesNeeded(floorArea) * price;
    }
}
