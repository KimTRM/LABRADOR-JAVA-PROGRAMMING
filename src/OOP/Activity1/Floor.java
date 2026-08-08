package OOP.Activity1;

public class Floor {
    // Encapsulated fields
    private double length;
    private double width;

    // Constructor
    public Floor(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Setters
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    // Calculates the area of the floor
    public double getArea() {
        return length * width;
    }
}
