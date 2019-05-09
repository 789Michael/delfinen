DROP TABLE IF EXISTS RESULTATER;
DROP TABLE IF EXISTS TRÆNINGSTIDER;
DROP TABLE IF EXISTS STÆVNE;
DROP TABLE IF EXISTS MEDLEM;

CREATE TABLE MEDLEM (
	ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    MNAME VARCHAR(30) NOT NULL,
    ALDER DATE,
    TLFNO VARCHAR(8) NOT NULL,
    AKTIV BIT NOT NULL,
    KONTIGENT DATE NOT NULL
);

CREATE TABLE TRÆNINGSTIDER (
	ID INTEGER NOT NULL,
    BRYST INTEGER,
    BRYSTDATO DATE,
    BFLY INTEGER,
    BFDATO DATE,
    CRAWL INTEGER,
    CRAWLDATO DATE,
    RCRAWL INTEGER,
    RCRAWLDATO DATE,
    FOREIGN KEY (ID) REFERENCES MEDLEM(ID)
);

CREATE TABLE STÆVNE (
	SID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    SNAVN VARCHAR(255) NOT NULL
);

CREATE TABLE RESULTATER (
	SID INTEGER NOT NULL,
    ID INTEGER NOT NULL,
    BRYST INTEGER,
    BPLADS INTEGER,
    BFLY INTEGER,
    BFPLADS INTEGER,
    CRAWL INTEGER,
    CPLADS INTEGER,
    RCRAWL INTEGER,
    RCPLADS INTEGER,
    FOREIGN KEY (ID) REFERENCES MEDLEM(ID),
    FOREIGN KEY (SID) REFERENCES STÆVNE(SID)
);

# Opretter medlemmer til "medlem" tabellen
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Per Birkerød", "1995-06-15", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Kirsten Juhl", "1982-10-7", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Aske Thorsen", "2003-10-12", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Casper Thomassen", "1930-12-24", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Allan Simonsen", "2007-11-14", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Malthe Woschek", "1983-02-07", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Andreas Petersen", "1996-08-19", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Max Pepsi", "2008-02-14", "12345678", 1, "2019-05-06");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Palle", "2005-3-12", "12345678", 1, "2019-3-12");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Peter Pedal", "2001-3-12", "12345678", 1, "2019-1-1");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Per", "1998-3-12", "12345678", 1, "2019-4-12");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Casper", "1970-3-12", "12345678", 1, "2018-2-12");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Allan", "1950-3-12", "12345678", 1, "2018-1-12");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Aske", "1998-3-12", "12345678", 1, "2018-12-12");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Malthe", "2005-3-12", "12345678", 0, "2018-4-14");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Christina", "1919-3-12", "12345678", 0, "2018-2-4");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("Fie", "1970-3-12", "12345678", 0, "2019-3-12");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("MORTY", "2005-3-12", "12345678", 1, "2018-4-14");
insert into medlem (mname, alder, tlfno, aktiv, kontigent) values ("RICK", "1970-3-12", "12345678", 0, "2018-4-14");
# Opretter træningstider til "træningstider" tabellen
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (1, 40, "2012-04-13", 250, "2010-11-02", 35, "2017-07-18", 20, "2017-05-21");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (2, 80, "2012-04-13", 330, "2010-11-02", 53, "2017-07-18", 88, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (3, 145, "2012-04-13", 210, "2010-11-02", 47, "2017-07-18", 74, "2013-01-01");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (4, 42, "2012-04-13", 420, "2010-11-02", 10, "2001-05-13", 71, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (5, 67, "2012-04-13", 234, "2010-11-02", 29, "2017-07-18", 72, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (6, 87, "2012-04-13", 278, "2010-11-02", 31, "2017-07-18", 68, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (7, 98, "2012-04-13", 335, "2010-11-02", 135, "2017-07-18", 201, "2017-05-21");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (8, 65, "2012-04-13", 336, "2010-11-02", 153, "2017-07-18", 188, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (9, 146, "2012-04-13", 431, "2010-11-02", 147, "2017-07-18", 174, "2013-01-01");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (10, 142, "2012-04-13", 420, "2010-11-02", 110, "2001-05-13", 171, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (11, 267, "2012-04-13", 365, "2010-11-02", 219, "2017-07-18", 172, "2016-05-24");
insert into træningstider (id, bryst, brystdato, bfly, bfdato, crawl, crawldato, rcrawl, rcrawldato) values (12, 387, "2012-04-13", 398, "2010-11-02", 311, "2017-07-18", 168, "2016-05-24");







# Opretter stævner til brug af at kunne oprette resultater
insert into stævne (snavn) values ("DGI Byen 2018");
insert into stævne (snavn) values ("Brøndby 2016");
insert into stævne (snavn) values ("DM 2017");
insert into stævne (snavn) values ("DM 2001");

# Opretter resultater for 'DGI Byen 2018' stævnet
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (1, 1, 41, 4, 0, 0, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (1, 2, 0, 0, 57, 3, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (1, 3, 0, 0, 0, 0, 35, 2, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (1, 4, 0, 0, 0, 0, 0, 0, 48, 2);

# Opretter resultater for 'Brøndby 2016' stævnet
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (2, 1, 44, 5, 0, 0, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (2, 2, 0, 0, 60, 4, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (2, 3, 0, 0, 0, 0, 40, 6, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (2, 4, 0, 0, 0, 0, 0, 0, 52, 4);

# Opretter resultater for 'DM 2017' stævnet
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (3, 1, 42, 3, 0, 0, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (3, 2, 0, 0, 59, 3, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (3, 3, 0, 0, 0, 0, 38, 3, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (3, 4, 0, 0, 0, 0, 0, 0, 49, 3);

# Opretter resultater for 'DGI Byen 2018' stævnet
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (4, 1, 41, 4, 0, 0, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (4, 2, 0, 0, 57, 3, 0, 0, 0, 0);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (4, 3, 36, 4, 0, 0, 35, 2, 10, 8);
insert into resultater (sid, id, bryst, bplads, bfly, bfplads, crawl, cplads, rcrawl, rcplads) values (4, 4, 0, 0, 41, 1, 0, 0, 48, 2);
