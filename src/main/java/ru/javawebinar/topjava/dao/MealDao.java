package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealDao {
    public void addMeal(MealTo mealTo);

    public void deleteMeal(MealTo mealTo);

    public void updateMeal(MealTo mealTo, Integer id);

    public List<MealTo> getAllMeals();

    public MealTo getMealById(Integer mealID);
}
