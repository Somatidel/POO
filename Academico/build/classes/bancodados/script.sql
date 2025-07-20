DROP DATABASE IF EXISTS
CREATE DATABASE academico;
USE academico;

CREATE TABLE curso (
   sigla        CHAR(3) PRIMARY KEY,
   nome         VARCHAR(60),
   coordenador  VARCHAR(45)
);

CREATE TABLE aluno (
    pront           CHAR(9) PRIMARY KEY,
    nome            VARCHAR(60),
    ano_ingresso    INT,
    curso           CHAR(3),
    FOREIGN KEY (sigla_curso) REFERENCES curso  (sigla)
);

INSERT INTO curso VALUES ("BCC", 
        "Bacharelado em Ciência da Computação",
        "Kleber" );

SELECT * FROM curso;

INSERT INTO curso VALUES ("ADS", 
        "Análise e Desenvolvimento de Sistemas",
        "Andrea" );

UPDATE curso SET coordenador="Vilson",
                 nome="dfsdfsfsdfsfs" 
             WHERE sigla="ADS";
