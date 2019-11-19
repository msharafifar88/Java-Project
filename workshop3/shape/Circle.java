package shapes;

/* This class creates a shape of type circle */
public class Circle implements Shape {
    /* circle's radius */
    private double radius;

    /** Constructor accepts a double for the radius,
     * throws an exception if data is negative */
    public Circle(double radius) throws CircleException {
        if (radius > 0)
            this.radius = radius;
        else {
            throw new CircleException("Invalid radius!");
            //System.out.println("Invalid radius!");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws CircleException {
        if (radius > 0)
            this.radius = radius;
        else {
            throw new CircleException("Invalid radius!");
            //System.out.println("Invalid radius!");
        }
    }

    public double circleValue() {
        ShapeArea area = () -> Math.PI * getRadius() * getRadius();
        return area.getArea();
    }

    //@Override
    //public double getArea() { return Math.PI * (getRadius() * Math.pow(getRadius(), 2)); }

    /* Gets the perimeter of the circle */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    /* Returns a String representing the circle and its perimeter */
    @Override
    public String toString() {
        return "Circle {r=" + getRadius()
                + "} circumference = " + getPerimeter()
                + ", area = " + circleValue( );
    }
}
