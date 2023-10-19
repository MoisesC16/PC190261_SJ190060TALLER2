-- Creacion de Base de Datos
CREATE DATABASE cautobdd;
USE cautobdd;

-- Creacion Tabla Clientes
CREATE TABLE clientes (
id_cliente INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre_cliente VARCHAR(50) NOT NULL,
apellido_cliente VARCHAR(50) NOT NULL,
dui_cliente VARCHAR(10) NOT NULL,
pin_cliente VARCHAR(4) NOT NULL
);

-- Creacion Tabla cuentas
CREATE TABLE cuentas (
n_cuenta INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_cliente INT(11) NOT NULL,
s_cliente decimal(10,2) NOT NULL,
INDEX (id_cliente),
FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Creacion Tabla Transacciones
CREATE TABLE transacciones (
id_transaccion INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
n_cuenta INT(11) NOT NULL,
monto_transaccion DOUBLE NOT NULL,
a_saldo DECIMAL(10,2) NOT NULL,
d_saldo DECIMAL(10,2) NOT NULL,
detalle VARCHAR(255) NOT NULL,
INDEX(n_cuenta),
FOREIGN KEY (n_cuenta) REFERENCES cuentas(n_cuenta)
);


-- Alimentamos las tablas para que no empiece vacia en el programa
INSERT INTO clientes (id_cliente, nombre_cliente, apellido_cliente, dui_cliente, pin_cliente) VALUES
(1, "Moises","Cabrera","06089783-1","2612"),
(2, "Victoria","Sura","06891243-3","1234"),
(3, "Carlos","Perez", "90987856-8","4321"),
(4, "Margarita","Jimenez","89786572-1","6789");

INSERT INTO cuentas (n_cuenta, id_cliente, s_cliente) VALUES
(1,1,"0.00"),
(2,2,"150.00"),
(3,1,"90.00"),
(4,1,"700.00"),
(5,3,"0.00"),
(6,4,"175.00");

INSERT INTO transacciones (id_transaccion, n_cuenta, monto_transaccion, a_saldo, d_saldo, detalle) VALUES
(1, 1, "90.00", "700.00", "790.00", "Deposito"),
(2, 2, "-150.00", "300.00", "150.00", "Retiro"),
(3, 4, "175.00", "0.00", "175.00", "Deposito");

SET GLOBAL FOREIGN_KEY_CHECKS=1;