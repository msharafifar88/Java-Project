package shapes;

/* This class creates a shape of type parallelogram */
public class Parallelogram implements Shape {
    /* parallelogram's length and width */
    private double length;
    private double width;

    /** Constructor accepts two doubles for the length and width,
     * throws an exception if data is negative */
    public Parallelogram(double length, double width) throws ParallelogramException {
        if (length > 0 && width > 0) {
            this.length = length;
            this.width = width;
        }
        else {
            throw new ParallelogramException("Invalid side(s)!");
            //System.out.println("Invalid side(s)!");
        }
    }

    public double getLength() { return length; }

    public double getWidth() { return width; }

    public void setLength(double length) throws ParallelogramException {
        if (length > 0) {
            this.length = length;
        }
        else {
            throw new ParallelogramException("Invalid length!");
            //System.out.println("Invalid length!");
        }
    }

    public void setWidth(double width) throws ParallelogramException {
        if (width > 0) {
            this.width = width;
        }
        else {
            throw new ParallelogramException("Invalid width!");
            //System.out.println("Invalid width!");
        }
    }

    /*@Override
    public double getArea() { return getLength() * getWidth(); }*/

    /* Gets the perimeter of the parallelogram */
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    /* Returns a String representing the parallelogram and its perimeter */
    @Override
    public String toString() {
        return "Parallelogram {w= " + + getWidth()
                + ", h=" + getLength()
                + "} perimeter = " + getPerimeter()
                /*+ ", area = " + getArea()*/;
    }
}
