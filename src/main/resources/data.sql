INSERT INTO users (name, email, password, cost_amount)
VALUES ('User', 'user@gmail.com', '{noop}password', 2005),
       ('Admin', 'admin@gmail.com', '{noop}admin', 1900);

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO meals (date_time, name, description, calories, price, cooking_time, user_id)
VALUES ('2020-01-30 10:00:00', 'Завтрак', 'описание завтрака', 500, 200, 30, 1);