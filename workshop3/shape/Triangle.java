package shapes;

/* This class creates a shape of type triangle */
public class Triangle implements Shape {
    /* triangle's sides */
    private double sideA;
    private double sideB;
    private double sideC;

    /** Constructor accepts three doubles for the sides,
     * throws an exception if data is negative or not valid */
    public Triangle(double sideA, double sideB, double sideC) throws TriangleException {
        if (sideA > 0 && sideB > 0 && sideC > 0
                && (((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideA + sideC) > sideB))) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        else {
            throw new TriangleException("Invalid side!");
            //System.out.println("Invalid side!");
        }
    }

    public double getSideA() { return  sideA; }

    public double getSideB() { return sideB; }

    public double getSideC() { return sideC; }

    public void setSideA(double sideA) throws TriangleException {
        if (sideA > 0) {
            this.sideA = sideA;
        }
        else {
            throw new TriangleException("Invalid side!");
            //System.out.println("Invalid side!");
        }
    }

    public void setSideB(double sideB) throws TriangleException {
        if (sideB > 0) {
            this.sideB = sideB;
        }
        else {
            throw new TriangleException("Invalid side!");
            //System.out.println("Invalid side!");
        }
    }

    public void setSideC(double sideC) throws TriangleException {
        if (sideC > 0) {
            this.sideC = sideC;
        }
        else {
            throw new TriangleException("Invalid side!");
            //System.out.println("Invalid side!");
        }
    }

    /*@Override
    public double getArea() {
        double s = 0.5 * (getSideA() + getSideB() + getSideC());
        return Math.sqrt(s * ((s - getSideA())*(s - getSideB())*(s - getSideB())));
    }*/

    /* Gets the perimeter of the triangle */
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    /* Returns a String representing the triangle and its perimeter */
    @Override
    public String toString() {
        return "Triangle {s1=" + getSideA()
                + ", s2=" + getSideB()
                + ", s3=" + getSideC()
                + "} perimeter = " + getPerimeter()
                /*+ ", area = " + getArea()*/;
    }
}