package be.avondschool.fdw.hellojava.exceptions;

import org.junit.Test;

public class Voorbeeld {
    @Test public void main() {
        Artikel artikel1 = new Artikel();

        WerpExceptieOpEnHandelZeAf(artikel1, 15);

        try {
            WerptExceptieOpEnHandelZeNietAf(artikel1, 15);
            System.out.println("Btw ingesteld op: " + artikel1.getBtw());
        } catch (BtwNietOkException e) {
            System.out.println("Fout bij instellen van btw.");
        }
    }
    static void WerpExceptieOpEnHandelZeAf(Artikel a, int btw) {
        try {
            a.setBtw(btw);
            System.out.println("Btw ingesteld op: " + a.getBtw());}
        catch(BtwNietOkException e) {
            System.out.println("Fout bij instellen van btw.");
        }
    }
    static void WerptExceptieOpEnHandelZeNietAf(Artikel a, int btw) throws BtwNietOkException {
        a.setBtw(btw);
    }
}

class Artikel {
    private int btw;
    public void setBtw(int value) throws BtwNietOkException {
        if (value != 6 && value != 21)
            throw new BtwNietOkException("Btw moet 6 of 21 zijn.");
        else
            btw = value;
    }
    public int getBtw() {
        return btw;
    }
}
class BtwNietOkException extends Exception {
    public BtwNietOkException(String message){
        super(message);
    }
}
