CREATE TABLE cambio
(
    id serial NOT NULL,
    origem character(3) NOT NULL,
    destino character(3) NOT NULL,
    fator numeric(15, 5) NOT NULL,
    PRIMARY KEY (id)
);