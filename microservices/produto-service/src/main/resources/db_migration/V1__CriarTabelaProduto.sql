CREATE TABLE produto
(
    id serial NOT NULL,
    marca text NOT NULL,
    modelo text NOT NULL,
    valor numeric(10, 2) NOT NULL,
    PRIMARY KEY (id)
);