package data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateExercise {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date.toString());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

        String formattedLocalDate = localDate.format(formatter);
        String formattedDate = localDate.format(formatter);
        System.out.println(formattedDate);
        System.out.println(formattedLocalDate);

        System.out.println();
        String dateString = "12-06-2023";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        Date newDate = dateFormat.parse(dateString);
        System.out.println(newDate.toString());


    }
}
