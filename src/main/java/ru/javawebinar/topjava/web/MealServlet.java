package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(UserServlet.class);

    private final MealDao mealDao;

    public MealServlet() {
        mealDao = new MealDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to users");

//        String action = request.getParameter("action");
//
//        if (action.equalsIgnoreCase("delete")) {
//            int mealId = Integer.parseInt(request.getParameter("mealId"));
//            MealTo meal = mealDao.getMealById(mealId);
//            mealDao.deleteMeal(meal);
//        }

        request.setAttribute("meals", mealDao.getAllMeals());

        request.getRequestDispatcher("meals.jsp").forward(request, response);
//        response.sendRedirect("users.jsp");
    }
}
