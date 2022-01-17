INSERT INTO `usuarios`(username, password, enabled, nombre, apellido, email) VALUES ('Andres', '123456', 1, 'Andres', 'Guzman', 'yyy@gmail.com');
INSERT INTO `usuarios`(username, password, enabled, nombre, apellido, email) VALUES ('Admin', '3456789', 1, 'Alejandro', 'Gutierrez', 'xxx@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);