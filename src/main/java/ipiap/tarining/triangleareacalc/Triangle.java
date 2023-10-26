package ipiap.tarining.triangleareacalc;

public class Triangle {
    double a,b,c;
    double perim,area;
    public Triangle(double a, double b, double c) throws IncorrectFigException {
        if (a>b+c||b>a+c||c>a+b)
            throw new IncorrectFigException();
        this.a = a;
        this.b = b;
        this.c = c;
        perim = (a + b + c);
        double p = perim/2;
        area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
