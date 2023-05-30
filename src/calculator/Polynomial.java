package calculator;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Monomial> monos;

    public Polynomial(){this.monos= new LinkedList<>();}
    public Polynomial(LinkedList<Monomial> monos)
    {
        this.monos = monos;
    }

    public static Polynomial build(String input) {
        LinkedList<Monomial> poly = new LinkedList<Monomial>();
        LinkedList<String> strList = new LinkedList<String>();//deviding the numbers in the strings

        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) != ' ') {
                String str = "";
                while (i < input.length() && input.charAt(i) != ' ' ) {
                    str = str + input.charAt(i);
                    i++;
                }
                strList.addLast(str);
            }


        if (strList.size() == 0) {//if the string was empty
            Monomial M = new Monomial(1, new Integer(0));
            poly.addLast(M);

        } else {//starting to build the list
            int i = 0;//exponent
            for (String str : strList) {
                Monomial M = null;
                if (str.indexOf('/') == -1)//calculator.Integer number coefficient
                {
                    Integer sca = new Integer(java.lang.Integer.parseInt(str));;
                    M = new Monomial(i, sca);
                } else//calculator.Rational number coefficient
                {
                    Rational sca = null;
                    int nome = 0, deno = 0;

                    nome = java.lang.Integer.parseInt(str.substring(0,str.indexOf('/')));
                    str = str.substring(str.indexOf('/')+1, str.length());//getting the denominator
                    deno = java.lang.Integer.parseInt(str);
                    sca = new Rational(nome, deno);
                    M = new Monomial(i, sca);
                }
                poly.addLast(M);
                i++;
            }
        }
        return new Polynomial(poly);
    }



    public Polynomial add(Polynomial p){
        Iterator<Monomial> Iter1 = this.monos.iterator();
        Iterator<Monomial> Iter2 = p.monos.iterator();
        LinkedList<Monomial> MonoAdd = new LinkedList<>();

        while(Iter1.hasNext() && Iter2.hasNext()){
            Monomial tes = Iter1.next();
            Monomial tes2 = Iter2.next();
            MonoAdd.addLast(tes.add(tes2));

          //  MonoAdd.addLast(Iter1.next().add(Iter2.next()));
        }


        while(Iter1.hasNext())
                MonoAdd.addLast(Iter1.next());

        while(Iter2.hasNext())
            MonoAdd.addLast(Iter2.next());

        return new Polynomial(MonoAdd);
    }
    public Polynomial mul(Polynomial p){
        Polynomial PolyMul = new Polynomial();
        for(Monomial M: monos)
        {
            LinkedList<Monomial>  MonoMul = new LinkedList<>();
            for(Monomial MP: p.monos)
            {
                M.mul(MP);
                MonoMul.addLast(M.mul(MP));
            }
            Polynomial PolyAdd = new Polynomial(MonoMul);
            PolyAdd.PolyFixer();
            PolyMul=PolyMul.add(PolyAdd);
        }
        return PolyMul;
    }
    public Scalar evaluate(Scalar s){
        Scalar soul = new Rational(0,1);
        for(Monomial M:monos){
            Scalar eva =M.evaluate(s);
            soul=soul.add(eva);
        }
        return soul;
    }
    public Polynomial derivative(){
        LinkedList<Monomial> MonoDer = new LinkedList<>();
        for(Monomial M:monos)
            MonoDer.addLast(M.derivative());
        return new Polynomial(MonoDer);
    }
    public boolean equals(Object o){
        if(o instanceof Polynomial)
        {
            Iterator<Monomial> Iter1 = this.monos.iterator();
            Iterator<Monomial> Iter2 = (((Polynomial)o).monos.iterator());
            while(Iter1.hasNext() && Iter2.hasNext())
                if(!Iter1.next().equals(Iter2.next()))
                    return false;

            if(!Iter1.hasNext() && !Iter2.hasNext())
                return true;
        }
        return false;
    }
    public String toString(){
        String s="";
        Monomial ZERO = new Monomial(0,new Integer(0));
        for(Monomial M:monos)
            if(!M.equals(ZERO))//checks for not calculator.Monomial 0
                s = s+M.toString() + "+";

        return s.substring(0,s.length()-1);
    }

    private void PolyFixer(){
        int i=0;
        Iterator<Monomial> Iter = monos.iterator();
        while(Iter.hasNext()) {
            Monomial cur = Iter.next();
            if (cur.GetExp() != i) {
                monos.add(i, new Monomial(i, new Integer(0)));
                this.PolyFixer();
                break;
            }
            i++;
        }
    }
}
