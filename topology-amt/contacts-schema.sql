DROP database IF EXISTS contacts;
CREATE database contacts;
create user 'adm'@'localhost' identified by 'adm';
grant all privileges on contacts.* TO 'adm'@'localhost';

USE contacts;

CREATE TABLE contacts (
  id int NOT NULL AUTO_INCREMENT,
  nom varchar(15) NOT NULL,
  telephone int NOT NULL,
  PRIMARY KEY  (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into contacts (nom,telephone) values ('Pierre',1234);
insert into contacts (nom,telephone) values ('Sylvie',1111);
