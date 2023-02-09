package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MealDaoImpl implements MealDao {

    public static List<Meal> meals = Arrays.asList(
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
            new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
    );

    public final static int CALORIES_PER_DAY = 2000;
    public static List<MealTo> mealsTo = MealsUtil.filteredByStreams(meals, LocalTime.of(0, 0), LocalTime.of(23, 59), CALORIES_PER_DAY);

    @Override
    public void addMeal(MealTo mealTo) {
        mealsTo.add(mealTo);
    }

    @Override
    public void deleteMeal(MealTo mealTo) {
        mealsTo.remove(mealTo);
    }

    @Override
    public void updateMeal(MealTo mealTo, Integer id) {
        MealTo mealToRemove = null;
        for (MealTo meal:mealsTo) {
            if (meal.getMealId()==id) {
                mealToRemove = meal;
            }
        }
        mealsTo.remove(mealToRemove);
        mealsTo.add(mealTo);
    }

    @Override
    public List<MealTo> getAllMeals() {

        Integer idCounter=1;
        for (MealTo meal:mealsTo) {
            meal.setMealId(idCounter);
            idCounter++;
        }
        return mealsTo;
    }

    @Override
    public MealTo getMealById(Integer mealId) {
        MealTo mealWithId = null;
        for (MealTo meal:mealsTo) {
            if (meal.getMealId()==mealId) {
                mealWithId = meal;
            }
        }
        return mealWithId;
    }
}
