package UnitTests;
import calculator.Integer;
import calculator.*;
import org.junit.Assert;
import org.junit.Test;
public class polyTest {
    private Polynomial poly1 = Polynomial.build("2 1 -4");
    private Polynomial poly2 = Polynomial.build("0 0 2 2");
    private Polynomial poly3 = Polynomial.build("1/2 4/3");
    private Polynomial poly4 = Polynomial.build("2 -1");
    @Test
    public void build() {
        Assert.assertEquals("expected 2-x-4x^2", Polynomial.build("2 1 -4"), poly1);
    }
    @Test
    public void add12() {
        Assert.assertEquals("expected 2+x-2x^2+2x^3", Polynomial.build("2 1 -2 2"), poly1.add(poly2));
    }
    public void add13() {
        Assert.assertEquals("expected 5/2+7/3x-4x^2", Polynomial.build("5/2 7/3 -4"), poly1.add(poly3));
    }
    @Test
    public void mul34() {
        Assert.assertEquals("expected -1+19/6x-4/3x^2", Polynomial.build("-1 19/6 -4/3"), poly3.mul(poly4));
    }
    @Test
    public void evaluateInteger1() {
        Assert.assertEquals("expected 20", new Integer(20), poly1.evaluate(new Integer(2)));
    }
    @Test
    public void evaluateRational1() {
        Assert.assertEquals("expected 7/2", new Rational(7,2), poly1.evaluate(new Rational(1,2)));

    }
    @Test
    public void derivative2() {
        Assert.assertEquals("expected 1-4x", Polynomial.build("1 -4"), poly2.derivative());
    }
    @Test
    public void testEquals1() {
        Assert.assertEquals("expected true", true, poly1.equals(Polynomial.build("1 -4/2 3")));
    }
}
