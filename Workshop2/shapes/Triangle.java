package shapes;

import java.text.DecimalFormat;

public class Triangle implements Shape {
    double side_a;
    double side_b;
    double side_c;

    Triangle (double a,double b,double c)throws TriangleException{
        if(a > 0 && b > 0 && c > 0 &&  a < b+c && b < a+c && c < a+b){
        side_a = a;
        side_b = b;
        side_c = c;
        }else{
            throw new TriangleException("Invalid side(s)!");
        }
    }

    public double geta() {
        return side_a;
    }
    public double getb(){

        return side_b;
    }
    public double getc(){
        return side_c;
    }
    public double getPerimeter() {

        return (geta()+getc()+getb()) ;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0000##");
        return "Triangle {s1=" + geta() + ", s2=" + getb() + ", s3=" + getc() + "} perimeter = " + df.format(getPerimeter());
    }
}
