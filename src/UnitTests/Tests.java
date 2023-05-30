package UnitTests;

import calculator.Integer;
import calculator.*;

public class Tests {
    public static void p(String str){//im lazy
        System.out.println(str);
    }
    public static void Run(){
    p("Testing calculator.Integer:");
    p("creating new calculator.Integer of 3:");
    Integer I3 = new Integer(3);
    p("Testing ToString:");
    p(I3.toString());
    p("Testing add:");
    Integer I2 = new Integer(2);
    p("adding 2 + 3= " + I3.add(I2).toString());
    p("Testing mul:");
    p("2x3= "+ I2.mul(I3).toString());
    p("Testing neg:");
    p("2 -> " + I2.neg().toString());
    p("Testing power:");
    p("2^3 = "+ I2.power(3).toString());
    p("Testing equals:");
    p("2==3? : "+ I2.equals(I3));

    p("");

    p("Testing calculator.Rational:");
    p("creating new calculator.Rational of 3/2:");
    Rational R32 = new Rational(3,2);
    p("Testing ToString:");
    p(R32.toString());
    p("Testing add:");
    Rational R23 = new Rational(2,3);
    p("adding 3/2 + 2/3= " + R32.add(R23).toString());
    p("Testing mul:");
    p("(2/3)x(3/2)= "+ R23.mul(R32).toString());
    p("Testing neg:");
    p("2/3 -> " + R23.neg().toString());
    p("Testing power:");
    p("(2/3)^3 = "+ R23.power(3).toString());
    p("Testing equals:");
    p("2/3==3/2? : "+ R23.equals(R32));

    p("");

    p("Testing calculator.Monomial:");
    p("creating new calculator.Monomial of (4/5)X^2:");
    Monomial M1 = new Monomial(2,new Rational(4,5));
    p("Testing ToString:");
    p(M1.toString());
    p("Testing add:");
    Monomial M2 = new Monomial(2,new Rational(2,10));
    p("adding 4/5X^2 + 2/10X^2= " + M1.add(M2).toString());
    p("Testing mul:");
    p("4/5X^2 x 2/10X^2= = "+ M1.mul(M2).toString());
    p("Testing evaluate:");
    p("4/5X^2 -> x=4/2 --> " + M1.evaluate(new Rational(4,2)).toString());
    p("Testing derivative:");
    p("4/5X^2 ->  "+ M1.derivative().toString());
    p("Testing equals:");
    p("4/5X^2==2/10X^2? : "+ M1.equals(M2));

    p("");

    p("Testing calculator.Polynomial:");
    p("creating new calculator.Polynomial of 1+(4/5)X+ 2X^2:");
    Polynomial P1 = Polynomial.build("1 4/5 2");
    p("Testing ToString:");
    p(P1.toString());
    p("Testing add:");
    Polynomial P2 = Polynomial.build("2/3 0 2 1");
    p("adding (1+(4/5)X+ 2X^2 )+ (2/3 +2X^2 + x^3)= " + P1.add(P2).toString());
    p("Testing mul:");
    p("(1+(4/5)X+ 2X^2 ) x (2/3 +2X^2 + x^3)=  "+ P1.mul(P2).toString());
    p("Testing evaluate:");
    p("1+(4/5)X+ 2X^2 -> x=5/1 --> " + P1.evaluate(new Rational(5,1)).toString());
    p("Testing derivative:");
    p("1+(4/5)X+ 2X^2 ->  "+ P1.derivative().toString());
    p("Testing equals:");
    p("1+(4/5)X+ 2X^2==2/3 +2X^2 + x^3? : "+ P1.equals(P2));
    }
    public static void main(String[] args){

        Tests.Run();

    }

}
