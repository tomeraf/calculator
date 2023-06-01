package UnitTests;
import calculator.Integer;
import calculator.*;
import org.junit.Assert;
import org.junit.Test;

public class monoTest {
    private Monomial sevenXexpoTWO = new Monomial(2,new Integer(7));
    private Monomial mthreeXexpoTWO = new Monomial(2,new Integer(-3));
    private Monomial twelveXexpoONE = new Monomial(1,new Integer(12));
    private Monomial mthirdXexpoTWO = new Monomial(2,new Rational(-1,3));
    private Monomial fourXexpoTWO = new Monomial(2, new Rational(4,1));
    private Monomial zero = new Monomial(2, new Integer(0));
    @Test
    void addInteger() {
        Assert.assertEquals("expected 4x^2", fourXexpoTWO, sevenXexpoTWO.add(mthreeXexpoTWO));
    }
    @Test
    void addRational() {
        Assert.assertEquals("expected 11/3x^2", new Monomial(2,new Rational(11,3)), mthirdXexpoTWO.add(fourXexpoTWO));
    }
    @Test
    void add() {
        Assert.assertEquals("expected 20/3x^2", new Monomial(2,new Rational(20,3)), sevenXexpoTWO.add(mthirdXexpoTWO));
    }
    @Test
    void addNull() {
        Assert.assertEquals("Null", null, sevenXexpoTWO.add(twelveXexpoONE));
    }
    @Test
    void mulInteger() {
        Assert.assertEquals("expected -21x^4", new Monomial(4, new Integer(-21)), sevenXexpoTWO.mul(mthreeXexpoTWO));
    }
    @Test
    void mulRational() {
        Assert.assertEquals("expected -4/3x^4", new Monomial(4, new Rational(-4,3)), mthirdXexpoTWO.mul(fourXexpoTWO));
    }
    @Test
    void mul() {
        Assert.assertEquals("expected -7/3x^4", new Monomial(4, new Rational(-7,3)), sevenXexpoTWO.mul(mthirdXexpoTWO));
    }
    @Test
    void mulDiffCoef() {
        Assert.assertEquals("expected -4x^3", new Monomial(3, new Integer(-4)), mthirdXexpoTWO.mul(twelveXexpoONE));
    }
    @Test
    void evaluateInteger() {
        Assert.assertEquals("expected 28", new Integer(28), sevenXexpoTWO.evaluate(new Integer(2)));
    }
    @Test
    void evaluateRational() {
        Assert.assertEquals("expected -4/3", new Rational(-4,3), mthirdXexpoTWO.evaluate(new Integer(2)));
    }
    @Test
    void derivativeInteger() {
        Assert.assertEquals("expected 14x", new Monomial(1,new Integer(14)), sevenXexpoTWO.derivative());
    }
    @Test
    void derivativeRational() {
        Assert.assertEquals("expected -2/3x", new Monomial(1,new Rational(-2,3)), mthirdXexpoTWO.derivative());
    }
    @Test
    void signInteger() {
        Assert.assertEquals("exepcted 1", 1, sevenXexpoTWO.sign());
    }
    @Test
    void signRational() {
        Assert.assertEquals("expected -1", -1, mthirdXexpoTWO.sign());
    }
    @Test
    void signZero() {
        Assert.assertEquals("expected 0", 0, zero.sign());
    }
    @Test
    void testEqualsInteger() {
        Assert.assertEquals("expected true", true, sevenXexpoTWO.equals(new Monomial(2,new Integer(7))));
    }
    @Test
    void testEqualsRational() {
        Assert.assertEquals("expected true", true, fourXexpoTWO.equals(new Monomial(2,new Rational(8,2))));
    }
    @Test
    void testEquals() {
        Assert.assertEquals("expected true", true, fourXexpoTWO.equals(new Monomial(2,new Integer(4))));
    }
}
