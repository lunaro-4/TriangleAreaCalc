package ipiap.tarining.triangleareacalc;

public class Rectangle extends Figure {
    double a,b;
    double area;
    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
        area = a*b;
    }
}
