
CREATE TABLE cliente (
    id_cliente IDENTITY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    documento VARCHAR(11) NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);