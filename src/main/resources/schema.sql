--CREATE SCHEMA  cadastro;
--USE cadastro;


DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  ativo tinyint(1) DEFAULT '1',
  data datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ;


DROP TABLE IF EXISTS   endereco;

CREATE TABLE endereco (
  id int(11) NOT NULL AUTO_INCREMENT,
  cep varchar(45) DEFAULT NULL,
  endereco varchar(300) DEFAULT NULL,
  bairro varchar(300) DEFAULT NULL,
  usuario_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),

  CONSTRAINT usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;



