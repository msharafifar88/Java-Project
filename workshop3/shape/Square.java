package shapes;

/** This class creates a shape of type square, a subclass of rectangle */
public class Square extends Rectangle {
    /* square's sides */
    private double side;

    /** Constructor accepts a double for the sides,
     * throws an exception if data is negative*/
    public Square(double side) throws SquareException, ParallelogramException {
        super(side, side);
        if (side > 0) {
            this.side = side;
        }
        else {
            throw new SquareException("Invalid side!");
            //System.out.println("Invalid side(s)!");
        }
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) throws SquareException {
        if (side > 0) {
            this.side = side;
        }
        else {
            throw new SquareException("Invalid side!");
            //System.out.println("Invalid side!");
        }
    }

    public double squareValue(ShapeArea sa) { return sa.getArea(); }
    ShapeArea area = () -> Math.pow(getSide(), 2);
    /*@Override
    public double getArea() { return Math.pow(getSide(), 2); }*/

    /* Gets the perimeter of the square */
    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    /* Returns a String representing the square and its perimeter */
    @Override
    public String toString() {
        return "Square {s=" + getSide()
                + "} perimeter = " + getPerimeter()
                + ", area = " + squareValue(area);
    }
}
