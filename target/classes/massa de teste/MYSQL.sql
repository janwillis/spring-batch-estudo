CREATE DATABASE IF NOT EXISTS appdb;

USE appdb;


-- ======================================================
--  TABELA EMPRESA
-- ======================================================
DROP TABLE IF EXISTS empresa;

CREATE TABLE empresa (
    id INT NOT NULL,
    nome VARCHAR(150) NOT NULL,
    cnpj VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

-- ======================================================
--  TABELA PESSOA
-- ======================================================
DROP TABLE IF EXISTS pessoa;
CREATE TABLE pessoa (
    id INT NOT NULL,
    nome VARCHAR(150) NOT NULL,
    data_nascimento DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    rg VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);


-- ======================================================
--  TABELA EMPREGO (RELACIONA PESSOA X EMPRESA)
-- ======================================================
DROP TABLE IF EXISTS emprego;
CREATE TABLE emprego (
    id INT NOT NULL AUTO_INCREMENT,
    pessoa_id INT NOT NULL,
    empresa_id INT NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    data_admissao DATE NOT NULL,
    salario DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_emprego_pessoa
        FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
        ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_emprego_empresa
        FOREIGN KEY (empresa_id) REFERENCES empresa(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- ======================================================
--  FIM DA ESTRUTURA
-- ======================================================


