INSERT INTO users (name, email, password, cost_amount)
VALUES ('User', 'user@gmail.com', '{noop}password', 2005),
       ('Admin', 'admin@gmail.com', '{noop}admin', 1900);

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO meals (date_time, name, description, calories, price, cooking_time, user_id)
VALUES ('2020-01-30 10:00:00', 'Burger', 'burger description', 500, 200.00, 10, 1),
       ('2020-01-30 10:00:00', 'Pizza', 'pizza description', 300, 120.00, 30, 1),
       ('2020-01-30 10:00:00', 'Salad', 'salad description', 400, 100.00, 15, 1),
       ('2020-01-31 13:00:00', 'Soup', 'soup description', 200, 250.00, 35, 2),
       ('2020-01-31 13:00:00', 'Coffee', 'coffee description', 100, 50.00, 5, 2);