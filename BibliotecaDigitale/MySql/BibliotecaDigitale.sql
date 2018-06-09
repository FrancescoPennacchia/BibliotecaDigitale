DROP DATABASE IF EXISTS BibliotecaDigitale;
CREATE DATABASE IF NOT EXISTS BibliotecaDigitale;
USE BibliotecaDigitale;


#DROP TABLE IF EXISTS utente;
CREATE TABLE `utente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `email` varchar(35) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `titolo_di_studi` varchar(30) NOT NULL,
  `professione` varchar(20) NOT NULL,
  `residenza` varchar(30) NOT NULL,
  `mansione` char(20) NOT NULL,
  UNIQUE(id),
  PRIMARY KEY (`id`)
);


#Inserimento Utenti
INSERT INTO `utente` (`id`, `username`, `password`, `email`, `nome`, `cognome`, `data_di_nascita`, `titolo_di_studi`, `professione`, `residenza`, `mansione`) VALUES
(1, 'admin', '$2a$12$Nec9uFfcG3FnMkWySG83k.MRMZjfs4fRTM9DXhiXmaA2AfufavoRm', 'remolabarca@sempre.it', 'Remo', 'La Barca','1985-12-12', 'Nautico', 'Remare la barca', 'Oceano', 'admin'),
(2, 'Pippo', '$2a$12$Nec9uFfcG3FnMkWySG83k.MRMZjfs4fRTM9DXhiXmaA2AfufavoRm', 'pippo@sempre.it', 'Pippo', 'LBhu','1958-10-12', 'uploader', 'uploader', 'Pippolandia', 'uploader'),
(3, 'Pluto', '$2a$12$Nec9uFfcG3FnMkWySG83k.MRMZjfs4fRTM9DXhiXmaA2AfufavoRm', 'Plutoa@sempre.it', 'Pluto', 'Bhu','1985-12-12', 'transcriber', 'transcriber', 'Oceano', 'transcriber'),
(4, 'Utente', '$2a$12$Nec9uFfcG3FnMkWySG83k.MRMZjfs4fRTM9DXhiXmaA2AfufavoRm', 'utente@sempre.it', 'Paperino', 'Piccolino','1990-10-15', 'Nautico', 'Remare la barca', 'Oceano', 'utente');


USE BibliotecaDigitale;
CREATE TABLE `categoria_opera` (
	`cod_categoria` int(11) NOT NULL AUTO_INCREMENT,
    `categoria` varchar(30) NOT NULL,
	PRIMARY KEY (`cod_categoria`)
);

#Inserimento Categorie
INSERT INTO `categoria_opera` (`cod_categoria`, `categoria`) VALUES
(1, 'Commedia');


CREATE TABLE `opera` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `anno` int(4) NOT NULL,
  `autore` varchar(60) NOT NULL,
  `cod_categoria` int(11) NOT NULL,
  UNIQUE(cod),
  PRIMARY KEY (`cod`),
  FOREIGN KEY (cod_categoria) REFERENCES categoria_opera(cod_categoria) ON DELETE NO ACTION ON UPDATE CASCADE
);

#Inserimento Opere
INSERT INTO `opera` (`nome`, `anno` , `autore`, `cod_categoria`) VALUES ('Prova Opera', 1958, 'Remo La Barca', 1);


DROP TABLE IF EXISTS `pagine_opera`;
CREATE TABLE `pagine_opera` (
	`cod_pagina` int(11) NOT NULL AUTO_INCREMENT,
    `immagine_pagina` mediumblob NOT NULL,
    `trascrizione` varchar(350) NULL,
    `cod_opera` int(11) NOT NULL,
	`numero_pagina` int (11) NOT NULL,
	PRIMARY KEY (`cod_pagina`),
     FOREIGN KEY (`cod_opera`) REFERENCES opera(cod) ON DELETE CASCADE ON UPDATE CASCADE
);




#INSERT INTO `pagine_opera` (`immagine_pagina` , `cod_opera`) VALUES (0x30, 1);



