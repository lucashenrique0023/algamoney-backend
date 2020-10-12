CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN NOT NULL,
	logradouro VARCHAR(50),
	numero INT(5),
	complemento VARCHAR(50),
	bairro VARCHAR(50),
	cep VARCHAR(8),
	cidade VARCHAR(50),
	estado VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ("Lucas", true, "Rua Inacio Galvao dos Santos", 196, "Apt 13", "Encruzilhada", "52041210", "Recife", "Pernambuco");

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ("Naiara", true, "Rua Edson Regis", 30, null, "Janga", "23432343", "Paulista", "Pernambuco");

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ("Joao", true, "Na Rua", null, null, "Boa Vista", null, "Recife", "Pernambuco");

