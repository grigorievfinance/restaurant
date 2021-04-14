package com.grigorievfinance.resraurantserver.web.user;

import com.grigorievfinance.resraurantserver.repository.UserRepository;
import com.grigorievfinance.resraurantserver.web.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AdminRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = AdminRestController.REST_URL + '/';

    @Autowired
    private UserRepository userRepository;

    @Test
    void get() throws Exception {

    }

    @Test
    void getWithMeals() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void createWithLocation() {
    }

    @Test
    void update() {
    }

    @Test
    void getByEmail() {
    }

    @Test
    void enable() {
    }
}