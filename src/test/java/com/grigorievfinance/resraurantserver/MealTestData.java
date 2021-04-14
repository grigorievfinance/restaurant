package com.grigorievfinance.resraurantserver;

import com.grigorievfinance.resraurantserver.model.Meal;

public class MealTestData {
    public static final TestMatcher<Meal> MEAL_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Meal.class, "user");

    public static final int MEAL1_ID = 1;
    public static final int ADMIN_MEAL_ID = 8;


}
