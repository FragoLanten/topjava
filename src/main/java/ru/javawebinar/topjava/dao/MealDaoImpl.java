package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

public class MealDaoImpl implements MealDao {
    @Override
    public void addMeal() {

    }

    @Override
    public void deleteMeal() {

    }

    @Override
    public void updateMeal() {

    }

    @Override
    public List<MealTo> getAllMeals() {
        Integer idCounter = 1;
        for (MealTo mealsWithExceeded:MealsUtil.mealsTo) {
            mealsWithExceeded.setMealId(idCounter);
            idCounter++;
        }
        return MealsUtil.mealsTo;
    }

    @Override
    public MealTo getMealByMeal() {
        return null;
    }
}
