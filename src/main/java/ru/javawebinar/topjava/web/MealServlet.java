package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/MealServlet")
public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(UserServlet.class);

    private final MealDao mealDao;

    public MealServlet() {
        mealDao = new MealDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to users");

        if (request.getParameter("action")!=null) {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("delete")) {
                int mealId = Integer.parseInt(request.getParameter("id"));
                MealTo meal = mealDao.getMealById(mealId);
                mealDao.deleteMeal(meal);
            }
            else if (action.equalsIgnoreCase("edit")) {
                int mealId = Integer.parseInt(request.getParameter("id"));
                MealTo meal = mealDao.getMealById(mealId);
                mealDao.updateMeal(meal, 1);
            }
        }



        request.setAttribute("meals", mealDao.getAllMeals());

        request.getRequestDispatcher("meals.jsp").forward(request, response);
//        response.sendRedirect("users.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MealTo mealTo = new MealTo();

        mealTo.setDateTime(LocalDateTime.parse(request.getParameter("mealDatetime")));
        mealTo.setDescription(request.getParameter("mealDescription"));
        mealTo.setCalories(Integer.parseInt(request.getParameter("mealCalories")));
        mealDao.addMeal(mealTo);

        request.setAttribute("meals", mealDao.getAllMeals());
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }
}
