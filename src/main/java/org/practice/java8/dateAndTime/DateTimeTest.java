package org.practice.java8.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DateTimeTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDateTime.get(ChronoField.HOUR_OF_AMPM));
        System.out.println(localDateTime.get(ChronoField.HOUR_OF_AMPM));

        List<Integer> numbers = new ArrayList<>();
        numbers.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(localDate.plusMonths(1).plusDays(1));

    }
}
