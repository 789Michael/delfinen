DROP TABLE IF EXISTS MEDLEM;
DROP TABLE IF EXISTS KONKURRENCESVØMMER;
DROP TABLE IF EXISTS TRÆNINGSTIDER;
DROP TABLE IF EXISTS STÆVNETIDER;

CREATE TABLE MEDLEM (
	ID INTEGER NOT NULL AUTO_INCREMENT,
    MNAME VARCHAR(30) NOT NULL,
    ALDER DATE,
    TLFNO VARCHAR(8) NOT NULL,
    PRIMARY KEY (ID)
);

insert into medlem (mname, alder, tlfno) values ("Per Birkerød", "1995-06-15", "12345678");
insert into medlem (mname, alder, tlfno) values ("Kirsten Juhl", "1982-10-7", "12345678");
insert into medlem (mname, alder, tlfno) values ("Aske Thorsen", "2003-10-12", "12345678");
insert into medlem (mname, alder, tlfno) values ("Casper Thomassen", "1930-12-24", "12345678");
insert into medlem (mname, alder, tlfno) values ("Allan Simonsen", "2007-11-14", "12345678");
insert into medlem (mname, alder, tlfno) values ("Malthe Woschek", "1983-02-07", "12345678");
insert into medlem (mname, alder, tlfno) values ("Andreas Petersen", "1996-08-19", "12345678");
insert into medlem (mname, alder, tlfno) values ("Max Pepsi", "2008-02-14", "12345678");

