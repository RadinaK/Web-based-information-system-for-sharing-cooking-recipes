-- user roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

-- some test users
INSERT INTO users (id, age, full_name, password, username)
VALUES (1, 28, 'Admin Adminov', '12345', 'admin');

INSERT INTO users (id, age, full_name, password, username)
VALUES (3, 30, 'User Userov', '12345', 'user');

-- user roles
-- admin
INSERT INTO users_role (`user_entity_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_role (`user_entity_id`, `roles_id`)
VALUES (1, 2);
-- moderator
INSERT INTO users_role (`user_entity_id`, `roles_id`)
VALUES (2, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (2, 3);
-- user
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (3, 3);
-- user 2
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (4, 3);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (4, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (4, 1);

-- categories
INSERT INTO categories (id, description, name)
VALUES ('1', 'Tracks for pedestrians.', 'PEDESTRIAN');
INSERT INTO categories (id, description, name)
VALUES ('2', 'Tracks for cars.', 'CAR');
INSERT INTO categories (id, description, name)
VALUES ('3', 'Tracks for motorcycles.', 'MOTORCYCLE');
INSERT INTO categories (id, description, name)
VALUES ('4', 'Tracks for bicycles.', 'BICYCLE');
