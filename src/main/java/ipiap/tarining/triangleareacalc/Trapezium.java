package ipiap.tarining.triangleareacalc;

public class Trapezium {
    double a,b, h;
    double perim,area;
    public Trapezium(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
        area = ((a+b)/2)*h;
    }
}
