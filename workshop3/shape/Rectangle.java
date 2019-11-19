package shapes;

/** This class creates a shape of type rectangle, a subclass of parallelogram */
public class Rectangle extends Parallelogram {

    /** Constructor accepts two doubles for the length and width, calls parallelogram constructor */
    public Rectangle(double length, double width) throws ParallelogramException {
        super(length, width);
    }

    public double rectangleValue(ShapeArea sa) {
        return sa.getArea();
    }
    ShapeArea area = () -> getLength() * getWidth();


    /* Returns a String representing the rectangle and its perimeter */
    @Override
    public String toString() {
        return "Rectangle {w=" + getWidth()
                + ", h=" + getLength()
                + "} perimeter = " + getPerimeter()
                + ", area = " + rectangleValue(area);
    }
}
