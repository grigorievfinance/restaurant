package com.grigorievfinance.resraurantserver;

import com.grigorievfinance.resraurantserver.model.Role;
import com.grigorievfinance.resraurantserver.model.User;
import com.grigorievfinance.resraurantserver.util.JsonUtil;


import java.util.Collections;
import java.util.Date;

import static com.grigorievfinance.resraurantserver.MealTestData.adminMeals;
import static com.grigorievfinance.resraurantserver.MealTestData.meals;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTestData {
    public static final TestMatcher<User> USER_MATCHER = TestMatcher.usingIgnoringFieldsComparator(User.class, "registered", "meals", "password");

    public static TestMatcher<User> USER_WITH_MEALS_MATCHER = TestMatcher.usingAssertions(User.class,
            (a,e) -> assertThat(a).usingRecursiveComparison().ignoringFields("registered", "meals.user", "password").isEqualTo(e),
            (a,e) -> {
                throw new UnsupportedOperationException();
            });

    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;
    public static final int NOT_FOUND = 100;

    public static final User user = new User(USER_ID, "User", "user@gmail.com", "password", 2005, Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", 1900, Role.ADMIN, Role.USER);

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", 1555, false, new Date(), Collections.singleton(Role.USER));
    }

    static {
        user.setMeals(meals);
        admin.setMeals(adminMeals);
    }

    public static User getUpdated() {
        User updated = new User(user);
        updated.setName("UpdatedName");
        updated.setCostAmount(330);
        updated.setPassword("newPass");
        updated.setEnabled(false);
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }

    public static String jsonWithPassword(User user, String passw) {
        return JsonUtil.writeAdditionProps(user, "password", passw);
    }
}
