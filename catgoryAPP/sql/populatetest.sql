
INSERT INTO catgory(title,parentid)
VALUES('Electronics',NULL);

INSERT INTO catgory(title,parentid)
VALUES('Laptops & PC',1);

INSERT INTO catgory(title,parentid)
VALUES('Laptops',2);
INSERT INTO catgory(title,parentid)
VALUES('PC',2);

INSERT INTO catgory(title,parentid)
VALUES('Cameras & photo',1);
INSERT INTO catgory(title,parentid)
VALUES('Camera',5);

INSERT INTO catgory(title,parentid)
VALUES('Phones & Accessories',1);
INSERT INTO catgory(title,parentid)
VALUES('Smartphones',7);

INSERT INTO catgory(title,parentid)
VALUES('Android',8);
INSERT INTO catgory(title,parentid)
VALUES('iOS',8);
INSERT INTO catgory(title,parentid)
VALUES('Other Smartphones',8);

INSERT INTO catgory(title,parentid)
VALUES('Batteries',7);
INSERT INTO catgory(title,parentid)
VALUES('Headsets',7);
INSERT INTO catgory(title,parentid)
VALUES('Screen Protectors',7);



INSERT INTO inventory(name,catgoryid)
VALUES('alleianware',3);


INSERT INTO inventory(name,catgoryid)
VALUES('razer edge',2);

INSERT INTO inventory(name,catgoryid)
VALUES('lenovo',3);

INSERT INTO inventory(name,catgoryid)
VALUES('Iphone',10);

INSERT INTO inventory(name,catgoryid)
VALUES('samsung',8);

INSERT INTO inventory(name,catgoryid)
VALUES('huawei',9);






WITH RECURSIVE catgory_ (id, title, ) AS
(
  SELECT id, title, title as
    FROM catgory
    WHERE parentid IS NULL
  UNION ALL
  SELECT c.id, c.title, CONCAT(cp., ' > ', c.title)
    FROM catgory_ AS cp JOIN catgory AS c
      ON cp.id = c.parentid
)
SELECT * FROM catgory_
ORDER BY ;



SELECT * from inventory
INNER JOIN catgory ON
inventory.catgoryid=catgory.id;



WITH RECURSIVE catgory_ (id, title, parentid) AS
(
  SELECT id, title, parentid
    FROM catgory
    WHERE title = 'Electronics' -- child node
  UNION ALL
  SELECT c.id, c.title, c.parentid
    FROM catgory_ AS cp JOIN catgory AS c
      ON cp.id = c.parentid
)
SELECT * FROM catgory_
ORDER BY id;

SELECT * FROM catgory WHERE  LIKE 1%;

SELECT * FROM catgory WHERE parentid;

"WITH RECURSIVE catgory_ (id, title, parentid) AS("+
  "SELECT id, title, parentid"+
    "FROM catgory"+
    "WHERE title = ?" +
  "UNION ALL"+
  "SELECT c.id, c.title, c.parentid"+
    "FROM catgory_ AS cp JOIN catgory AS c"+
      "ON cp.id = c.parentid"+
")SELECT * FROM catgory_"+
"ORDER BY id"
