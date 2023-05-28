package Training;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Times {
    //Explaining video:
    //https://www.youtube.com/watch?v=0XgdX5hDL4U&ab_channel=MaaikeBrightBoost
    public static void main(String[] args) {
        //dates
        LocalDate ld= LocalDate.now(); //gives you the current time
        LocalDate ld2= LocalDate.of(2023, 2, 2);//year, month, day.
        LocalDate ld3= LocalDate.of(2023, Month.JANUARY, 2);//you can use enum instead
        //add this doesnt change the original, it create a new one.
        ld3=ld3.plusDays(1);
        ld3=ld3.plusMonths(2); //this methods has implemented exceptions for thins like february 30. or something
        //susbtract with .minus() all this methods can be applyed to the other ones below.

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter dtf2= DateTimeFormatter.ofPattern("dd/MMMM/yyyy"); //tou can put any word between, you can put M or MMMM or MM
        System.out.println(ld3.format(dtf2)); //you can use also, dtf2.format(ld3)
/*
        //times
        LocalTime lt = LocalTime.of(1,1);//.of always show the constructor.
        System.out.println(lt);

        //both
        LocalDateTime ldt = LocalDateTime.of(ld3,lt);
        System.out.println(ldt);

        //zones
        /*for(String zone: ZoneId.getAvailableZoneIds()){
            System.out.println(zone);
        }
        ZonedDateTime zdt= ZonedDateTime.of(ldt,ZoneId.of("America/Bogota"));
        System.out.println(zdt);
        */
    }
}
