USE proyecto_alkemy;

INSERT INTO `proyecto_alkemy`.`user` (`dni`, `file`, `user_type`)
VALUES 
('10000000', '123', 'admin'),
('20000000', '321', 'student');

INSERT INTO `proyecto_alkemy`.`professor` (`active`, `dni`, `last_name`, `name`)
VALUES 
('1', '34740000', 'Matto', 'Rodrigo'),
('1', '37481211', 'Sala', 'Karen'),
('1', '36852147', 'Matto', 'Sergio'),
('2', '52147963', 'Moreira', 'Graciela');

INSERT INTO `proyecto_alkemy`.`subject` (`active`, `availability`, `capacity`, `day`, `description`, `name`, `professorId`, `schedule`, `professor_id`)
VALUES 
('1', '30', '30', 'Lunes', 'Esto es Base de Datos I', 'Base de Datos I', '1', 'Tarde', '1'),
('1', '50', '50', 'Martes', 'Esto es Introduccion al Diselo Grafico', 'Introduccion al Diseño Grafico', '1', 'Noche', '2'),
('0', '30', '30', 'Lunes', 'Esto es Inlges nivel I', 'Ingles Nivel I', '3', 'Mañana', '3'),
('1', '40', '40', 'Jueves', 'Esto es Programacion Web I', 'Programacion Web I', '2', 'Mañana', '2');

