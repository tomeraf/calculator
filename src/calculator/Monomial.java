package calculator;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public int GetExp(){return exponent;}
    public Monomial(int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Monomial add(Monomial m){
        if (this.exponent == m.exponent){
            return (new Monomial(exponent,(this.coefficient.add(m.coefficient))));
        } else {
            return null;
        }
    }
    public Monomial mul(Monomial m){
        return (new Monomial(this.exponent+m.exponent, this.coefficient.mul(m.coefficient)));
    }
    public Scalar evaluate(Scalar s){
        return (s.power(this.exponent).mul(this.coefficient));
    }
    public Monomial derivative(){
        return (new Monomial(exponent-1, this.coefficient.mul(new Integer(exponent))));
    }
    public int sing(){
        return this.coefficient.sign();
    }
    public boolean equals(Object o){
        if (o instanceof Monomial){
            Monomial mono = (Monomial) o;
            return (mono.coefficient.equals(this.coefficient)&& mono.exponent==this.exponent);
        } else {
            return false;
        }
    }
    public String toString(){
        String ans = "X^";
        String exp;
        String coef;
        if (this.exponent==1) {
            ans="X";
            exp="";
        }
        else if(exponent==0){
            ans="";
            exp="";
        }
        else {
            exp = ""+exponent;
        }
        if (this.coefficient.equals(new Rational(1,1) ))
            coef = "";
        else if (this.coefficient.equals(new Rational(-1,1)))
            coef = "-";
        else if (this.coefficient.equals(new Rational(0,1)))
            return "0";
        else {
            coef = coefficient.toString();
        }
        ans = coef+ans+exp;
        if(ans.length()==0)
            return "1";
        if(ans.length()==1 && ans.charAt(0)=='-')
            return "-1";
        return  ans;
    }
}
