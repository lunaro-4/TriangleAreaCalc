package ipiap.tarining.triangleareacalc;

public class NonNaturalValue extends Exception{
    NonNaturalValue(){
        super("Side length must non negative");
    }
}
