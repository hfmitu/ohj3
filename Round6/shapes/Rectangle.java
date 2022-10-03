public class Rectangle implements IShapeMetrics{
    
    private double height;
    private double width;

    public Rectangle(double height, double width){
        this.height=height;
        this.width=width;
    }

    public String toString(){
        return ("Rectangle with height " + height + " and width " + width);
    }
    
    public String name() {
        return "rectangle";
    }

    
    public double area() {

        return height*width;
    }

    
    public double circumference() {
        return 2*height+2*width;
    }

}
