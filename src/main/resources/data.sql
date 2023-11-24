--use cooking_recipes10;
-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'USER');
INSERT INTO roles (id, role)
VALUES (2, 'ADMIN');

-- some test users
--INSERT INTO users (id, age, full_name, password, username)
--VALUES (1, 28, 'Admin Adminov', '12345', 'admin');
--
--INSERT INTO users (id, age, full_name, password, username)
--VALUES (2, 30, 'User Userov', '12345', 'user');
--
--INSERT INTO users (id, age, full_name, password, username)
--VALUES (3, 26, 'Pesho Peshev', '12345', 'pesho');

-- user roles
-- admin
--INSERT INTO users_roles (`user_id`, `roles_id`)
--VALUES (1, 1);
--INSERT INTO users_roles (`user_id`, `roles_id`)
--VALUES (1, 2);
--INSERT INTO users_roles (`user_id`, `roles_id`)
--VALUES (2, 2);


-- ingredients
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('1', 'NONE',  '0.89', 'банан');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('2', 'NONE',  '3.84', 'брашно от елда');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('3', 'NUTS', '0.21', 'бадемово мляко');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('4', 'NONE',  '3.26', 'стафиди');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('5', 'NONE',  '0.05', 'джинджифил');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('6', 'NONE',  '0.05', 'индийско орехче');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('7', 'NONE',  '0.25', 'карфиол');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('8', 'NONE',  '0.40', 'лук');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('9', 'NONE',  '8.05', 'бяло вино');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('10', 'NONE',  '0.00', 'вода');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('11', 'NONE',  '8.98', 'гхи');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('12', 'NONE',  '2.7', 'кленов сироп');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('13', 'MILK',  '43.14', 'пармезан');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('14', 'EGGS',  '15.51', 'яйце');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('15', 'NONE',  '0.00', 'сол');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('16', 'NONE',  '2.51', 'черен пипер');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('17', 'NONE',  '2.82', 'червен пипер');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('18', 'FISH',  '11.60', 'сьомга');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('19', 'NONE',  '28.20', 'агнешко месо');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('20', 'NONE',  '19.20', 'говеждо месо');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('21', 'NONE',  '11.40', 'заешко месо');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('22', 'NONE',  '9.02', 'свинска мас');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('23', 'NONE',  '26.30', 'свинско месо');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('24', 'NONE',  '16.00', 'авокадо');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('25', 'NONE',  '0.15', 'краставица');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('26', 'NONE',  '0.41', 'морков');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('27', 'NONE',  '0.16', 'репички');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('28', 'NONE',  '0.23', 'спанак');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('29', 'NONE',  '1.49', 'чесън');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('30', 'NONE',  '0.50', 'вишни');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('31', 'NONE',  '8.84', 'зехтин');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('32', 'NONE',  '0.48', 'кайсия');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('33', 'NONE',  '0.29', 'лимон');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('34', 'NONE',  '0.32', 'ягоди');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('35', 'NONE',  '0.39', 'праскова');

INSERT INTO measure_units (id, type)
VALUES ('1', 'TEASPOON');
INSERT INTO measure_units (id, type)
VALUES ('2', 'TABLESPOON');
INSERT INTO measure_units (id, type)
VALUES ('3', 'CUP');
INSERT INTO measure_units (id, type)
VALUES ('4', 'MILLILITER');
INSERT INTO measure_units (id, type)
VALUES ('5', 'GRAM');
INSERT INTO measure_units (id, type)
VALUES ('6', 'LITER');
INSERT INTO measure_units (id, type)
VALUES ('7', 'KILOGRAM');


--INSERT INTO recipes(id, cooking_time, description, name_category, servings, title, cook_id)
--VALUES ('1', '20',
--'Slice half of the apple into rounds, removing the seeds from the center. Place the apple rounds on a heated pan, greased with 1 tsp of coconut oil,
--and sprinkle with 1 tbsp of coconut sugar. Mix the pancake batter ingredients in a bowl. Flip the apples to caramelize them on the other side.
--Reduce the heat to 6/7 of the maximum setting. Use a spoon to scoop the pancake batter onto the apples in the pan, forming a large circle.
--Cook for 2-3 minutes on each side or until they firm up and can be easily flipped. Arrange them on a plate, lining them up side by side.
--Cut the remaining part of the apple into cubes and place them in a small saucepan with water, maple syrup, and cinnamon.
--Cook for about 5 minutes until they soften and lightly caramelize.
--Decorate the pancakes with the apples and maple syrup. You can sprinkle with chopped nuts for extra flavor and decoration.',
--'BREAKFAST', '1', 'Pancakes', '1');


--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('1', '40', '1', '5', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('2', '50', '2', '5', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('3', '50', '3', '4', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('4', '1', '4', '2', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('5', '0.5', '5', '1', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('6', '0.25', '6', '1', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('7', '0.25', '7', '1', '1');
--INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
--VALUES ('8', '0.5', '8', '1', '1');
