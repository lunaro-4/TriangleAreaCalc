package ipiap.tarining.triangleareacalc;

public class IncorrectFigException extends Exception{
    public IncorrectFigException() {
        super("Figure with such parameters is impossible");
    }
}
