package ipiap.tarining.triangleareacalc;

import java.util.ArrayList;
import java.util.Arrays;

public class Trapezium extends Figure{
    double a,b, c, d;
    double perim,area;
    public Trapezium(double a, double b, double c,double d) throws IncorrectFigException {
        if (a>b+c+d||b>a+c+d||c>a+b+d||d>a+b+c)
            throw new IncorrectFigException();
        setSides(a, b, c, d);
        if (!testTrapezium())
            throw new IncorrectFigException();
        calcArea();
    }

    private boolean testTrapezium() {
        return true;
    }

    private void calcArea() {
        double midLine = (a+d)/2;
        double sideDelt = d-a;
        double x = sideDelt*sideDelt+b*b-c*c;
        double y = 2*sideDelt;
        double z = Math.sqrt(b*b-(x/y)*(x/y));
        this.area= midLine*z;
    }

    private void setSides(double a, double b, double c, double d) {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
        double min =Double.MAX_VALUE;
        for (double m :
                sides) {
            min = Math.min(min, m);
        }
        sides.remove(min);
        this.a = min;
        double max =Double.MIN_VALUE;
        for (double m :
                sides) {
            max = Math.max(max, m);
        }
        sides.remove(max);
        this.d = max;
        this.b = sides.get(0);
        this.c = sides.get(1);
    }
}
