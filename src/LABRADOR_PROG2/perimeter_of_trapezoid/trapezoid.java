package LABRADOR_PROG2.perimeter_of_trapezoid;

// Is used to group  related class

import java.util.Scanner;

// Telling the java compiler that you need access to 
public class trapezoid {
    // This line declares the start of a class name

    static void main(String[] args) {

        // References the variables that will be used
        double perimeter, side1, side2, side3, side4;
        // Creates the scanner
        Scanner input = new Scanner(System.in);

        // Prints the text to let the person what to do
        System.out.println("Enter value for side 1:  ");
        // Input for getting side 1 of perimeter of the trapezoid
        side1 = input.nextDouble();
        // Prints the text to let the person what to do
        System.out.println("Enter value for side 2:  ");
        // Input for getting side 2 of perimeter of the trapezoid
        side2 = input.nextDouble();
        // Prints the text to let the person what to do
        System.out.println("Enter value for side 3:  ");
        // Input for getting side 3 of perimeter of the trapezoid
        side3 = input.nextDouble();
        // Prints the text to let the person what to do
        System.out.println("Enter value for side 4:  ");
        // Input for getting side 4 of perimeter of the trapezoid
        side4 = input.nextDouble();

        // Formula to find the perimeter of the trapezoid for calculation
        // It adds each sides to get the perimrter
        perimeter = side1 + side2 + side3 + side4;

        // Prints the result of the formula
        // It lets the person know the answer
        System.out.println("The perimeter of the trapezoid is " + perimeter);
    }

}


	
	
	