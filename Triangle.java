/*
 * The Triangle Program
 *
 * @author  Liam Fletcher
 * @version 1.0
 * @since   2022-01-06
 */

public class Triangle {
    // Initializing fields
    private double sideLength1;
    private double sideLength2;
    private double sideLength3;
    private double angle1;
    private double angle2;
    private double angle3;
    private double semiPerimeter;
    private double area;

    /**
     * Setting field values with a constructor.
     */
    public Triangle(double firstInput, double secondInput, double thirdInput) {
        this.sideLength1 = firstInput;
        this.sideLength2 = secondInput;
        this.sideLength3 = thirdInput;

        // Finding and initializing the first angle
        this.angle1 = Math.acos((Math.pow(this.sideLength2, 2) +
                Math.pow(this.sideLength3, 2) -
                Math.pow(this.sideLength1, 2)) /
            (2 * this.sideLength2 * this.sideLength3));

        // Finding and initializing the second angle
        this.angle2 = Math.acos((Math.pow(this.sideLength3, 2) +
                Math.pow(this.sideLength1, 2) -
                Math.pow(this.sideLength2, 2)) /
            (2 * this.sideLength3 * this.sideLength1));

        // Finding and initializing the third angle
        this.angle3 = Math.acos((Math.pow(this.sideLength1, 2) +
                Math.pow(this.sideLength2, 2) -
                Math.pow(this.sideLength3, 2)) /
            (2 * this.sideLength1 * this.sideLength2));

        // Finding and initializing the semiperimeter of the triangle
        this.semiPerimeter = (this.sideLength1 + this.sideLength2 +
            this.sideLength3) / 2;

        // Finding and initializing the area of the triangle
        this.area = Math.sqrt(this.semiPerimeter *
            (this.semiPerimeter - this.sideLength1) *
            (this.semiPerimeter - this.sideLength2) *
            (this.semiPerimeter - this.sideLength3));

        // Ensuring the triangle the user created is valid
        isTriangleValid();
    }

    /**
     * This method shows a string containing all the angle measurements.
     */
    public String getAngles() {
        // Making a string with the angle values
        String angleString = this.angle1 + " radians, " + this.angle2 + " radians, " +
            this.angle3 + " radians";

        // Returning the string with the angle values
        return angleString;
    }

    /**
     * This method shows the area of the triangle.
     */
    public double getArea() {
        // Returning the area of the triangle
        return this.area;
    }

    /**
     * This method shows the area of the circumcircle of the triangle.
     */
    public double getCircumcircle() {
        // Calculating circumcircle radius
        double circumcircleRadius = (this.sideLength1 * this.sideLength2 *
            this.sideLength3) / (4 * this.area);

        // Calculating circumcircle area
        double circumcircleArea = Math.PI * Math.pow(circumcircleRadius, 2);

        // Returning circumcircle area
        return circumcircleArea;
    }

    /**
     * This method finds the height of the triangle.
     */
    public double getHeight() {
        // Calculating the height of the triangle
        double height = (2 * this.area) / this.sideLength1;

        // Returning the height
        return height;
    }

    /**
     * This method finds the incircle radius of the triangle.
     */
    public double getIncircleRadius() {
        // Calculating the incircle radius
        double radius = this.area / this.semiPerimeter;

        // Returning the incircle radius
        return radius;
    }

    /**
     * This method tells the user what kind of triangle they created.
     */
    public String getName() {
        if (this.sideLength1 == this.sideLength2 &&
            this.sideLength2 == this.sideLength3 &&
            this.sideLength1 == this.sideLength3) {
            return "Equilateral Triangle";
        } else if (this.sideLength1 == this.sideLength2 ||
            this.sideLength2 == this.sideLength3 ||
            this.sideLength1 == this.sideLength3) {
            return "Isosceles Triangle";
        } else if (this.angle1 == Math.PI / 2 ||
            this.angle2 == Math.PI / 2 || this.angle3 == Math.PI / 2) {
            return "Right Triangle";
        } else {
            return "Scalene Triangle";
        }
    }

    /**
     * This method finds the perimeter of the triangle.
     */
    public double getPerimeter() {
        // Calculating the perimeter of the triangle
        double perimeter = this.sideLength1 + this.sideLength2 + this.sideLength3;

        // Returning the perimeter
        return perimeter;
    }

    /**
     * This method shows the semiperimeter of the triangle.
     */
    public double getSemiperimeter() {
        // Returning the semiperimeter of the triangle
        return this.semiPerimeter;
    }

    /**
     * This method shows a string containing all the side length measurements.
     */
    public String getSideLengths() {
        // Making a string with the side length values
        String sideString = this.sideLength1 + " CM, " + this.sideLength2 + " CM, " +
            this.sideLength3 + " CM";

        // Returning the string with the side length values
        return sideString;
    }

    /**
     * This method figures out whether or not the triangle can exist.
     */
    protected Boolean isTriangleValid() {
        // Calculating variables for future use in method
        double roundedAngle = Math.floor((this.angle1 + this.angle2 + this.angle3) *
            100000) / 100000;
        double roundedPi = Math.floor(Math.PI * 100000) / 100000;

        if (this.sideLength1 <= 0 || this.sideLength2 <= 0 ||
            this.sideLength3 <= 0) {
            // Throwing that triangle cannot exist
            throw null;
        } else if (roundedAngle != roundedPi) {
            // Throwing that triangle cannot exist
            throw null;
        } else {
            // Returning that triangle can exist
            System.out.println("Triangle Valid");
            return true;
        }
    }
}
