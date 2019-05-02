DROP TABLE IF EXISTS catgory, inventory;

CREATE TABLE catgory (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  parentid int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (parentid) REFERENCES catgory (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE inventory (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  catgoryid int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (catgoryid) REFERENCES catgory (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
