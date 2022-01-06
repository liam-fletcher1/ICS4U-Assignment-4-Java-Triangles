/*
 * The Triangle Program
 *
 * @author  Liam Fletcher
 * @version 1.0
 * @since   2022-01-06
 */

import java.util.Scanner; // Import the Scanner class

public class Main {
    /**
     * This function allows the user to enter in the sides of a triangle and the
     * program will tell the user certain properties of the triangle.
     */
    public static void main(String[] args) {
        try {
            // Initializing the scanner for the triangle side lengths
            Scanner sideLengthInput = new Scanner(System.in);

            // User input for the first side length
            System.out.print("Enter the first side length (this will be considered" +
                " the base of the triangle) (CM): ");
            double userInput1 = sideLengthInput.nextDouble();

            // User input for the second side length
            System.out.print("Enter the second side length (CM): ");
            double userInput2 = sideLengthInput.nextDouble();

            // User input for the third side length
            System.out.print("Enter the third side length (CM): ");
            double userInput3 = sideLengthInput.nextDouble();

            // Initializing the triangle
            Triangle userTriangle = new Triangle(userInput1, userInput2, userInput3);

            // Telling the user the kind of triangle they created
            System.out.println("");
            System.out.println("Type of Triangle: " + userTriangle.getName());

            // Telling the user the side length measurements of the triangle
            System.out.println("Side Length Measurements: " +
                userTriangle.getSideLengths());

            // Telling the user the angle measurements of the triangle
            System.out.println("Angle Measurements: " + userTriangle.getAngles());

            // Telling the user the height of the triangle
            System.out.println("Height: " + userTriangle.getHeight() + " CM");

            // Telling the user the semiperimeter of the triangle
            System.out.println("Semiperimeter: " +
                userTriangle.getSemiperimeter() + " CM");

            // Telling the user the perimeter of the triangle
            System.out.println("Perimeter: " + userTriangle.getPerimeter() + " CM");

            // Telling the user the area of the triangle
            System.out.println("Area: " + userTriangle.getArea() + " CM^2");

            // Telling the user the radius of the incircle of the triangle
            System.out.println("Incircle Radius: " +
                userTriangle.getIncircleRadius() + " CM");

            // Telling the user the area of the circumcircle of the triangle
            System.out.println("Circumcircle Area: " +
                userTriangle.getCircumcircle() + " CM^2");

            // Catches and tells the user what error occured
        } catch (NullPointerException e) {
            System.out.println("");
            System.out.println("ERROR: Specified parameters are unable to create " +
                "real triangle");
        } catch (Exception e) {
            System.out.println("");
            System.out.println("ERROR: Invalid Input");
        }
    }
}
