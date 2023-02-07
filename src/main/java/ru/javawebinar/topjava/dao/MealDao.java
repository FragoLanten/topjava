package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealDao {
    public void addMeal();

    public void deleteMeal(MealTo meal);

    public void updateMeal();

    public List<MealTo> getAllMeals();

    public MealTo getMealById(Integer mealID);
}
