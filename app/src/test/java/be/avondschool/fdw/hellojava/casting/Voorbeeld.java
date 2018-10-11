package be.avondschool.fdw.hellojava.casting;

import org.junit.Test;
import java.util.List;

public class Voorbeeld {
    @Test public void main(){
        Voertuig ps = new RijdendVoertuig();
        //List<String> wielen = ps.getWielen();          // -> compile-error
        if (ps instanceof RijdendVoertuig) { // dynamic type check
            List<String> wielen = ((RijdendVoertuig) ps).getWielen(); // cast operator
        }

        Klasse1 k1 = new Klasse2();
        k1.Test();
    }
}
class Klasse1 {
    public void Test() { System.out.println("Klasse1.Test");}
}
class Klasse2 extends Klasse1 {
    @Override public void Test() {
        //super.Test();
        System.out.println("Klasse2.Test");}
}
class Voertuig {
    //...
}
class RijdendVoertuig extends Voertuig {
    private List<String> wielen;
    public List<String> getWielen() { return wielen; }
    // ...
}
