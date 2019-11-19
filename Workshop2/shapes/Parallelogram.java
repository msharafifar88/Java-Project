package shapes;
import java.text.DecimalFormat;
public class Parallelogram implements Shape{
    private double side_a;
    private double side_b;

    public Parallelogram(double len,double wid) throws ParallelogramException{
        if(len > 0 && wid > 0) {
            this.side_a = len;
            this.side_b = wid;
        }else {
            throw new ParallelogramException("Invalid side(s)!");
        }
    }

    public void setDimensions(double l,double w ){
        this.side_a = l;
        this.side_b = w;
    }

    public  double getside_a(){

        return side_a;
    }

    public double getside_b()
    {
        return side_b;
    }

    @Override
    public double getPerimeter(){
        return 2*getside_a() + 2*getside_b();
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0000##");
        return "Parallelogram {w="+getside_b()+", h="+getside_a()+"} perimeter = " + df.format(getPerimeter())+ "";
    }
}