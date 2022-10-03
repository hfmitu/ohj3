public class Circle implements IShapeMetrics{

    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    public String name(){
        return "circle";
    }

    public double circumference(){
        return radius*2*pi;
    }

    public String toString(){
        return ("Circle with radius: " + radius);
    }

    public double area(){
        return pi*(radius*radius);
    }
    

}
