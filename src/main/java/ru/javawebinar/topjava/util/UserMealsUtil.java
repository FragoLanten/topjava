package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 600),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 400),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 310)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(14, 0), 2000);
        mealsTo.forEach(System.out::println);

        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExcess> list = new ArrayList<>();
        Map<Integer,Integer> dayMap = new HashMap<>();
        for (UserMeal meal:meals) {
            int currentDay = meal.getDateTime().getDayOfMonth();
            dayMap.merge(currentDay, meal.getCalories(), Integer::sum);
        }
        for (UserMeal meal:meals) {
            LocalTime localTime = meal.getDateTime().toLocalTime();
            int currentDay = meal.getDateTime().getDayOfMonth();
            boolean exceed = caloriesPerDay<dayMap.get(currentDay);
            if (localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
                list.add(new UserMealWithExcess(meal.getDateTime(), meal.getDescription(), meal.getCalories(), exceed));
            }
        }
        return list;
    }


    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExcess> list = new ArrayList<>();
        Map<Integer,Integer> dayMap = new HashMap<>();
        meals.forEach((meal)->dayMap.merge(meal.getDateTime().getDayOfMonth(), meal.getCalories(), Integer::sum));
        meals.forEach((meal)->{
            if (meal.getDateTime().toLocalTime().isAfter(startTime)&&(meal.getDateTime().toLocalTime().isBefore(endTime))) {
                list.add(new UserMealWithExcess(meal.getDateTime(), meal.getDescription(), meal.getCalories(), caloriesPerDay<dayMap.get(meal.getDateTime().getDayOfMonth())));
            }
        });
        return list;
    }
}
