package com.grigorievfinance.resraurantserver;

import com.grigorievfinance.resraurantserver.model.Meal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MealTestData {
    public static final TestMatcher<Meal> MEAL_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Meal.class, "user");

    public static final int MEAL1_ID = 1;
    public static final int ADMIN_MEAL_ID = 4;

    public static final Meal meal1 = new Meal(MEAL1_ID, "Burger", LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "burger description", 500, BigDecimal.valueOf(200.00).setScale(2, RoundingMode.UNNECESSARY), 10);
    public static final Meal meal2 = new Meal(MEAL1_ID + 1, "Pizza", LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "pizza description", 300, BigDecimal.valueOf(120.00).setScale(2, RoundingMode.UNNECESSARY), 30);
    public static final Meal meal3 = new Meal(MEAL1_ID + 2, "Salad", LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "salad description", 400, BigDecimal.valueOf(100.00).setScale(2, RoundingMode.UNNECESSARY), 15);
    public static final Meal adminMeal1 = new Meal(ADMIN_MEAL_ID, "Soup", LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "soup description", 200, BigDecimal.valueOf(250.00).setScale(2, RoundingMode.UNNECESSARY), 35);
    public static final Meal adminMeal2 = new Meal(ADMIN_MEAL_ID + 1, "Coffee", LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "coffee description", 100, BigDecimal.valueOf(50.00).setScale(2, RoundingMode.UNNECESSARY), 5);

    public static final List<Meal> meals = List.of(meal1, meal2, meal3);
    public static final List<Meal> adminMeals = List.of(adminMeal1, adminMeal2);

    public static Meal getNew() {
        return new Meal(null, "New meal", LocalDateTime.of(2020, Month.FEBRUARY, 1, 18, 0), "New meal description", 700, BigDecimal.valueOf(500.00).setScale(2, RoundingMode.UNNECESSARY), 40);
    }

    public static Meal getUpdated() {
        return new Meal(MEAL1_ID, "Updated meal", meal1.getDateTime().plus(2, ChronoUnit.MINUTES), "Updated meal description", 800, BigDecimal.valueOf(700).setScale(2, RoundingMode.UNNECESSARY), 45);
    }
}
