CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200),
    password VARCHAR(100),
    status int,
    created_At DATE
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200),
    tuition INT,
    created_At DATE
);
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_Id INT,
    appointment_date DATE,
    appointment_time TIME,
    patient VARCHAR(200),
    email VARCHAR(200),
    FOREIGN KEY (doctor_Id) REFERENCES doctors(id)
);

INSERT INTO users (name,password,status,created_At)
VALUES  ('admin@admin.com','admin',0,CURRENT_DATE),
('user@user.com','user',0,CURRENT_DATE);

INSERT INTO doctors(name,tuition,created_At)
VALUES
('Espindola, Jose',98364758,CURRENT_DATE),
('Ramirez, Luis',47328928,CURRENT_DATE),
('Arreola, Alberto',09834271,CURRENT_DATE),
('Ambriz, Amelia',92846387,CURRENT_DATE),
('Casas, Jorge',10928452,CURRENT_DATE);

INSERT INTO appointments (doctor_Id,appointment_date,appointment_time,patient,email)
VALUES
(1,'2024-04-20','10:00:00','Miguel Escalante','escalante@gmail.com'),
(2,'2024-04-25','11:00:00','Luis Perez','Perez@gmail.com'),
(3,'2024-04-26','12:00:00','Alejandro Pardo','Pardo@gmail.com'),
(4,CURRENT_DATE,'13:00:00','Guadalupe Lopez','Lopez@gmail.com'),
(5,CURRENT_DATE,'14:00:00','Mario Castillo','Castillo@gmail.com'),
(1,'2024-04-20','15:00:00','Juan Valente','Valente@gmail.com'),
(1,'2024-04-21','16:00:00','Giovanni Mendoza','Mendoza@gmail.com'),
(1,'2024-04-24','17:00:00','Miriam Mendez','Mendez@gmail.com');
