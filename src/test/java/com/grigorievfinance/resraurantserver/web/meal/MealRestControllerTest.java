package com.grigorievfinance.resraurantserver.web.meal;

import com.grigorievfinance.resraurantserver.repository.MealRepository;
import com.grigorievfinance.resraurantserver.web.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MealRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = MealRestController.REST_URL + '/';

    @Autowired
    private MealRepository mealRepository;

    @Test
    void get() throws Exception {

    }

    @Test
    void delete() throws Exception {

    }

    @Test
    void getAll() throws Exception {

    }

    @Test
    void update() throws Exception {

    }

    @Test
    void createWithLocation() throws Exception {

    }
}