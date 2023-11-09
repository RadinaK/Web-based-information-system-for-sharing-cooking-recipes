--use cooking_recipes10;
-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'USER');
INSERT INTO roles (id, role)
VALUES (2, 'ADMIN');

-- some test users
INSERT INTO users (id, age, full_name, password, username)
VALUES (1, 28, 'Admin Adminov', '12345', 'admin');

INSERT INTO users (id, age, full_name, password, username)
VALUES (2, 30, 'User Userov', '12345', 'user');

INSERT INTO users (id, age, full_name, password, username)
VALUES (3, 26, 'Pesho Peshev', '12345', 'pesho');

-- user roles
-- admin
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (1, 2);
INSERT INTO users_roles (`user_id`, `roles_id`)
VALUES (2, 2);


-- ingredients
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('1', 'NONE',  '0.89', 'banana');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('2', 'NONE',  '3.84', 'buckwheat flour');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('3', 'NUTS', '0.21', 'almond milk');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('4', 'NONE',  '3.26', 'raisins');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('5', 'NONE',  '0.05', 'ginger');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('6', 'NONE',  '0.05', 'nutmeg');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('7', 'NONE',  '0.25', 'cauliflower');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('8', 'NONE',  '0.40', 'onion');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('9', 'NONE',  '8.05', 'white wine');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('10', 'NONE',  '0.00', 'water');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('11', 'NONE',  '8.98', 'ghee');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('12', 'NONE',  '2.7', 'maple syrup');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('13', 'MILK',  '43.14', 'parmesan');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('14', 'EGGS',  '15.51', 'egg');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('15', 'NONE',  '0.00', 'salt');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('16', 'NONE',  '2.51', 'pepper');
INSERT INTO ingredients (id, allergy, calories, name)
VALUES ('17', 'NONE',  '2.82', 'paprika');

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


INSERT INTO recipes(id, cooking_time, description, name_category, servings, title, cook_id)
VALUES ('1', '20',
'Slice half of the apple into rounds, removing the seeds from the center. Place the apple rounds on a heated pan, greased with 1 tsp of coconut oil,
and sprinkle with 1 tbsp of coconut sugar. Mix the pancake batter ingredients in a bowl. Flip the apples to caramelize them on the other side.
Reduce the heat to 6/7 of the maximum setting. Use a spoon to scoop the pancake batter onto the apples in the pan, forming a large circle.
Cook for 2-3 minutes on each side or until they firm up and can be easily flipped. Arrange them on a plate, lining them up side by side.
Cut the remaining part of the apple into cubes and place them in a small saucepan with water, maple syrup, and cinnamon.
Cook for about 5 minutes until they soften and lightly caramelize.
Decorate the pancakes with the apples and maple syrup. You can sprinkle with chopped nuts for extra flavor and decoration.',
'BREAKFAST', '1', 'Pancakes', '1');

INSERT INTO pictures(id, url, recipe_id)
VALUES ('1', 'http://res.cloudinary.com/ch-cloud/image/upload/v1630581072/d47iy8kxv6qni8euhojk.jpg', '1');
INSERT INTO pictures(id, url, recipe_id)
VALUES ('2', 'http://res.cloudinary.com/ch-cloud/image/upload/v1630581418/tqhjrinmsb69ev7upg0q.jpg', '1');


INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('1', '40', '1', '5', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('2', '50', '2', '5', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('3', '50', '3', '4', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('4', '1', '4', '2', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('5', '0.5', '5', '1', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('6', '0.25', '6', '1', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('7', '0.25', '7', '1', '1');
INSERT INTO recipes_ingredients (id, amount, ingredient_id, measure_unit_id, recipe_id)
VALUES ('8', '0.5', '8', '1', '1');
