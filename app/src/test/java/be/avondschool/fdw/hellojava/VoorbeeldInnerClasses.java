package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VoorbeeldInnerClasses {
    @Test
    public void main() throws InterruptedException {
        Bankrekening b = new Bankrekening();

        b.Stort(1000d);
        b.HaalAf(2000d);
        printTransacties(b.getUittreksel());

        Thread.currentThread().sleep(1000); // even wachten om volgend uittreksel een ander moment te geven

        b.Stort(3000d);
        printTransacties(b.getUittreksel());
    }

    private void printTransacties(Bankrekening.Uittreksel uittreksel) {
        System.out.println("Uittreksel op " + uittreksel.getMoment());
        for (Transactie transactie : uittreksel.getTransacties())
            System.out.println(transactie.getMoment() + ": " + transactie.getWaarde());
        System.out.println();
    }
}

// Met een non-static nested ("inner") class:
class Bankrekening {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void Stort(double bedrag) {
        saldo += bedrag;
        addTransactie(bedrag);
    }
    public void HaalAf(double bedrag) {
        saldo -= bedrag;
        addTransactie(-bedrag);
    }

    private List<Transactie> transacties = new ArrayList<>();
    private void addTransactie(double bedrag) {
        transacties.add(new Transactie(LocalDateTime.now(), bedrag));
    }

    public Uittreksel getUittreksel() {

        return new Uittreksel(LocalDateTime.now(), transacties);
    }
    class Uittreksel {
        public Uittreksel(LocalDateTime moment, List<Transactie> transacties) {
            this.moment = moment;

            List<Transactie> opTeLeverenTransacties = new ArrayList<>();
            for (int i = 0; i < transacties.size() &&
                    transacties.get(i).getMoment().compareTo(moment) <= 0; i++)
                opTeLeverenTransacties.add(transacties.get(i));
            this.transacties = opTeLeverenTransacties;
        }

        private LocalDateTime moment;
        public LocalDateTime getMoment() {
            return moment;
        }

        public double getSaldo() {
            return saldo;
        }

        private List<Transactie> transacties;
        public List<Transactie> getTransacties() {
            return transacties;
        }
    }
}

// Vergelijk dit met een static nested class aanpak:
//class Bankrekening {
//    private double saldo;
//    public double getSaldo() { return saldo; }
//
//    public void Stort(double bedrag) {
//        saldo += bedrag;
//        addTransactie(bedrag);
//    }
//    public void HaalAf(double bedrag) {
//        saldo -= bedrag;
//        addTransactie(-bedrag);
//    }
//
//    private List<Transactie> transacties = new ArrayList<>();
//    private void addTransactie(double bedrag) {
//        transacties.add(new Transactie(LocalDateTime.now(), bedrag));
//    }
//
//    public Uittreksel getUittreksel() {
//        LocalDateTime nu = LocalDateTime.now();
//
//        return new Uittreksel(nu, saldo, transacties);
//    }
//    static class Uittreksel {
//        public Uittreksel(LocalDateTime moment, double saldo, List<Transactie> transacties){
//            this.moment = moment;
//
//            this.saldo = saldo;
//
//            List<Transactie> opTeLeverenTransacties = new ArrayList<>();
//            for(int i = 0; i < transacties.size() &&
//                    transacties.get(i).getMoment().compareTo(moment) <= 0; i++)
//                opTeLeverenTransacties.add(transacties.get(i));
//            this.transacties = opTeLeverenTransacties;
//        }
//
//        private LocalDateTime moment;
//        public LocalDateTime getMoment() { return moment; }
//
//        private double saldo;
//        public double getSaldo() { return saldo; }
//
//        private List<Transactie> transacties;
//        public List<Transactie> getTransacties() {
//            return transacties;
//        }
//    }
//}

class Transactie {
    public Transactie(LocalDateTime moment, double waarde) {
        this.moment = moment;
        this.waarde = waarde;
    }

    private LocalDateTime moment;

    public LocalDateTime getMoment() {
        return moment;
    }

    private double waarde;

    public double getWaarde() {
        return waarde;
    }
}