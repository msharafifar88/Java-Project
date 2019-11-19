package shapes;
import java.text.DecimalFormat;
public class Rectangle extends Parallelogram {

    public Rectangle(double a,double b) throws ParallelogramException {
        super(a,b);
    }
    private CalculatorArea area = () -> getside_a() *getside_b() ;
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0000##");
        return "Rectangle {w="+getside_a()+", h="+getside_b()+"} perimeter = " + df.format(getPerimeter())+ "" +
                " Area: " + df.format(area.calarea());
    }
}
