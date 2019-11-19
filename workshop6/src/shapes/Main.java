package shapes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static public int arrayCount(String file){
    int objQty = 0;
    String lineOfFile ;
    try(BufferedReader read = new BufferedReader(new FileReader(file)) ) {
        while ((lineOfFile = read.readLine()) != null) {

            String[] tokens = lineOfFile.split(",");
            int pos = lineOfFile.indexOf('-');
            if (pos == -1) {
                if (tokens.length == 2 && tokens[0].equals("Circle")) {
                    objQty++;
                } else if (tokens.length == 4 && tokens[0].equals("Triangle")) {
                        if(Double.parseDouble(tokens[1]) < (Double.parseDouble(tokens[2]) + Double.parseDouble(tokens[3]))
                        && Double.parseDouble(tokens[2]) < (Double.parseDouble(tokens[1]) + Double.parseDouble(tokens[3]))
                        && Double.parseDouble(tokens[3]) < (Double.parseDouble(tokens[1]) + Double.parseDouble(tokens[2]))) {
                            objQty++;
                        }
                } else if (tokens.length == 2 && tokens[0].equals("Square")) {
                    objQty++;
                } else if (tokens.length == 3 && tokens[0].equals("Parallelogram")) {
                    objQty++;
                } else if (tokens.length == 3 && tokens[0].equals("Rectangle")) {
                    objQty++;
                }
            }
        }
    }catch(IOException e){
        System.out.println(e);
    }
    return objQty;
    };

    static public Shape[] arrayLoader(String fileName){
    String lineOfFile;
    int index = 0;
    Shape[] shapeArr = new Shape[arrayCount(fileName)];

    try(BufferedReader read = new BufferedReader(new FileReader(fileName))){
       while ((lineOfFile = read.readLine()) != null) {

           String[] tokens = lineOfFile.split(",");

           if (tokens.length == 2 && tokens[0].equals("Circle")) {
               try{
                   shapeArr[index] = new Circle(Double.parseDouble(tokens[1]));
                   index++;
               }catch(CircleException e){
                   System.out.println(e.getMessage());
               }
               catch (Exception e){
                   System.out.println(e.getMessage());
               }

           }else if (tokens.length == 4 && tokens[0].equals("Triangle")) {
               try {
                   shapeArr[index] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                   index++;
               }catch (TriangleException e){
                   System.out.println(e.getMessage());
               }catch (Exception e){
                   System.out.println(e.getMessage());
               }

           } else if (tokens.length == 2 && tokens[0].equals("Square")) {
               try {
                   shapeArr[index] = new Square(Double.parseDouble(tokens[1]));
                   index++;
               }catch (SquareException e){
                   System.out.println(e.getMessage());
               }catch (Exception e){
                   System.out.println(e.getMessage());
               }
           } else if (tokens.length == 3 && tokens[0].equals("Parallelogram")) {
               try {
                   shapeArr[index] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                   index++;
               }catch (ParallelogramException e){
                   System.out.println(e.getMessage());
               }catch (Exception e){
                   System.out.println(e.getMessage());
               }
           } else if (tokens.length == 3 && tokens[0].equals("Rectangle")) {
               try {
                   shapeArr[index] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                   index++;
               }catch (ParallelogramException e){
                   System.out.println(e.getMessage());
               }catch (Exception e){
                   System.out.println(e.getMessage());
               }
           }
       }
    }catch(IOException e){
       System.out.println(e);
    }
    System.out.println();
    System.out.println(index + " shapes were created:" );
    System.out.println();
    return shapeArr;
    };

    static public Shape[] minmaxFinder(Shape[] input){
    double TrianglePrimier = 0;
    double CirclePrimier = 0;
    boolean flagTriangle = true;
    boolean flagCircle = true;
    int nullCount = 0;
    int indexForOutput = 0;

    for (int i=0 ; i < input.length && (flagTriangle || flagCircle) ; i++){
        if( input[i] instanceof Triangle ){
            TrianglePrimier = input[i].getPerimeter();
            flagTriangle = false;
        }
        if( input[i] instanceof Circle ){
            CirclePrimier = input[i].getPerimeter();
            flagCircle = false;
        }
    }

    for(Shape test : input){
        if( test instanceof Triangle ){
           if(test.getPerimeter() < TrianglePrimier){
               TrianglePrimier = test.getPerimeter();
           }
        }
        if( test instanceof Circle ){
            if(test.getPerimeter() > CirclePrimier ) {
                CirclePrimier = test.getPerimeter();
            }
        }
    }

    for(int i = 0 ; i< input.length ; i++){

        if( input[i] instanceof Triangle ){
            if(input[i].getPerimeter() == TrianglePrimier){
                input[i] = null;
                nullCount++;
            }
        }
        if( input[i] instanceof Circle ) {
            if (input[i].getPerimeter() == CirclePrimier) {
                input[i] = null;
                nullCount++;
            }
        }
    }

   Shape[] output = new Shape[input.length - nullCount];

    for(int i = 0 ; i < input.length ; i++){
        if(input[i] != null){
            output[indexForOutput] = input[i];
            indexForOutput++;
        }
    }
    return output;
    };

    static public Double getTotalParallelogram(Shape[] input){
    double TotalParallelogramPerimeter = 0;
    for(int i = 0 ; i < input.length ; i++){
        if(input[i] instanceof Parallelogram && !(input[i] instanceof Rectangle)){
            TotalParallelogramPerimeter = TotalParallelogramPerimeter + input[i].getPerimeter();
        }
    }
    return TotalParallelogramPerimeter;
    };

    static public Double getTotalTriangle(Shape[] input){
    double TotalTrianglePerimeter = 0;
    for(int i = 0 ; i < input.length ; i++){
        if(input[i] instanceof Triangle){
            TotalTrianglePerimeter += input[i].getPerimeter();
        }
    }

    return TotalTrianglePerimeter;
    };

    public static void main(String[] args) {
                String fileName = "/Users/saam/OneDrive - Seneca/Seneca/4th/JAC444/workshop6/src/shapes/shapes.txt";

                System.out.println("------->JAC 444 Assignment 1<------");
                System.out.println("------->Task 1 ... <-------");

            Shape[] shapeArr = arrayLoader(fileName);
                for (int i=0 ; i < shapeArr.length ; i++){
                System.out.println(shapeArr[i]);
                }

                System.out.println("------->Task 2 ... <-------");

            Shape[] afterDelete = minmaxFinder(shapeArr);
                for (int i=0 ; i < afterDelete.length ; i++){
                System.out.println(afterDelete[i]);
                }

                System.out.println("------->Task 3 ... <-------");
                System.out.println( "Total perimeter of Parallelogram is: " + getTotalParallelogram(afterDelete));
                System.out.println( "Total perimeter of Triangle is: " + getTotalTriangle(afterDelete));
    }
}