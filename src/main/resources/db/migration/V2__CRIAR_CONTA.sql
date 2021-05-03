CREATE TABLE tb_conta (
	id_conta int4 NOT NULL,
	numero_conta char(6) NOT NULL,
	numero_agencia char(4) NOT NULL,
	dt_abertura timestamp NOT NULL,
	saldo DOUBLE PRECISION,
	primary key(id_conta),
	id_cliente int4 NOT NULL,
	CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente)
);