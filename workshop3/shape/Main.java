package main;

import shapes.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static Shape[] shapes = new Shape[50];

    public static void main(String[] args) {
        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");
        String s;
        int c = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");
                // your code
                switch (tokens[0]) {
                    case "Circle":
                        try {
                            if (Double.valueOf(tokens[1]) > 0 && tokens.length == 2) {
                                shapes[c] = new Circle(Double.valueOf(tokens[1]));
                            }
                            else {
                                if (tokens.length == 2) {
                                    System.out.println("Invalid radius!");
                                }
                            }
                        }
                        catch (CircleException ce) {
                            System.out.println(ce.getMessage());
                        }
                        break;
                    case "Parallelogram":
                        try {
                            if (Double.valueOf(tokens[1]) > 0 && Double.valueOf(tokens[2]) > 0 && tokens.length == 3) {
                                shapes[c] = new Parallelogram(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]));
                            }
                            else {
                                if (tokens.length == 3) {
                                    System.out.println("Invalid side(s)!");
                                }
                            }
                        }
                        catch (ParallelogramException pe) {
                            System.out.println(pe.getMessage());
                        }
                        break;
                    case "Rectangle":
                        try {
                            if (Double.valueOf(tokens[1]) > 0 && Double.valueOf(tokens[2]) > 0 && tokens.length == 3) {
                                shapes[c] = new Rectangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]));
                            }
                            else {
                                if (tokens.length == 3) {
                                    System.out.println("Invalid side(s)!");
                                }
                            }
                        }
                        catch (ParallelogramException re) {
                            System.out.println(re.getMessage());
                        }
                        break;
                    case "Square":
                        try {
                            if (Double.valueOf(tokens[1]) > 0 && tokens.length == 2) {
                                shapes[c] = new Square(Double.valueOf(tokens[1]));
                            }
                            else {
                                if (tokens.length == 2) {
                                    System.out.println("Invalid side(s)!");
                                }
                            }
                        }
                        catch (ParallelogramException|SquareException se) {
                            System.out.println(se.getMessage());
                        }
                        break;
                    case "Triangle":
                        try {
                            if (Double.valueOf(tokens[1]) > 0 && Double.valueOf(tokens[2]) > 0 && Double.valueOf(tokens[3]) > 0
                                    && (((Double.valueOf(tokens[1]) + Double.valueOf(tokens[2])) > Double.valueOf(tokens[3]))
                                    && ((Double.valueOf(tokens[2]) + Double.valueOf(tokens[3])) > Double.valueOf(tokens[1]))
                                    && ((Double.valueOf(tokens[1]) + Double.valueOf(tokens[3])) > Double.valueOf(tokens[2])))
                                    && tokens.length == 4) {
                                shapes[c] = new Triangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]), Double.valueOf(tokens[3]));
                            }
                            else {
                                if (tokens.length == 4) {
                                    System.out.println("Invalid side!");
                                }
                            }
                        }
                        catch (TriangleException te) {
                            System.out.println(te.getMessage());
                        }
                        break;
                    default:
                }
                if (shapes[c] != null) { c++; }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n" + c + " shapes were created:");
        double minTriPer = 1000;
        double maxCirPer = 0;

        for (Shape x : shapes) {
            if (x != null) {
                System.out.println(x.toString() + "\n");

                if (x instanceof Triangle && x.getPerimeter() < minTriPer) {
                    minTriPer = x.getPerimeter();
                }
                if (x instanceof Circle && x.getPerimeter() > maxCirPer) {
                    maxCirPer = x.getPerimeter();
                }
            }
        }

        System.out.println("------->Task 2 ... <-------");
        double triTotal = 0;
        double paraTotal = 0;
        //

        for (Shape y : shapes) {
            if (y instanceof Triangle) {
                if (y.getPerimeter() == minTriPer) {
                    y = null;
                }
                if (y != null) {
                    triTotal += y.getPerimeter();
                }
            }
            if (y instanceof Circle && y.getPerimeter() == maxCirPer) {
                y = null;
            }
            if (y instanceof Parallelogram && !(y instanceof Rectangle)) {
                paraTotal += y.getPerimeter();
            }
        }

        for (Shape z : shapes) {
            if (z != null) {
                //c++;
                System.out.println(z.toString() + "\n");
            }
        }

        System.out.println("------->Task 3 ... <-------");
        System.out.println("Total perimeter of Parallelogram is: " + paraTotal);
        System.out.println("Total perimeter of Triangle is: " + triTotal);
    }

    /*public double minimumPerimeterOfShape(Shape[] shape) { // how to isolate one shape type? so that minPer isn't overwritten unnecessarily?
        double minPerimeter = 1000; // should it be set to the first instance of the shape type.getPerimeter() instead? How, without looping again?
        for (Shape x : shape) {
            *//*switch (x.getClass().getName()) { // would need to make a minPerimeter variable for each Shape type
                case "Triangle":
                    if (x.getPerimeter() < minPerimeter) {
                        minPerimeter = x.getPerimeter();
                        return minPerimeter;
                    }
                    break;
                case "Parallelogram":
                    if (x.getPerimeter() < minPerimeter) {
                        minPerimeter = x.getPerimeter();
                        return minPerimeter;
                    }
                    break;
                case "Rectangle":
                    if (x.getPerimeter() < minPerimeter) {
                        minPerimeter = x.getPerimeter();
                        return minPerimeter;
                    }
                    break;
                case "Square":
                    if (x.getPerimeter() < minPerimeter) {
                        minPerimeter = x.getPerimeter();
                        return minPerimeter;
                    }
                    break;
                case "Circle":
                    if (x.getPerimeter() < minPerimeter) {
                        minPerimeter = x.getPerimeter();
                        return minPerimeter;
                    }
                    break;
                default:
            }*//*
        }
        return minPerimeter;
    }*/

    /*public double maximumPerimeterOfShape(Shape[] shape) {
        Class cls = clsName.getClass();
        double maxPerimeter = 0;
        for (Shape x : shapes) {
        if (x instanceof cls && x.getPerimeter() > maxPerimeter) {
            maxPerimeter = x.getPerimeter();
        }
        return maxPerimeter;
    }*/

    /*public double totalPerimeterOfShape(Shape obj) {
        double totalPerimeter = 0;

        return totalPerimeter;
    }*/
}