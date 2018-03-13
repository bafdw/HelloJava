package be.avondschool.fdw.hellojava;

import org.junit.Test;

public class OefeningOpgave {
    @Test public void main() {
        System.out.println("Oefening aan te vullen...");

//        Bestelbon bb1 = new Bestelbon();
//        VulBestelbonOp(bb1);
//        Print(bb1, "Orginele bestelbon");
//
//        SorteerBestelbon(bb1);
//        Print(bb1, "Default sorteergedrag (aantal)");
//
//        SorteerBestelbonOpProductGewicht(bb1);
//        Print(bb1, "Sorteren op product gewicht");
//
//        ZoekInBestelbonOp(bb1);
//
//        KoppelEventhandlerAanEvent(bb1);
//
//        PrintTotaalAantalBesteldeProducten(bb1);
    }

//    static void VulBestelbonOp(List<BestelbonRegel> bb) {
//        //Maak de nodige klassen (Product, BestelbonRegel en Bestelbon) om volgende
//        //clientlogica mogelijk te maken:
//
//        //Een Product heeft een bepaalde naam (String) en gewicht (double).
//        Product p1 = new Product("appel") {{ setGewicht(300.0); }};
//        Product p2 = new Product("peer") {{ setGewicht(200.0); }};
//        Product p3 = new Product("banaan") {{ setGewicht(100.0); }};
//        Product p4 = new Product("wortel") {{ setGewicht(150.0); }};
//
//        //Een BestelbonRegel houdt het bestelde aantal van een bepaald Product bij:
//        BestelbonRegel bbr1 = new BestelbonRegel(p1, 20); //2de parameter is aantal
//        BestelbonRegel bbr2 = new BestelbonRegel(p2, 30);
//        BestelbonRegel bbr3 = new BestelbonRegel(p3, 10);
//        BestelbonRegel bbr4 = new BestelbonRegel(p4, 5);
//
//        //Een Bestelbon is een verzameling (lijst) van BestelbonRegel's.
//        //Op zijn minst is het manipuleren van de collectie via .add en .remove methods mogelijk.
//        bb.add(bbr1);
//        bb.add(bbr4);
//        bb.add(bbr2);
//        bb.add(bbr3);
//        bb.remove(bbr4);
//        System.out.println("Op index 0: " + bb.get(0)); // bbr1
//        System.out.println("Op index 1: " + bb.get(1)); // bbr2
//        System.out.println("Op index 2: " + bb.get(2)); // bbr3
//    }

//    static void Print(Bestelbon bb, String label) {
//        //Maak het mogelijk het totale gewicht op te vragen (.totaalGewicht).
//        //Voorzie (als dat nog niet het geval was) de mogelijkheid om
//        //over de elementen van de collectie te itereren.
//        System.out.println(label + ": Bestelbon (tot.gew.:" + bb.totaalGewicht() + "):");
//
//        for (BestelbonRegel bbr : bb)
//            System.out.println("." + bbr.toString());
//        System.out.println();
//
//        //Levert zoiets op als:
//        //Bestelbon: Bestelbon (tot.gew.:13000.0):
//        //.Bestelbonregel: appel(gew.:300.0) x 20
//        //.Bestelbonregel: peer(gew.:200.0) x 30
//        //.Bestelbonregel: banaan(gew.:100.0) x 10
//    }

//    static void SorteerBestelbon(Bestelbon bb) {
//        // By default zou gesorteerd moeten worden op het bestelde aantal.
//        Collections.sort(bb);
//    }

//    static void SorteerBestelbonOpProductGewicht(Bestelbon bb) {
//        Comparator<BestelbonRegel> bbrpgv;
//
//        //Implementeer de BestelbonRegelProductGewichtVergelijker:
//        bbrpgv = new BestelbonRegelProductGewichtVergelijker();
//
//        //Probeer ook eens hetzelfde met een anonieme lokale klassedefinitie:
//        bbrpgv = ...
//
//        //Probeer nogmaals met een lambda expressie
//        bbrpgv = ...
//
//        Collections.sort(bb, bbrpgv);
//    }

//    static void ZoekInBestelbonOp(Bestelbon bb) {
//        //Maak voor de volledig van het elementtype duidelijk op basis van wat
//        //logische gelijkheid wordt gebaseerd (combinatie naam en gewicht).
//        Product p1 = new Product("appel") {{ setGewicht(300.0); }};
//        BestelbonRegel bbr1Copy = new BestelbonRegel(p1, 20);
//        System.out.println("Bevat bbr1Copy: " + bb.contains(bbr1Copy));  // true
//        System.out.println("Positie bbr1Copy: " + bb.indexOf(bbr1Copy)); // 2 (na sorteren op gewicht, anders 0)
//    }

//    static void KoppelEventhandlerAanEvent(Bestelbon bb) {
//        //Implementeer een observer-pattern om een eventhandler te kunnen koppelen aan
//        //een event "BestelbonRegelAdded".
//
//        //Koppeling willen me mogelijk maken via onderstaande .setOnBestelbonRegelAddedListener,
//        //waarvan de call bijvoorbeeld met een lokale anonieme klassedefinitie wordt gemaakt:
//        bb.setOnBestelbonRegelAddedListener(new BestelbonRegelAddedObserver() {
//            @Override
//            public void update(BestelbonRegel bbr) {
//                System.out.println(bbr.toString() + ": toegevoegd.");
//            }
//        });
//        //Of waarvan de call bijvoorbeeld met een lambda expressie wordt gemaakt:
//        bb.setOnBestelbonRegelAddedListener(bbr -> System.out.println(bbr.toString() + ": jaja, toegevoegd."));
//
//        Product p4 = new Product("prei") {{ setGewicht(400.0); }};
//        Product p5 = new Product("bloemkool") {{ setGewicht(500.0); }};
//        BestelbonRegel bbr4 = new BestelbonRegel(p4, 40);
//        BestelbonRegel bbr5 = new BestelbonRegel(p5, 50);
//
//        bb.add(bbr4);
//        //Bestelbonregel: prei(gew.:400.0) x 40: toegevoegd.
//        //Bestelbonregel: prei(gew.:400.0) x 40: jaja, toegevoegd.
//        bb.add(bbr5);
//        //Bestelbonregel: bloemkool(gew.:500.0) x 50: toegevoegd.
//        //Bestelbonregel: bloemkool(gew.:500.0) x 50: jaja, toegevoegd.
//    }

//    static void PrintTotaalAantalBesteldeProducten(Bestelbon bb) {
//        //Maak gebruik van de nodige intermediate operations en terminal operation (sum())
//        //om de som van bestelde aantallen op te vragen van alle producten
//        //die maximaal 200 gram wegen:
//        double sum = bb.stream(). ...;
//        System.out.println("Som van bestelde aantallen (v alle producten die maximaal 200 wegen): " + sum); // 40.0
//    }
}
