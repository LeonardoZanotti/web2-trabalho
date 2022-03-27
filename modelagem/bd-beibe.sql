-- Database: SAC_BEIBE

-- DROP DATABASE IF EXISTS "SAC_BEIBE";

CREATE DATABASE "SAC_BEIBE"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
CREATE TABLE Estado (
    idEstado SERIAL PRIMARY KEY,
    nome VARCHAR (30) NOT NULL,
    sigla VARCHAR (2) NOT NULL
);

CREATE TABLE Cidade (
    idCidade SERIAL PRIMARY KEY,
    idEstado INTEGER REFERENCES Estado (idEstado),
    nome VARCHAR (30) NOT NULL
);

CREATE TABLE Endereco (
    idEndereco SERIAL PRIMARY KEY,
    idCidade INTEGER REFERENCES Cidade (idCidade),
    rua VARCHAR (50) NOT NULL,
    numero INTEGER NOT NULL,
    complemento VARCHAR (50) NOT NULL,
    bairro VARCHAR (20) NOT NULL,
    CEP VARCHAR(9) NOT NULL
);

CREATE TABLE Usuario (
    idUsuario SERIAL PRIMARY KEY,
    idEndereco INTEGER REFERENCES Endereco (idEndereco),
    primeiroNome VARCHAR (50) NOT NULL,
    sobreNome VARCHAR(50) NOT NULL,
    dataNascimento DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone1 VARCHAR (30) NOT NULL,
    telefone2 VARCHAR (30),
    cargo INTEGER NOT NULL
    email VARCHAR (50) NOT NULL, -- TODO: Separar 
    senha VARCHAR (50) NOT NULL -- TODO: Separar 
);

CREATE TABLE CategoriaProduto (
    idCategoria SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL
);

CREATE TABLE Produto (
    idProduto SERIAL PRIMARY KEY,
    idCategoria INTEGER REFERENCES CategoriaProduto (idCategoria),
    nome VARCHAR (50) NOT NULL,
    descricao VARCHAR (50) NOT NULL,
    peso FLOAT NOT NULL,
);

CREATE TABLE Atendimento (
    idAtendimento SERIAL PRIMARY KEY,
    dataHoraInicio TIMESTAMP NOT NULL,
    dataHoraFim TIMESTAMP NOT NULL,
    tipoAtendimento VARCHAR (50) NOT NULL,   
    reclamacao VARCHAR (200) NOT NULL,
    solucao VARCHAR (200),
    situacao VARCHAR (30) NOT NULL,
    idUsuario INTEGER REFERENCES Usuario (idUsuario),
    idProduto INTEGER REFERENCES Produto (idProduto)
);
