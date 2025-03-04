BEGIN TRANSACTION;
DROP TABLE IF EXISTS `STOPS`;
CREATE TABLE IF NOT EXISTS `STOPS` (
	`id_line`	INTEGER NOT NULL,
	`id_station`	INTEGER NOT NULL,
	`id_order`	INTEGER NOT NULL,
	FOREIGN KEY(`id_line`) REFERENCES `LINES`(`id`),
	FOREIGN KEY(`id_station`) REFERENCES `STATIONS`(`id`),
	PRIMARY KEY(`id_line`,`id_station`)
);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8382,1);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8742,2);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8292,3);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8282,4);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8272,5);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8012,6);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8022,7);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8032,8);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8042,9);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8052,10);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8062,11);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8072,12);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8082,13);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8092,14);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8102,15);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8112,16);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8122,17);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8132,18);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8142,19);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8152,20);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (1,8161,21);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8764,1);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8754,2);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8742,3);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8382,4);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8372,5);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8362,6);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8352,7);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8342,8);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8332,9);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8322,10);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8312,11);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8302,12);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8042,13);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8412,14);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8422,15);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8432,16);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8442,17);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8462,18);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (2,8472,19);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8641,1);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8652,2);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8662,3);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8672,4);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8682,5);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8692,6);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8702,7);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8712,8);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8722,9);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8382,10);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8742,11);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8292,12);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8282,13);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8272,14);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8012,15);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8022,16);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8032,17);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8042,18);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8052,19);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8062,20);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8072,21);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8202,22);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8212,23);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8222,24);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8232,25);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8242,26);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8252,27);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (5,8262,28);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8833,1);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8824,2);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8814,3);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8804,4);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8794,5);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8784,6);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8774,7);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8764,8);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8754,9);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8742,10);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8382,11);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8372,12);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8362,13);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8352,14);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8342,15);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8332,16);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8322,17);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8312,18);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8302,19);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8042,20);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8412,21);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8422,22);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8432,23);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8442,24);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8462,25);
INSERT INTO `STOPS` (id_line,id_station,id_order) VALUES (6,8472,26);
DROP TABLE IF EXISTS `STATIONS`;
CREATE TABLE IF NOT EXISTS `STATIONS` (
	`id`	INTEGER,
	`name`	TEXT NOT NULL,
	PRIMARY KEY(`id`)
);
INSERT INTO `STATIONS` (id,name) VALUES (8012,'DE BROUCKERE');
INSERT INTO `STATIONS` (id,name) VALUES (8022,'GARE CENTRALE');
INSERT INTO `STATIONS` (id,name) VALUES (8032,'PARC');
INSERT INTO `STATIONS` (id,name) VALUES (8042,'ARTS-LOI');
INSERT INTO `STATIONS` (id,name) VALUES (8052,'MAELBEEK');
INSERT INTO `STATIONS` (id,name) VALUES (8062,'SCHUMAN');
INSERT INTO `STATIONS` (id,name) VALUES (8072,'MERODE');
INSERT INTO `STATIONS` (id,name) VALUES (8082,'MONTGOMERY');
INSERT INTO `STATIONS` (id,name) VALUES (8092,'JOSEPH.-CHARLOTTE');
INSERT INTO `STATIONS` (id,name) VALUES (8102,'GRIBAUMONT');
INSERT INTO `STATIONS` (id,name) VALUES (8112,'TOMBERG');
INSERT INTO `STATIONS` (id,name) VALUES (8122,'ROODEBEEK');
INSERT INTO `STATIONS` (id,name) VALUES (8132,'VANDERVELDE');
INSERT INTO `STATIONS` (id,name) VALUES (8142,'ALMA');
INSERT INTO `STATIONS` (id,name) VALUES (8152,'CRAINHEM');
INSERT INTO `STATIONS` (id,name) VALUES (8161,'STOCKEL');
INSERT INTO `STATIONS` (id,name) VALUES (8202,'THIEFFRY');
INSERT INTO `STATIONS` (id,name) VALUES (8212,'PETILLON');
INSERT INTO `STATIONS` (id,name) VALUES (8222,'HANKAR');
INSERT INTO `STATIONS` (id,name) VALUES (8232,'DELTA');
INSERT INTO `STATIONS` (id,name) VALUES (8242,'BEAULIEU');
INSERT INTO `STATIONS` (id,name) VALUES (8252,'DEMEY');
INSERT INTO `STATIONS` (id,name) VALUES (8262,'HERRMANN-DEBROUX');
INSERT INTO `STATIONS` (id,name) VALUES (8272,'SAINTE-CATHERINE');
INSERT INTO `STATIONS` (id,name) VALUES (8282,'COMTE DE FLANDRE');
INSERT INTO `STATIONS` (id,name) VALUES (8292,'ETANGS NOIRS');
INSERT INTO `STATIONS` (id,name) VALUES (8302,'TRONE');
INSERT INTO `STATIONS` (id,name) VALUES (8312,'PORTE DE NAMUR');
INSERT INTO `STATIONS` (id,name) VALUES (8322,'LOUISE');
INSERT INTO `STATIONS` (id,name) VALUES (8332,'HOTEL DES MONNAIES');
INSERT INTO `STATIONS` (id,name) VALUES (8342,'PORTE DE HAL');
INSERT INTO `STATIONS` (id,name) VALUES (8352,'GARE DU MIDI');
INSERT INTO `STATIONS` (id,name) VALUES (8362,'CLEMENCEAU');
INSERT INTO `STATIONS` (id,name) VALUES (8372,'DELACROIX');
INSERT INTO `STATIONS` (id,name) VALUES (8382,'GARE DE L''OUEST');
INSERT INTO `STATIONS` (id,name) VALUES (8412,'MADOU');
INSERT INTO `STATIONS` (id,name) VALUES (8422,'BOTANIQUE');
INSERT INTO `STATIONS` (id,name) VALUES (8432,'ROGIER');
INSERT INTO `STATIONS` (id,name) VALUES (8442,'YSER');
INSERT INTO `STATIONS` (id,name) VALUES (8462,'RIBAUCOURT');
INSERT INTO `STATIONS` (id,name) VALUES (8472,'ELISABETH');
INSERT INTO `STATIONS` (id,name) VALUES (8641,'ERASME');
INSERT INTO `STATIONS` (id,name) VALUES (8652,'EDDY MERCKX');
INSERT INTO `STATIONS` (id,name) VALUES (8662,'CERIA');
INSERT INTO `STATIONS` (id,name) VALUES (8672,'LA ROUE');
INSERT INTO `STATIONS` (id,name) VALUES (8682,'BIZET');
INSERT INTO `STATIONS` (id,name) VALUES (8692,'VEEWEYDE');
INSERT INTO `STATIONS` (id,name) VALUES (8702,'SAINT-GUIDON');
INSERT INTO `STATIONS` (id,name) VALUES (8712,'AUMALE');
INSERT INTO `STATIONS` (id,name) VALUES (8722,'JACQUES BREL');
INSERT INTO `STATIONS` (id,name) VALUES (8742,'BEEKKANT');
INSERT INTO `STATIONS` (id,name) VALUES (8754,'OSSEGHEM');
INSERT INTO `STATIONS` (id,name) VALUES (8764,'SIMONIS');
INSERT INTO `STATIONS` (id,name) VALUES (8774,'BELGICA');
INSERT INTO `STATIONS` (id,name) VALUES (8784,'PANNENHUIS');
INSERT INTO `STATIONS` (id,name) VALUES (8794,'BOCKSTAEL');
INSERT INTO `STATIONS` (id,name) VALUES (8804,'STUYVENBERGH');
INSERT INTO `STATIONS` (id,name) VALUES (8814,'HOUBA-BRUGMANN');
INSERT INTO `STATIONS` (id,name) VALUES (8824,'HEYSEL');
INSERT INTO `STATIONS` (id,name) VALUES (8833,'ROI BAUDOUIN');
DROP TABLE IF EXISTS `LINES`;
CREATE TABLE IF NOT EXISTS `LINES` (
	`id`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `LINES` (id) VALUES (1);
INSERT INTO `LINES` (id) VALUES (2);
INSERT INTO `LINES` (id) VALUES (5);
INSERT INTO `LINES` (id) VALUES (6);
DROP TABLE IF EXISTS `FAVORI`;
CREATE TABLE IF NOT EXISTS `FAVORI` (
	`Favori_Name`	TEXT NOT NULL,
	`Station_Source`	TEXT NOT NULL,
	`Station_Destination`	TEXT NOT NULL,
	PRIMARY KEY(`Favori_Name`)
);
COMMIT;