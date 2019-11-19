package shapes;
import java.lang.Math;
import java.text.DecimalFormat;
public class Circle implements Shape {
    private double radius;
    private CalculatorArea area = ()-> getradius()*getPerimeter()*Math.PI;
    public Circle(double radius) throws CircleException {
        if(radius > 0) {
            this.radius = radius;
        }else{
            throw new CircleException("Invalid radius!");
        }
    }
    public double getradius(){
        return radius;
    }
    @Override
    public double getPerimeter(){
        //return 2*Math.PI*radius;
       return   2*Math.PI*getradius() ;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00000");
        return "Circle {r= "+getradius() + "} perimeter ="+ df.format(getPerimeter()) + " Area: " + df.format(area.calarea());
    }
}