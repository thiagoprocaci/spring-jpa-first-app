CREATE TABLE `passatempo` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

CREATE TABLE `pessoa` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `idade` smallint(6) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `id_passatempo` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `passatempo_FK` (`id_passatempo`),
  CONSTRAINT `passatempo_FK` FOREIGN KEY (`id_passatempo`) REFERENCES `passatempo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE myDB.pais (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

alter table myDB.pessoa add CONSTRAINT pais_fk FOREIGN KEY (id_pais)  REFERENCES myDB.pais(id)