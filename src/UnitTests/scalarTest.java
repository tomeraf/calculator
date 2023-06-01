package UnitTests;
import calculator.Integer;
import calculator.*;
import org.junit.Assert;
import org.junit.Test;
public class scalarTest {
    Integer six = new Integer(6);
    Integer minusfive = new Integer(-5);
    Integer zero = new Integer(0);
    Rational half = new Rational(1,2);
    Rational minusOnePointFive = new Rational(-3,2);

    @Test
    public void addInteger() {
        Assert.assertEquals("answer 5",new Integer(6),six.add(zero));
        Assert.assertEquals("answer 1",new Integer(1),six.add(minusfive));

    }
    @Test
    public void addRational()
    {
        Assert.assertEquals("answer 13/2", new Rational(21,4),six.add(half));
        Assert.assertEquals("answer -3/2", new Rational(-3,2),zero.add(minusOnePointFive));

    }
    @Test
    public void mulzero() {
        Assert.assertEquals("answer 0",zero,six.mul(zero));
    }
    @Test
    public void mulInteger() {
        Assert.assertEquals("answer 36",new Integer(36),six.mul(six));
        Assert.assertEquals("answer -30",new Integer(-30),six.mul(minusfive));
    }
    @Test
    public void mulRational() {
        Assert.assertEquals("answer -5/2", new Rational(5,-2),minusfive.mul(half));
        Assert.assertEquals("answer -9",new Rational(-18,2),six.mul(minusOnePointFive));
    }
    @Test
    public void negTest() {
        Assert.assertEquals("answer 5", new Integer(5),minusfive.neg());
        Assert.assertEquals("answer -6", new Integer(-6),six.neg());
    }
    @Test
    public void powerTest() {
        Assert.assertEquals("answer 36", new Integer(36),six.power(2));
        Assert.assertEquals("answer 25", new Integer(25),minusfive.power(2));
        Assert.assertEquals("answer -125", new Integer(-125),minusfive.power(3));
    }
    @Test
    public void signTest() {
        Assert.assertEquals("answer -1", -1,minusfive.sign());
        Assert.assertEquals("answer 1", 1,half.sign());
        Assert.assertEquals("answer 0", 0,zero.sign());
    }
    @Test
    public void testToString() {
        Assert.assertEquals("answer -3/2", "-3/2",minusOnePointFive.toString());
        Assert.assertEquals("answer 6", "6",six.toString());
    }
    @Test
    public void testEquals() {
        Assert.assertEquals("expected False", false,six.equals(minusfive));
        Assert.assertEquals("expected true", true,six.equals(new Integer(6)));
        Assert.assertEquals("expected true", true,six.equals(new Rational(18,3)));
        Assert.assertEquals("expected true", true,six.equals(new Rational(-18,-3)));
        Assert.assertEquals("expected False", false,six.equals(minusOnePointFive));
        Assert.assertEquals("expected False", false,six.neg().equals(new Integer(6)));
        Assert.assertEquals("expected False", false,six.neg().equals(new Rational(-18,-3)));
    }
}
