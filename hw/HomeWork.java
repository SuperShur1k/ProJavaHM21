package org.example.lesson21.hw;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println(
            getElements(List.of("Cuba", "Ecuador", "Brazil", "Canada"),1 ,2)
                          );

        // Каким днём недели был день возвращения Колумба из его первого плавания в америку?
        // 4 марта 1493
        LocalDateTime columbus = LocalDateTime.of(1493, Month.MARCH, 4, 0, 0);
        System.out.println("day of week of columbus return " + columbus.getDayOfWeek());

        // Распечатайте количество секунд, прошедшие между днем взятия Бастилии и полетом в космос Гагарина
        // бастилия 14 July 1789
        LocalDateTime bastilleDay = LocalDateTime.of(1789, Month.JULY, 14, 12, 0);
        // полет в космос
        LocalDateTime cosmos = LocalDateTime.of(1961, Month.APRIL, 12, 9,0);

        long bastilleCosmos = ChronoUnit.SECONDS.between(bastilleDay, cosmos);
        System.out.println("Between Bastille and space: " + bastilleCosmos); // 5419688400

        // То-же самое с учетом временной зоны (Париж и Байконур) - считать время взятия Бастилии полуднем,
        // время запуска ракеты лучше посмотреть в интернете
        ZonedDateTime bzdt = ZonedDateTime.of(bastilleDay, ZoneId.of("Europe/Paris"));
        ZonedDateTime szdt = ZonedDateTime.of(cosmos, ZoneId.of("Asia/Tashkent"));

        long between = ChronoUnit.SECONDS.between(bzdt, szdt);
        System.out.println("Between Bastille and space with time zones: " + between);


    } // main

    // Напишите шаблонную функцию, которая принимает на вход список чего угодно и varargs из целых.
    //
    //Нужно вернуть коллекцию из элементов, номера которых и передаются в виде varargs
    //Например, если в функцию передается список ["Cuba", "Ecuador", "Brazil", "Canada"] и
    //номера 1 и 2, то нужно вернуть коллекцию из ["Ecuador", "Brazil"]
    //На всякий случай, доступ к varargs происходит аналогично элементам массива
    public static <T> Collection<T> getElements(List<T> list, int... elements){
        return Arrays.stream(elements)
            .filter(e -> e >= 0)
            .filter(e -> e < list.size())
            .mapToObj(e -> list.get(e))
            .toList();
    }


}
