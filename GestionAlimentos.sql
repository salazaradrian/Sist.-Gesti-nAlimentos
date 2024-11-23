create database GestionAlimentos;

CREATE TABLE Alimentos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    calorias DECIMAL(10, 2) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    estado ENUM("DISPONIBLE", "AGOTADO", "PROXIMO_A_VENCER") NOT NULL
);

INSERT INTO Alimentos (nombre, tipo, calorias, precio, estado) VALUES ("Pollo", "Proteina", 165.05, 4350, "DISPONIBLE");

SELECT * FROM Alimentos;
