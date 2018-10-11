package be.avondschool.fdw.hellojava.innerclasses.methodreferences;

import org.junit.Test;

import java.util.Comparator;

public class VoorbeeldAparteKlasseTotMethodReference {
    @Test public void main(){
        Overschrijving overschrijving1 = new Overschrijving("BE68539007547034",
                "NL05RABO1234123400");
        System.out.println(overschrijving1.IsInternationaal());
    }
}

// Met een aparte LandcodeComparer klasse (functional-interface implementerend datatype):
class Iban {
    public Iban(String nummer){ this.nummer = nummer; }

    private String nummer;
    public String getNummer() { return nummer; }

    public String getLandcode(){ return getNummer().substring(0, 2).toLowerCase(); }
}
class Overschrijving {
    public Overschrijving(String bronrekening, String doelrekening) {
        this.bronrekening = bronrekening;
        this.doelrekening = doelrekening;
    }

    private String bronrekening;
    public Iban getBronrekening() { return new Iban(bronrekening); }

    private String doelrekening;
    public Iban getDoelrekening() { return new Iban(doelrekening); }

    public boolean IsInternationaal() {
        Comparator<Iban> lcc = new LandcodeComparer();
        return (lcc.compare(getBronrekening(), getDoelrekening()) != 0);
    }
}
class LandcodeComparer implements Comparator<Iban> {
    @Override public int compare(Iban iban1, Iban iban2) {
        return iban1.getLandcode().compareTo(iban2.getLandcode());
    }
}

//// Met een static nested LandcodeComparer klasse (functional-interface implementerend datatype):
//class Iban {
//    public Iban(String nummer){ this.nummer = nummer; }
//
//    private String nummer;
//    public String getNummer() { return nummer; }
//
//    public String getLandcode(){ return getNummer().substring(0, 2).toLowerCase(); }
//}
//class Overschrijving {
//    public Overschrijving(String bronrekening, String doelrekening) {
//        this.bronrekening = bronrekening;
//        this.doelrekening = doelrekening;
//    }
//
//    private String bronrekening;
//    public Iban getBronrekening() { return new Iban(bronrekening); }
//
//    private String doelrekening;
//    public Iban getDoelrekening() { return new Iban(doelrekening); }
//
//    public boolean IsInternationaal() {
//        Comparator<Iban> lcc = new LandcodeComparer();
//        return (lcc.compare(getBronrekening(), getDoelrekening()) != 0);
//    }
//
//    static class LandcodeComparer implements Comparator<Iban> {
//        @Override public int compare(Iban iban1, Iban iban2) {
//            return iban1.getLandcode().compareTo(iban2.getLandcode());
//        }
//    }
//}

//// Met een lokale LandcodeComparer klasse (functional-interface implementerend datatype):
//class Iban {
//    public Iban(String nummer){ this.nummer = nummer; }
//
//    private String nummer;
//    public String getNummer() { return nummer; }
//
//    public String getLandcode(){ return getNummer().substring(0, 2).toLowerCase(); }
//}
//class Overschrijving {
//    public Overschrijving(String bronrekening, String doelrekening) {
//        this.bronrekening = bronrekening;
//        this.doelrekening = doelrekening;
//    }
//
//    private String bronrekening;
//    public Iban getBronrekening() { return new Iban(bronrekening); }
//
//    private String doelrekening;
//    public Iban getDoelrekening() { return new Iban(doelrekening); }
//
//    public boolean IsInternationaal() {
//        class LandcodeComparer implements Comparator<Iban> {
//            @Override public int compare(Iban iban1, Iban iban2) {
//                return iban1.getLandcode().compareTo(iban2.getLandcode());
//            }
//        }
//
//        Comparator<Iban> lcc = new LandcodeComparer();
//        return (lcc.compare(getBronrekening(), getDoelrekening()) != 0);
//    }
//}

//// Met een anonieme lokale klasse (functional-interface implementerend datatype):
//class Iban {
//    public Iban(String nummer){ this.nummer = nummer; }
//
//    private String nummer;
//    public String getNummer() { return nummer; }
//
//    public String getLandcode(){ return getNummer().substring(0, 2).toLowerCase(); }
//}
//class Overschrijving {
//    public Overschrijving(String bronrekening, String doelrekening) {
//        this.bronrekening = bronrekening;
//        this.doelrekening = doelrekening;
//    }
//
//    private String bronrekening;
//    public Iban getBronrekening() { return new Iban(bronrekening); }
//
//    private String doelrekening;
//    public Iban getDoelrekening() { return new Iban(doelrekening); }
//
//    public boolean IsInternationaal() {
//        Comparator<Iban> lcc = new Comparator<Iban>() {
//            @Override public int compare(Iban iban1, Iban iban2) {
//                return iban1.getLandcode().compareTo(iban2.getLandcode());
//            }
//        };
//        return (lcc.compare(getBronrekening(), getDoelrekening()) != 0);
//    }
//}

//// Met een lambda expressie, of dus een verkorte taalconstructie voor een
//// anonieme lokale klasse (functional-interface implementerend datatype):
//class Iban {
//    public Iban(String nummer){ this.nummer = nummer; }
//
//    private String nummer;
//    public String getNummer() { return nummer; }
//
//    public String getLandcode(){ return getNummer().substring(0, 2).toLowerCase(); }
//}
//class Overschrijving {
//    public Overschrijving(String bronrekening, String doelrekening) {
//        this.bronrekening = bronrekening;
//        this.doelrekening = doelrekening;
//    }
//
//    private String bronrekening;
//    public Iban getBronrekening() { return new Iban(bronrekening); }
//
//    private String doelrekening;
//    public Iban getDoelrekening() { return new Iban(doelrekening); }
//
//    public boolean IsInternationaal() {
//        Comparator<Iban> lcc =
//                (Iban iban1, Iban iban2) -> iban1.getLandcode().compareTo(iban2.getLandcode());
//        return (lcc.compare(getBronrekening(), getDoelrekening()) != 0);
//    }
//}

//// Met een method reference, opnieuw een verkorte taalconstructie voor een
//// anonieme lokale klasse (functional-interface implementerend datatype):
//class Iban {
//    public Iban(String nummer){ this.nummer = nummer; }
//
//    private String nummer;
//    public String getNummer() { return nummer; }
//
//    public String getLandcode(){ return getNummer().substring(0, 2).toLowerCase(); }
//
//    public static int compare(Iban iban1, Iban iban2) {
//        return iban1.getLandcode().compareTo(iban2.getLandcode());
//    }
//}
//class Overschrijving {
//    public Overschrijving(String bronrekening, String doelrekening) {
//        this.bronrekening = bronrekening;
//        this.doelrekening = doelrekening;
//    }
//
//    private String bronrekening;
//    public Iban getBronrekening() { return new Iban(bronrekening); }
//
//    private String doelrekening;
//    public Iban getDoelrekening() { return new Iban(doelrekening); }
//
//    public boolean IsInternationaal() {
//        Comparator<Iban> lcc = Iban::compare;
//        return (lcc.compare(getBronrekening(), getDoelrekening()) != 0);
//    }
//}
