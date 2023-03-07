import java.util.*;     // to import all built-in libraries


abstract class Shape
{
    float area;

    abstract public void input();
    abstract public void compute();

    
    public void disp()
    {
        System.out.println("The area is " + area);
    }
}

class Rectangle1 extends Shape    // class names can't be repeated within same package so used Rectangle1
{
    float length;
    float breadth;
   

    public void input()
    {
        System.out.println("Calculation of Rectangle area :");
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter length of Rectangle");
        length=scan.nextFloat();
        System.out.println("Please enter breath of Rectangle");
        breadth=scan.nextFloat();

    }
    public  void compute()
    {
        area = length * breadth;
    }

    
}

class Square1 extends Shape
{
    float length;
   

    public void input()
    {
        System.out.println("Calculation of Square radius :");
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter length of Square");
        length=scan.nextFloat();
       

    }
    public  void compute()
    {
        area = length * length;
    }

    
}

class Circle1 extends Shape
{
    float radius;
    

    public void input()
    {
        System.out.println("Calculation of Circle area :");
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter radius of circle");
        radius=scan.nextFloat();
       
    }
    public  void compute()
    {
        area = 3.14f * radius * radius;
    }
    
}

class Geometry 
{
    public void poly(Shape ref)   // using parent class reference to call child methods
    {
        ref.input();
        ref.compute();
        ref.disp();

    }
}


public class Calculate_OOPS 
{
    public static void main(String[] args) 
    {


        Rectangle1 rec=new Rectangle1();
        Square1 sq=new Square1();
        Circle1 c=new Circle1();

        Geometry g=new Geometry();
        g.poly(rec);      // parent class reference holds all three child class objects here
        g.poly(sq);
        g.poly(c);
        
    }
    
}