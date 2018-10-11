package be.avondschool.fdw.hellojava.temporal;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Voorbeeld {
    @Test public void main() {
        LocalTime thisSec = LocalTime.now();
        System.out.println("Nu: " + thisSec.getHour() + ":" + thisSec.getMinute() + ":" + thisSec.getSecond());

        LocalDate startAcademiejaar = LocalDate.of(2018, Month.SEPTEMBER, 1);
        System.out.println("Start academiejaar: " + startAcademiejaar);

        LocalDate startLessen; // 2de maandag van de maand
        if (startAcademiejaar.getDayOfWeek() == DayOfWeek.MONDAY){
            startLessen = startAcademiejaar.plusWeeks(1);
        } else {
            TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.MONDAY);
            startLessen = startAcademiejaar.with(adj).with(adj);
        }
        System.out.println("Start lessen: " + startLessen);

        LocalDate startAcademiejaarVolgendJaar = startAcademiejaar.withYear(2019);
        System.out.println("Start academiejaar volgend jaar: " + startAcademiejaarVolgendJaar);

        Period p = Period.between(startLessen, startAcademiejaarVolgendJaar);
        long totaalAantalDagen = ChronoUnit.DAYS.between(startLessen, startAcademiejaarVolgendJaar);
        System.out.println("Verschil: " + p.getYears() + " jaar, " + p.getMonths() + " maanden en " +
                p.getDays() + " dagen (" +
                totaalAantalDagen + " in totaal)");

        String input = "dec 25 2019  11:15 PM";
        DateTimeFormatter inputFormaat = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        LocalDateTime moment = LocalDateTime.parse(input, inputFormaat);
        DateTimeFormatter outputFormaat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String output = moment.format(outputFormaat);
        System.out.println(output);
    }
}
