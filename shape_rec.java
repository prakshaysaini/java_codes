import java.util.Scanner;

class Shape {
    public Double getArea() {
        System.out.println("Area of Shape is undefined.");
        return 0.0;
    }
}

class Rectangle extends Shape {
     Double length;
     Double width;


    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Double getArea() {
        return length * width;
    }
}

public class shape_rec {  
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breadth of rectangle: ");
        Double l = sc.nextDouble();
        Double b = sc.nextDouble();
      
        Rectangle rectangle = new Rectangle(l, b);

        System.out.println("The area of the rectangle is: " + rectangle.getArea());
    }
}
